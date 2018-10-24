package ex6;

import com.sun.java.swing.action.OpenAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02F extends JFrame {
    int count;

    public static void main(String[] args) {
        ActionTest02F w = new ActionTest02F("ActionTest02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public ActionTest02F(String title) {
        super(title);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem item;
        /*
        item = new JMenuItem("増やす");
        file.add(item);
        item = new JMenuItem("減らす");
        file.add(item);
        file.addSeparator();
        item = new JMenuItem("クリア");
        file.add(item);
        */
        file.add(new AddAction());
        file.add(new ReduceAction());
        file.add(new ZeroAction());


        JButton button = new JButton(new Action02());
        JButton button2 = new JButton(new Action02Plus());
        JButton button3 = new JButton(new Action02Zero());

        getContentPane().add(button, BorderLayout.NORTH);
        getContentPane().add(button2, BorderLayout.SOUTH);
        getContentPane().add(button3, BorderLayout.CENTER);
        System.out.println("初期値は" + count);


    }

    class AddAction extends AbstractAction {
        AddAction() {
            putValue(Action.NAME, "増やす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count++;
            display();
        }
    }

    class ReduceAction extends AbstractAction {
        ReduceAction() {
            putValue(Action.NAME, "増やす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count--;
            display();
        }
    }

    class ZeroAction extends AbstractAction {
        ZeroAction() {
            putValue(Action.NAME, "減らす");
            putValue(Action.SMALL_ICON, new ImageIcon("open.gif"));
            putValue(Action.SHORT_DESCRIPTION, "ツールチップ");
        }

        public void actionPerformed(ActionEvent e) {
            count = 0;
            display();
        }
    }

    class Action02 extends AbstractAction {
        Action02() {
            putValue(Action.NAME, "クリア");
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


