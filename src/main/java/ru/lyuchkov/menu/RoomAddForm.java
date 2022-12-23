package ru.lyuchkov.menu;

import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;
import ru.lyuchkov.service.RoomService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Singleton
public class RoomAddForm extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel dataPanel1;
    private JLabel nameOfData;
    private JTextField textField1;
    private JButton addButton;

    @InjectByType
    RoomService service;

    public RoomAddForm() {
        setContentPane(mainPanel);
        setTitle("Добавить аудиторию");
        setSize(300, 250);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty()) {
                    ErrorDialogForm errorDialogForm = new ErrorDialogForm("Введите значение", 200,200);
                    errorDialogForm.setVisible(true);
                } else {
                    String name = textField1.getText();
                    boolean add = service.add(name);
                    if (!add) {
                        ErrorDialogForm errorDialogForm = new ErrorDialogForm("Ошибка добавления аудитории. \nВозможно, название аудитории занято.", 400,250);
                        errorDialogForm.setVisible(true);
                    }
                    textField1.setText("");
                }
            }
        });
    }

}
