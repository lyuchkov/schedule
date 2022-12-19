package ru.lyuchkov.genetic_algorithm;


import ru.lyuchkov.container.MeetingTimeUtil;
import ru.lyuchkov.entity.*;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.io.Serializable;
import java.util.List;

@Singleton
public class Data{
    private List<Discipline> disciplines;
    private List<Room> rooms;
    private List<Group> groups;
    private List<Educator> educators;
    private final List<MeetingTime> times = MeetingTimeUtil.getMeetingTime();


    public Data() {
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Educator> getEducators() {
        return educators;
    }

    public List<MeetingTime> getTimes() {
        return times;
    }

    public void update(List<Discipline> disciplines,
                       List<Room> rooms,
                       List<Group> groups,
                       List<Educator> educators) {
        this.disciplines = disciplines;
        this.rooms = rooms;
        this.groups = groups;
        this.educators = educators;
    }

}
