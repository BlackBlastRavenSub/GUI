package ex10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest01D extends JFrame {
    JPanel pane;

    public static void main(String[] args) {
        JListTest01D w = new JListTest01D("JListTest01");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public JListTest01D(String title) {
        super(title);
        String[] choice = {"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888"};
        /*
        JList jList = new JList(choice);
        jList.addListSelectionListener(new ListListener());
        JScrollPane scrollPane = new JScrollPane(jList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    */
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < choice.length; i++) {
            model.addElement(choice[i]);
        }
        JList jList = new JList(model);
        jList.addListSelectionListener(new ListListener());
        JScrollPane scrollPane = new JScrollPane(jList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    class ListListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            JList list = (JList) event.getSource();
            System.out.println(list.getSelectedValue());
        }
    }
}