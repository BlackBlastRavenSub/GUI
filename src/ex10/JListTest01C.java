package ex10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class JListTest01C extends JFrame {
    JPanel pane;

    public static void main(String[] args) {
        JListTest01C w = new JListTest01C("JListTest01");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public JListTest01C(String title) {
        super(title);
        String[] choice = {"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888"};
        JScrollPane scrollPane = new JScrollPane(new JList<>(choice));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
