package ru.lyuchkov.genetic_algorithm;

import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Session;
import ru.lyuchkov.infostructure.annotations.InjectByType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Schedule extends Chromosome<Schedule>{
    private List<Session> list;

    @InjectByType
    private Data data;


    private static Random random = new Random();

    public Schedule() {
        random = new Random();
    }

    public Schedule(List<Session> list) {
        this.list = list;
        random = new Random();
        Data.init();
    }


    public Schedule randomInstance() {
       List<Session> tempList = new ArrayList<>();
        for (Group group : data.getGroups()) {
            for (Discipline discipline : group.getDisciplines()) {
                Session session = new Session(group, discipline);
                session.setTime(data.getTimes().get(random.nextInt((data.getTimes().size()))));
                session.setRoom(data.getRooms().get(random.nextInt((data.getRooms().size()))));
                session.setEducator(data.getEducators().get(random.nextInt(data.getEducators().size())));
                tempList.add(session);
            }
        }
        return new Schedule(tempList);
    }

    @Override
    public double fitness() {
        return 1.0/ (1.0+numberOfConflicts());
    }

    private double numberOfConflicts() {
        int n = 0;
        for (Session x : list) {
            for (Session y : list) {
                if (list.indexOf(y) >= list.indexOf(x)) {
                    if (x.getTime() == y.getTime() && x.getId() != y.getId()) {
                        if (x.getRoom() == y.getRoom()) n++;
                        if (x.getEducator() == y.getEducator()) n++;
                    }
                }
            }
        }
        return n;
    }

    @Override
    public List<Schedule> crossover(Schedule other) {
        Schedule child1 = new Schedule(new ArrayList<>(list));
        Schedule child2 = new Schedule(new ArrayList<>(list));
        int indx1 = random.nextInt(list.size());
        int indx2 = random.nextInt(list.size());
        Session s1 = list. get(indx1);
        Session s2 = list. get(indx2);
        int indx3 = list.indexOf(s2);
        int indx4 = other.list.indexOf(s1);
        Collections.swap(child1.list, indx1, indx3);
        Collections.swap(child1.list, indx2, indx4);
        return List.of(child1, child2);
    }

    @Override
    public void mutate() {
        int idx1 = random.nextInt(list.size());
        int idx2 = random.nextInt(list.size());
        Collections.swap(list, idx1, idx2);
    }

    @Override
    public Schedule copy() {
        return new Schedule(new ArrayList<>(list));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder( "Schedule:" );
        for (Session s:
             list) {
            builder.append(s.toString());
            builder.append("\n");
        }
        builder.append("Number of conflicts: ").append(numberOfConflicts());
        return builder.toString();
    }
}
