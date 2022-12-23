package ru.lyuchkov.menu;

import javax.swing.*;
import java.awt.*;


public class ErrorDialogForm extends JFrame{
    private JPanel panel1;
    private JLabel errorName;

    public ErrorDialogForm(String s, int width, int height) {
        setContentPane(panel1);
        setTitle("Ошибка");
        setSize(width,height);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        errorName.setText(s);
    }
}
