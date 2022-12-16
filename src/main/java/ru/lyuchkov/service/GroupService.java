package ru.lyuchkov.service;

import ru.lyuchkov.container.GroupContainer;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.List;

@Singleton
public class GroupService {
    @InjectByType
    GroupContainer groupContainer;
    @InjectByType
    DisciplineService disciplineService;

    public GroupService() {
    }

    public boolean add(String groupName, List<String> disciplinesList){
        if(groupContainer.containsGroupWithName(groupName) ||
                groupName.isEmpty()||
                disciplinesList.isEmpty())return false;
        Group group = new Group(groupName,
                disciplineService.findAllWithNames(disciplinesList));
        groupContainer.add(group);
        return true;
    }
}
