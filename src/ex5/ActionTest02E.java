package ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02E extends JFrame {
    int count;

    public static void main(String[] args) {
        ActionTest02E w = new ActionTest02E("ActionTest02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public ActionTest02E(String title) {
        super(title);
        JButton button = new JButton(new Action02());
        JButton button2 = new JButton(new Action02Plus());
        JButton button3 = new JButton(new Action02Zero());

        getContentPane().add(button, BorderLayout.NORTH);
        getContentPane().add(button2, BorderLayout.SOUTH);
        getContentPane().add(button3, BorderLayout.CENTER);
        System.out.println("初期値は" + count);

    }

    class Action02 extends AbstractAction {
        Action02() {
            putValue(Action.NAME, "増やす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count++;
            display();
        }
    }

    class Action02Plus extends AbstractAction {
        Action02Plus() {
            putValue(Action.NAME, "減らす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count--;
            display();
        }
    }

    class Action02Zero extends AbstractAction {
        Action02Zero() {
            putValue(Action.NAME, "クリア");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count = 0;
            display();
        }
    }

    public void display() {
        System.out.println("現在値は" + count);
    }
}

