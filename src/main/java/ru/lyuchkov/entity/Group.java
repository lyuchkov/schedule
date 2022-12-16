package ru.lyuchkov.entity;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Group{
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private List<Discipline> disciplines;

    public Group(String name, List<Discipline> disciplines) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
}
