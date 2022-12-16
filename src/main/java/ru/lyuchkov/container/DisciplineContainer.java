package ru.lyuchkov.container;

import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class DisciplineContainer implements Container<Discipline> {
    private final Map<Integer, Discipline> map;

    public DisciplineContainer() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Discipline findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(Discipline t) {
        if (map.containsValue(t)) map.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public void add(Discipline t) {
        map.put(t.getId(), t);
    }

    public List<Discipline> findAllWithNames(List<String> names) {
        List<Discipline> res = new ArrayList<>();
        Set<String> nameSet = new HashSet<>(names);
        for (Discipline d:
                map.values()) {
            if (nameSet.contains(d.getName()))res.add(d);
        }
        return res;
    }
}
