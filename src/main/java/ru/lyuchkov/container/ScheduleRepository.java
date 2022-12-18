package ru.lyuchkov.container;

import ru.lyuchkov.entity.Session;
import ru.lyuchkov.infostructure.annotations.Singleton;

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

}
