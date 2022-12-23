package ru.lyuchkov.menu;

import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.EducatorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Singleton
public class EducatorAddForm extends JFrame {
    private JPanel mainPanel;
    private JPanel dataPanel1;
    private JLabel nameOfData;
    private JTextField textField1;
    private JButton addButton;

    @InjectByType
    EducatorService educatorService;

    public EducatorAddForm() {
        setContentPane(mainPanel);
        setTitle("Добавить преподавателя");
        setSize(400,300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty()) {
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Введите значение", 200,200);
                    errorDialogForm.setVisible(true);
                } else {
                    boolean add = educatorService.add(textField1.getText());
                    if (!add) {
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления. \nВозможно, имя занято.",350,250);
                        errorDialogForm.setVisible(true);
                    }
                    textField1.setText("");
                }
            }
        });
    }
}
