import org.junit.jupiter.api.Test;
import ru.lyuchkov.genetic_algorithm.Data;
import ru.lyuchkov.infostructure.Application;
import ru.lyuchkov.infostructure.ApplicationContext;
import ru.lyuchkov.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    void checkNull(){
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));

        ScheduleService scheduleService = context.getObject(ScheduleService.class);

        scheduleService.generate();
    }

    @Test
    void addDataAndGenerateSchedule(){
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));

        Data data = context.getObject(Data.class);
        ScheduleService scheduleService = context.getObject(ScheduleService.class);
        DataService dataService = context.getObject(DataService.class);
        DisciplineService disciplineService = context.getObject(DisciplineService.class);
        EducatorService educatorService = context.getObject(EducatorService.class);
        GroupService groupService = context.getObject(GroupService.class);
        RoomService roomService = context.getObject(RoomService.class);
        SerializationService serializationService = context.getObject(SerializationService.class);


        roomService.add("1101");
        roomService.add("1102");
        roomService.add("1103");


        educatorService.add("Анатолий Павлович");
        educatorService.add("Анатолий Анатольевич");
        educatorService.add("Ольга Владимировна");

        disciplineService.addByName("Математический анализ",
                new ArrayList<>(List.of("Анатолий Павлович", "Анатолий Анатольевич")));
        disciplineService.addByName("Физика",
                new ArrayList<>(List.of("Анатолий Павлович")));
        disciplineService.addByName( "Объектно-ориентированное программирование",
                new ArrayList<>(List.of("Анатолий Анатольевич","Ольга Владимировна")));

        groupService.addByName( "M011",
                new ArrayList<>(List.of("Математический анализ", "Физика","Объектно-ориентированное программирование")));
        groupService.addByName( "1301",
                new ArrayList<>(List.of("Математический анализ", "Физика")));
        groupService.addByName( "1302",
                new ArrayList<>(List.of("Математический анализ", "Физика","Объектно-ориентированное программирование")));

        scheduleService.generate();

        serializationService.createExcelTable();
    }
}
