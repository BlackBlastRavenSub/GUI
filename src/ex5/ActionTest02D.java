package ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02D extends JFrame {
    int count;

    public static void main(String[] args) {
        ActionTest02D w = new ActionTest02D("ActionTest02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public ActionTest02D(String title) {
        super(title);
        JButton button = new JButton(new Action02());
        JButton button2 = new JButton(new Action02Plus());

        getContentPane().add(button, BorderLayout.NORTH);
        getContentPane().add(button2, BorderLayout.SOUTH);
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

    public void display() {
        System.out.println("現在値は" + count);
    }
}
