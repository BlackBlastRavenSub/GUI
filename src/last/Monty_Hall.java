package last;

import javafx.scene.layout.Pane;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Optional;

public class Monty_Hall extends JFrame {
    int flag;

    public static void main(String args[]) {

        Monty_Hall Vision = new Monty_Hall();
        Vision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vision.setSize(700, 900);
        Vision.setVisible(true);

        //システム部分
        Monty_Hall monty_hall = new Monty_Hall();
        Game game = new Game();
        for(;;){
            if(monty_hall.flag==1){
                System.out.println("移れ");
            }
        }

    }


    public Monty_Hall() {
        JPanel pane = (JPanel) getContentPane(); // コンテントペインを得る
        JPanel buttonPane = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            buttonPane.add(new JButton(new Door("Door" + (i + 1))));
        }
        pane.add(buttonPane, BorderLayout.CENTER);
        buttonPane.setSize(700, 700);

        JTextField textField = new JTextField(200);
        pane.add(textField, BorderLayout.SOUTH);
        textField.setEditable(false);
        textField.setBackground(Color.white);
        textField.setSize(700, 200);
        setVisible(true);
    }

    static class Game {
        int correct;
        int select;
        int dummy;
        int stage = 0;//現在の段階

        void Input() {
            switch (stage) {
                case 0:
                    //最初のドア指定
                    FirstChoice();
                    break;
                case 1:
                    //最後のドア指定
                    FinalChoice();
                    break;
            }
        }

        void FirstChoice() {

        }

        void FinalChoice() {
        }
    }

    class Door extends AbstractAction {
        Door(String num) {
            putValue(Action.NAME, num);
        }

        public void actionPerformed(ActionEvent e) {
            String num = (String) getValue(Action.NAME);
            System.out.println(num);
            flag = 1;
        }
    }
}

