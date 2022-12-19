package ru.lyuchkov.entity;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Educator {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private final String name;
    private final String exportName;

    public Educator(String name) {
        this.id = count.incrementAndGet();
        this.name = id+ "   "+name;
        exportName = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getExportName() {
        return exportName;
    }
}
