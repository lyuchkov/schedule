package ru.lyuchkov.menu;

import ru.lyuchkov.entity.Educator;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.DisciplineService;
import ru.lyuchkov.service.EducatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DisciplineAddForm extends JFrame {
    private JPanel topPanel;
    private JPanel dataPanel1;
    private JLabel nameOfData;
    private JTextField discipName;
    private JButton addButton;
    private JPanel mainPanel;
    private JPanel dataPanel2;
    private JComboBox<Educator> educatorsComboBox;
    private JButton pickEducator;
    private JList<String> list;
    private DefaultListModel<String> dlm;

    @InjectByType
    EducatorService educatorService;

    @InjectByType
    DisciplineService disciplineService;

    private List<Educator> choice = new ArrayList<>();

    public DisciplineAddForm() {
        configWindow();

        pickEducator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(educatorsComboBox.getSelectedItem()!=null){
                    Educator selectedItem = (Educator) educatorsComboBox.getSelectedItem();
                    if (!choice.contains(selectedItem)) {
                        choice.add(selectedItem);
                        updateList(selectedItem.getExportName());
                    } else {
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Нельзя добавить одного преподавателя дважды.",500,250);
                        errorDialogForm.setVisible(true);
                    }
                }else{
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Преподаватель не выбран.",500,250);
                    errorDialogForm.setVisible(true);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!choice.isEmpty()&&!discipName.getText().isEmpty()){
                        boolean add =disciplineService.add(discipName.getText(), choice);
                        if(add){
                            discipName.setText("");
                            educatorsComboBox.removeAllItems();
                            dlm.removeAllElements();
                            list.clearSelection();
                            choice.clear();
                            dispose();
                    }else{
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. Название дисциплины уже занято",500,250);
                        errorDialogForm.setVisible(true);
                    }
                }else{
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. В форме не должно быть пустых полей.",500,250);
                    errorDialogForm.setVisible(true);
                }



            }
        });
    }
    public void updateData(){
        dlm = new DefaultListModel<>();
        list.setModel(dlm);
        List<Educator> all = educatorService.getAll();
        for (Educator e:
                all) {
                educatorsComboBox.addItem(e);
        }
    }
    private void updateList(String name){
        dlm.addElement(name);
    }


    private void configWindow(){
        setContentPane(mainPanel);
        setTitle("Добавить  дисциплину");
        setSize(600,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        dlm = new DefaultListModel<>();
        list.setModel(dlm);


    }
}
