package ru.lyuchkov;


import ru.lyuchkov.infostructure.Application;
import ru.lyuchkov.infostructure.ApplicationContext;
import ru.lyuchkov.service.ScheduleService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));

        ScheduleService scheduleService = context.getObject(ScheduleService.class);

        scheduleService.generate();


    }

}
