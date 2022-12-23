package ru.lyuchkov.menu;

import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Room;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.DisciplineService;
import ru.lyuchkov.service.EducatorService;
import ru.lyuchkov.service.GroupService;
import ru.lyuchkov.service.RoomService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Singleton
public class FindAllForm extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JList<String> roomList;
    private JList<String> educatorsList;
    private JList<String> disciplineList;
    private JList<String> groupList;

    @InjectByType
    RoomService roomService;

    @InjectByType
    EducatorService educatorService;

    @InjectByType
    DisciplineService disciplineService;

    @InjectByType
    GroupService groupService;

    public FindAllForm()  {
        setContentPane(mainPanel);
        setTitle("Посмотреть все записи");
        setSize(1200, 1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void updateData(){
        DefaultListModel<String> roomsDlm = new DefaultListModel<>();
        List<Room> all = roomService.getAll();
        for (Room r:
             all) {
            roomsDlm.addElement(r.getId()+" "+r.getName());
        }
        roomList.setModel(roomsDlm);

        DefaultListModel<String> educatorsDlm = new DefaultListModel<>();
        List<Educator> allEducator = educatorService.getAll();
        for (Educator e:
                allEducator) {
            educatorsDlm.addElement(e.getId()+" "+e.getExportName());
        }
        educatorsList.setModel(educatorsDlm);

        DefaultListModel<String> discipDlm = new DefaultListModel<>();

        List<Discipline> allDisciplines = disciplineService.getAll();
        for (Discipline d:
                allDisciplines) {
            discipDlm.addElement(d.getName());
        }

        disciplineList.setModel(discipDlm);

        DefaultListModel<String> groupDlm = new DefaultListModel<>();

        List<Group> allGroups = groupService.getAll();
        for (Group g:
                allGroups) {
            groupDlm.addElement(g.getName());
        }

        groupList.setModel(groupDlm);
    }
}
