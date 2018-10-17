package ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02C extends JFrame {
    int count;

    public static void main(String[] args) {
        ActionTest02C w = new ActionTest02C("ActionTest02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public ActionTest02C(String title) {
        super(title);
        JButton button = new JButton(new Action02());
        getContentPane().add(button, BorderLayout.NORTH);
    }

    class Action02 extends AbstractAction {
        Action02() {
            putValue(Action.NAME, "増やす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
            System.out.println("初期値は" + count);
        }

        public void actionPerformed(ActionEvent e) {
            count++;
            System.out.println("現在値は" + count);
        }
    }
}
