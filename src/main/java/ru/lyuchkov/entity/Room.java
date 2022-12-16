package ru.lyuchkov.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;

    public Room(String name) {
        this.id = count.incrementAndGet();
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
