package ru.lyuchkov.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Discipline {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private final String name;
    private final List<Educator> educatorList;

    public Discipline(String name, List<Educator> educatorList) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.educatorList = educatorList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Educator> getEducators() {
        return educatorList;
    }

    @Override
    public String toString() {
        return name;
    }
}
