package ru.lyuchkov.container;

import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class GroupContainer implements Container<Group> {
    private final Map<Integer, Group> map;

    public GroupContainer() {
        map = new ConcurrentHashMap<>();
    }

    @Override
    public Group findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(Group t) {
        if (map.containsValue(t)) map.remove(t.getId());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public void add(Group t) {
        map.put(t.getId(), t);
    }

    public boolean containsGroupWithName(String s) {
        for (Group g:
                map.values()) {
            if (g.getName().equals(s))return true;
        }
        return false;
    }
}
