package ex4;

import vol1.ch01.Layout01;

import javax.swing.*;
import java.awt.*;

public class Layout01D extends JFrame {
    public static void main(String[] args) {
        Layout01D w = new Layout01D("Layout01");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(350, 200);
        w.setVisible(true);
    }

    public Layout01D(String title) {
        super(title);

        JPanel pane = (JPanel) getContentPane();

        JButton northButton = new JButton("North");
        pane.add(northButton, BorderLayout.NORTH);

        JButton westButton = new JButton("West");
        pane.add(westButton, BorderLayout.WEST);

        //JButton centerPanel  = new JButton( "Center" );
        //pane.add( centerPanel, BorderLayout.CENTER );

        JButton eastButton = new JButton("East");
        pane.add(eastButton, BorderLayout.EAST);

        JButton southButton = new JButton("South");
        pane.add(southButton, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        //JPanel centerPanel = (JPanel) getContentPane();

        JButton north = new JButton("North");
        centerPanel.add(north, BorderLayout.NORTH);

        JButton west = new JButton("West");
        centerPanel.add(west, BorderLayout.WEST);

        JButton center = new JButton("Center");
        centerPanel.add(center, BorderLayout.CENTER);

        JButton east = new JButton("East");
        centerPanel.add(east, BorderLayout.EAST);

        JButton south = new JButton("South");
        centerPanel.add(south, BorderLayout.SOUTH);

        pane.add(centerPanel, BorderLayout.CENTER);
    }
}
