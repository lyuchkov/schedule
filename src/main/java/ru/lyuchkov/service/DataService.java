package ru.lyuchkov.service;

import ru.lyuchkov.genetic_algorithm.Data;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

@Singleton
public class DataService {
    @InjectByType
    Data data;

    @InjectByType
    DisciplineService disciplineService;

    @InjectByType
    EducatorService educatorService;

    @InjectByType
    GroupService groupService;

    @InjectByType
    RoomService roomService;


    public void updateData() {
        data.update(disciplineService.getALl(),
                roomService.getAll(),
                groupService.getAll(),
                educatorService.getAll());
    }

    public Data getData() {
        return data;
    }

    public boolean checkForEmptyDataFields() {
        return data.getEducators().isEmpty() ||
                data.getGroups().isEmpty() ||
                data.getDisciplines().isEmpty() ||
                data.getTimes().isEmpty() ||
                data.getRooms().isEmpty();
    }
}
