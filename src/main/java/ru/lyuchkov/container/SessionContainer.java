package ru.lyuchkov.container;

import ru.lyuchkov.entity.Session;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class SessionContainer implements Container<Session>{
    private Map<Integer, Session> map;

    public SessionContainer() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Session findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(Session t) {
        if (map.containsValue(t)) map.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public void add(Session t) {
        map.put(t.getId(), t);
    }


}
