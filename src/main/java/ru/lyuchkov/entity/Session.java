package ru.lyuchkov.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Session {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private Group group;
    private Discipline discipline;
    private Educator educator;
    private MeetingTime time;
    private Room room;


    public Session(Group group, Discipline discipline) {
        this.id = count.incrementAndGet();
        this.group = group;
        this.discipline = discipline;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public void setTime(MeetingTime time) {
        this.time = time;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Educator getEducator() {
        return educator;
    }

    public MeetingTime getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", group=" + group.getName() +
                ", discipline=" + discipline +
                ", educator=" + educator +
                ", time=" + time +
                ", room=" + room.getName() +
                '}';
    }
}
