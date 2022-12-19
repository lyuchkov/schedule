package ru.lyuchkov.service;

import ru.lyuchkov.container.ScheduleRepository;
import ru.lyuchkov.genetic_algorithm.GeneticAlgorithm;
import ru.lyuchkov.genetic_algorithm.Schedule;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ScheduleService {
    final int POPULATION_SIZE = 100;
    final int GENERATIONS = 100;
    final double THRESHOLD = 1.0;

    @InjectByType
    ScheduleRepository repository;

    @InjectByType
    DataService dataService;


    public boolean generate() {
        dataService.updateData();
        if (dataService.checkForEmptyDataFields()) return false;
        Schedule schedule = new Schedule(dataService.getData());
        List<Schedule> initialPopulation = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            initialPopulation.add(schedule.randomInstance());
        }
        GeneticAlgorithm<Schedule> ga = new GeneticAlgorithm<Schedule>(initialPopulation, 0.2, 0.7, GeneticAlgorithm.SelectionType.TOURNAMENT);
        Schedule result = ga.run(GENERATIONS, THRESHOLD);

        repository.setCurrentState(result.getList());
        return result.fitness() == 1;
    }

    public ScheduleRepository getRepository() {
        return repository;
    }

    public void setRepository(ScheduleRepository repository) {
        this.repository = repository;
    }
}
