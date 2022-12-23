package ru.lyuchkov.menu;

import ru.lyuchkov.entity.Discipline;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.DisciplineService;
import ru.lyuchkov.service.GroupService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class GroupAddForm extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel dataPanel1;
    private JLabel nameOfData;
    private JTextField groupName;
    private JPanel dataPanel2;
    private JComboBox<Discipline> disciplineComboBox;
    private JButton pickDiscipline;
    private JList<String> list;
    private JButton addButton;
    private DefaultListModel<String> dlm;

    @InjectByType
    GroupService groupService;

    @InjectByType
    DisciplineService disciplineService;

    private List<Discipline> choice = new ArrayList<>();

    public GroupAddForm()  {
        setContentPane(mainPanel);
        setTitle("Добавить  группу");
        setSize(1000,1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        dlm = new DefaultListModel<>();
        list.setModel(dlm);
        pickDiscipline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(disciplineComboBox.getSelectedItem()!=null){
                    Discipline selectedItem = (Discipline) disciplineComboBox.getSelectedItem();
                    if(!choice.contains(selectedItem)){
                        choice.add(selectedItem);
                        updateList(selectedItem.getName());
                    }else{
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Нельзя добавить одну дисциплину дважды.",500,250);
                        errorDialogForm.setVisible(true);
                    }
                }else{
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Дисциплины не выбраны.",500,250);
                    errorDialogForm.setVisible(true);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!choice.isEmpty()&&!groupName.getText().isEmpty()){
                    boolean add =groupService.add(groupName.getText(), choice);
                    if(add){
                        groupName.setText("");
                        disciplineComboBox.removeAllItems();
                        dlm.removeAllElements();
                        list.clearSelection();
                        choice.clear();
                        dispose();
                    }else{
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Название группы уже занято",500,250);
                        errorDialogForm.setVisible(true);
                    }
                }else{
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. В форме не должно быть пустых полей.",500,250);
                    errorDialogForm.setVisible(true);
                }
            }
        });
    }

    private void updateList(String name) {
        dlm.addElement(name);
    }

    public void updateData() {
        List<Discipline> all = disciplineService.getAll();
        List<String> options = new ArrayList<>();
        for (Discipline d:
                all) {
            disciplineComboBox.addItem(d);
        }
    }
}
