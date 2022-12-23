package ru.lyuchkov.menu;

import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Session;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.service.EducatorService;
import ru.lyuchkov.service.GroupService;
import ru.lyuchkov.service.ScheduleService;
import ru.lyuchkov.service.SerializationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel headMenu;
    private JButton addRoomButton;
    private JButton addDisciplineButton;
    private JButton addEducatorButton;
    private JButton addGroupButton;
    private JList<String> list1;
    private JButton generateButton;
    private JButton exportButton;
    private JButton findAllButton;
    private JButton showButtonEducator;
    private JComboBox<Group> comboBoxGroup;
    private JComboBox<Educator> comboBoxEducator;
    private JButton showButtonGroup;

    private DefaultListModel<String> dlm;

    @InjectByType
    RoomAddForm roomAddForm;

    @InjectByType
    EducatorAddForm educatorAddForm;

    @InjectByType
    DisciplineAddForm disciplineAddForm;

    @InjectByType
    GroupAddForm groupAddForm;

    @InjectByType
    FindAllForm findAllForm;

    @InjectByType
    ScheduleService scheduleService;

    @InjectByType
    SerializationService serializationService;

    @InjectByType
    GroupService groupService;

    @InjectByType
    EducatorService educatorService;

    public MainForm() {
        setContentPane(mainPanel);
        setTitle("Расписание занятий");
        setSize(800,800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);


        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomAddForm.setVisible(true);
            }
        });
        addDisciplineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disciplineAddForm.updateData();
                disciplineAddForm.setVisible(true);
            }
        });
        addEducatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                educatorAddForm.setVisible(true);
            }
        });
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupAddForm.updateData();
                groupAddForm.setVisible(true);
            }
        });
        findAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAllForm.updateData();
                findAllForm.setVisible(true);
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!scheduleService.generate()){
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка генерирования, возможно, недостаточно данных.",500,250);
                    errorDialogForm.setVisible(true);
                }
                dlm = new DefaultListModel<>();
                list1.setModel(dlm);

                comboBoxGroup.removeAllItems();
                List<Group> allGroups = groupService.getAll();
                for (Group g:
                        allGroups) {
                    comboBoxGroup.addItem(g);
                }
                List<Educator> allEducators = educatorService.getAll();
                comboBoxEducator.removeAllItems();
                for (Educator ed:
                        allEducators) {
                    comboBoxEducator.addItem(ed);
                }
            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serializationService.createExcelTable()) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.open(new File("src/main/resources/output"));
                        } catch (IOException ex) {
                            ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка открытия окна проводника.", 500, 250);
                            errorDialogForm.setVisible(true);
                        }
                    }
                } else{
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка записи",500,250);
                    errorDialogForm.setVisible(true);
                }
            }
        });
        showButtonGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxGroup.getSelectedItem()!=null){
                    if(!dlm.isEmpty())  dlm.removeAllElements();
                    List<Session> allByGroup = scheduleService.getAllByGroup((Group) comboBoxGroup.getSelectedItem());
                    for (Session s:
                         allByGroup) {
                        dlm.addElement(s.getTime()+"    "+s.getEducator().getExportName()+"     "+s.getDiscipline().getName()+"   "+s.getRoom().getName());
                    }
                }
            }
        });
        showButtonEducator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxEducator.getSelectedItem()!=null){
                    if(!dlm.isEmpty())  dlm.removeAllElements();
                    List<Session> allByEducator = scheduleService.getAllByEducator((Educator) comboBoxEducator.getSelectedItem());
                    for (Session s:
                            allByEducator) {
                        dlm.addElement(s.getTime()+"    "+s.getGroup().getName()+"     "+s.getDiscipline().getName()+"   "+s.getRoom().getName());
                    }
                }
            }
        });
    }
}
