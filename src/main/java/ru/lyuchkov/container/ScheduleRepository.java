package ru.lyuchkov.container;

import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Session;
import ru.lyuchkov.genetic_algorithm.Data;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.DataService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ScheduleRepository {
    List<Session> currentState;

    public ScheduleRepository() {
        currentState = new ArrayList<>();
    }
    public void setCurrentState(List<Session> list){
        currentState = list;
    }

    public List<Session> getCurrentState() {
        return currentState;
    }

    public List<Session> getAllByGroup(Group g) {
        List<Session> res = new ArrayList<>();
        for (Session s:
             currentState) {
            if(s.getGroup()==g) res.add(s);
        }
        return res;
    }

    public List<Session> getAllByEducator(Educator e) {
        List<Session> res = new ArrayList<>();
        for (Session s:
                currentState) {
            if(s.getEducator()==e) res.add(s);
        }
        return res;
    }
}
