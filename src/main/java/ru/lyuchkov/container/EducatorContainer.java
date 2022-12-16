package ru.lyuchkov.container;

import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class EducatorContainer implements Container<Educator> {
    private Map<Integer, Educator> map;

    public EducatorContainer() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Educator findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(Educator t) {
        if (map.containsValue(t)) map.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public void add(Educator t) {
        map.put(t.getId(), t);
    }

    public boolean containsEducatorWithName(String s) {
        for (Educator e:
                map.values()) {
            if (e.getName().equals(s))return true;
        }
        return false;
    }

    public List<Educator> getAll() {
        return new ArrayList<>(map.values());
    }

    public List<Educator> findAllWithNames(List<String> names) {
        List<Educator> res = new ArrayList<>();
        Set<String> nameSet = new HashSet<>(names);
        for (Educator e:
                map.values()) {
            if (nameSet.contains(e.getName()))res.add(e);
        }
        return res;
    }
}
