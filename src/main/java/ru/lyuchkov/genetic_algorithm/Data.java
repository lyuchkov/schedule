package ru.lyuchkov.genetic_algorithm;

import ru.lyuchkov.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Discipline> disciplines;
    private static List<Room> rooms;
    private static List<Group> groups;
    private static List<Educator> educators;
    private static List<MeetingTime> times;


    //todo plan how to init data class for current container instance
    public Data() {
        init();
    }


    public static void init() {
        Room room1 = new Room( "1101");
        Room room2 = new Room( "1102");
        Room room3 = new Room( "1103");
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        Educator educator1 = new Educator( "Анатолий Павлович");
        Educator educator2 = new Educator( "Анатолий Анатольевич");
        Educator educator3 = new Educator( "Ольга Владимировна");
        List<Educator> educators = new ArrayList<>();
        educators.add(educator1);
        educators.add(educator2);
        educators.add(educator3);

        Discipline discipline1 = new Discipline( "Математический анализ", educators.subList(0,1));
        Discipline discipline2 = new Discipline( "Физика", educators.subList(0,0));
        Discipline discipline3 = new Discipline( "Объектно-ориентированное программирование", educators.subList(1,2));
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(discipline1);
        disciplines.add(discipline2);
        disciplines.add(discipline3);

        Group group1 = new Group( "M011", disciplines.subList(0,2));
        Group group2 = new Group( "1301", disciplines.subList(0,1));
        Group group3 = new Group( "1302", disciplines);
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        List<MeetingTime> meetingTimes = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                meetingTimes.add(new MeetingTime(i,j));
            }
        }
        Data.disciplines = disciplines;
        Data.rooms = roomList;
        Data.groups = groups;
        Data.educators = educators;
        Data.times = meetingTimes;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public  List<Group> getGroups() {
        return groups;
    }

    public  List<Educator> getEducators() {
        return educators;
    }

    public List<MeetingTime> getTimes() {
        return times;
    }
}
