package ru.lyuchkov.service;

import ru.lyuchkov.container.DisciplineContainer;
import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.List;

@Singleton
public class DisciplineService {
    @InjectByType
    DisciplineContainer disciplineContainer;
    @InjectByType
    EducatorService educatorService;

    public DisciplineService() {
    }

    public boolean add(String courseName, List<String> educatorList){
        if(courseName.isEmpty()|| educatorList.isEmpty()) return false;
        Discipline discipline = new Discipline(courseName,
                educatorService.findAllWithNames(educatorList));
        disciplineContainer.add(discipline);
        return true;
    }

    public List<Discipline> findAllWithNames(List<String> names) {
        return disciplineContainer.findAllWithNames(names);
    }
}
