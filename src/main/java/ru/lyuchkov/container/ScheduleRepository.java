package ru.lyuchkov.container;

import ru.lyuchkov.entity.Session;
import ru.lyuchkov.genetic_algorithm.Data;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.DataService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ScheduleRepository {
    List<Session> currentState;

    public ScheduleRepository() {
        currentState = new ArrayList<>();
    }
    public void setCurrentState(List<Session> list){
        currentState = list;
    }

    public List<Session> getCurrentState() {
        return currentState;
    }
}
