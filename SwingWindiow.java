package ru.knaur.oxana.znamen;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwingWindiow {
    private JButton start;
    private JButton edit;
    private JButton clear;
    private JPanel panel;

    public void init() {
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // выбор скрина из стиля ОС
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        start = new JButton("Открыть");
        start.setSize(190, 30);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.addActionListener(new ActionButton());
        edit = new JButton("Преобразовать");
        edit.setSize(190, 30);
        edit.setAlignmentX(Component.CENTER_ALIGNMENT);
        edit.addActionListener(new ActionButton());
        clear = new JButton("Очистить");
        clear.setSize(190, 30);
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear.addActionListener(new ActionButton());


        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(start);
        panel.add(edit);
        panel.add(clear);


        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(200, 120);
        jf.add(panel);
        jf.setVisible(true);
    }

}
