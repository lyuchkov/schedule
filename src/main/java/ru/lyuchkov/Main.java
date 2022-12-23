package ru.lyuchkov;


import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.infostructure.Application;
import ru.lyuchkov.infostructure.ApplicationContext;
import ru.lyuchkov.menu.DisciplineAddForm;
import ru.lyuchkov.menu.EducatorAddForm;
import ru.lyuchkov.menu.GroupAddForm;

import ru.lyuchkov.menu.MainForm;
import ru.lyuchkov.service.DisciplineService;
import ru.lyuchkov.service.EducatorService;
import ru.lyuchkov.service.GroupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public Main() {
    }

    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));
        EducatorService educatorService = context.getObject(EducatorService.class);
        educatorService.add("Анатолий Павлович");
        educatorService.add("Анатолий Анатольевич");
        educatorService.add("Ольга Владимировна");

        DisciplineService disciplineService = context.getObject(DisciplineService.class);
        disciplineService.addByName("Математика", new ArrayList<>(List.of("Анатолий Павлович")));
        disciplineService.addByName("Математический анализ",
                new ArrayList<>(List.of("Анатолий Павлович", "Анатолий Анатольевич")));
        disciplineService.addByName("Физика",
                new ArrayList<>(List.of("Анатолий Павлович")));
        disciplineService.addByName( "Объектно-ориентированное программирование",
                new ArrayList<>(List.of("Анатолий Анатольевич","Ольга Владимировна")));
        GroupService groupService = context.getObject(GroupService.class);
        groupService.addByName( "M011",
                new ArrayList<>(List.of("Математический анализ", "Физика","Объектно-ориентированное программирование")));
        groupService.addByName( "1301",
                new ArrayList<>(List.of("Математический анализ", "Физика")));
        groupService.addByName( "1302",
                new ArrayList<>(List.of("Математический анализ", "Физика","Объектно-ориентированное программирование")));
        MainForm mainForm = context.getObject(MainForm.class);

        mainForm.setVisible(true);

    }

}
