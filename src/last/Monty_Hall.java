package last;

import javafx.scene.layout.Pane;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Optional;

public class Monty_Hall extends JFrame {

    public static void main(String args[]) {
        Monty_Hall Vision = new Monty_Hall();
        Vision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vision.setSize(700, 900);
        Vision.setVisible(true);
    }

    public Monty_Hall() {
        JPanel pane = (JPanel) getContentPane(); // コンテントペインを得る
        JPanel buttonPane = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            buttonPane.add(new JButton("Door" + (i + 1)));
        }
        pane.add(buttonPane, BorderLayout.CENTER);
        buttonPane.setSize(700, 700);

        JTextField textField = new JTextField();
        pane.add(textField, BorderLayout.SOUTH);
        textField.setEditable(false);
        textField.setBackground(Color.white);
        textField.setSize(700, 200);
        setVisible(true);
    }
}
