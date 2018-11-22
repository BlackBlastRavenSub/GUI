package ex10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class JListTest01B extends JFrame {
    JPanel pane;

    public static void main(String[] args) {
        JListTest01B w = new JListTest01B("JListTest01");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 200);
        w.setVisible(true);
    }

    public JListTest01B(String title) {
        super(title);
        pane = (JPanel) getContentPane();
        String[] choice = {"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888"};
        pane.add(new JList<>(choice));
        //pane.add( new JButton( new JList01B( "JList01" ) ), BorderLayout.NORTH );
    }
}
