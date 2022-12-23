import org.junit.jupiter.api.Test;
import ru.lyuchkov.infostructure.Application;
import ru.lyuchkov.infostructure.ApplicationContext;
import ru.lyuchkov.menu.RoomAddForm;

import java.util.HashMap;
import java.util.Map;

public class RoomAddFormTest {
    @Test
    void manualAddRoom(){
        ApplicationContext context = Application.run("ru.lyuchkov",
                new HashMap<>(Map.of()));
        RoomAddForm roomAddForm = context.getObject(RoomAddForm.class);

    }
}
