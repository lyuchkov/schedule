package ru.lyuchkov;

import ru.lyuchkov.entity.genetic_algorithm.*;
import ru.lyuchkov.genetic_algorithm.GeneticAlgorithm;
import ru.lyuchkov.genetic_algorithm.Schedule;
import ru.lyuchkov.infostructure.Application;
import ru.lyuchkov.infostructure.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));

        GeneticAlgorithm<Schedule> ga = context.getObject(GeneticAlgorithm.class);

    }

}
