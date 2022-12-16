package ru.lyuchkov.container;

import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class RoomContainer implements Container<Room>{
    private Map<Integer,Room> map;

    public RoomContainer() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Room findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(Room t) {
        if (map.containsValue(t)) map.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public void add(Room t) {
        map.put(t.getId(), t);
    }

    public boolean containsRoomWithName(String s){
        for (Room r:
             map.values()) {
            if (r.getName().equals(s))return true;
        }
        return false;
    }

    public List<Room> getAll() {
        return new ArrayList<>(map.values());
    }
}
