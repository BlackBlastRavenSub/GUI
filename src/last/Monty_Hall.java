package last;

import javafx.scene.layout.Pane;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Optional;
import java.util.Random;

public class Monty_Hall extends JFrame {
    int flag;
    int highScore = 0;

    public static void main(String args[]) {
        int highScore = 0;

        Monty_Hall Vision = new Monty_Hall();
        Vision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vision.setSize(700, 900);
        Vision.setVisible(true);
        //System.out.println("ようこそ!現在のハイスコアは" + highScore + "だ!");

        //システム部分
        Monty_Hall monty_hall = new Monty_Hall();
        Game game = new Game();
        game.Input(55);
        game.Input(88);
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
        int select = 0;
        int dummy;
        int stage = 0;//現在の段階

        void random() {
            Random random = new Random();
            correct = random.nextInt(99) + 1;
            do {
                dummy = random.nextInt(99) + 1;
            } while (correct != dummy);
        }

        void showHighScore() {

        }

        void Input(int num) {
            select = num;
            switch (stage) {
                case 0:
                    //最初のドア指定
                    random();
                    FirstChoice();
                    break;
                case 1:
                    //最後のドア指定
                    FinalChoice();
                    break;
            }
        }

        void FirstChoice() {
            System.out.println("あなたが選んだドアは" + select + "だ");
            if (select != correct) {
                System.out.println("そして正解のドアは" + select + "か" + correct + "だ");
            } else {
                System.out.println("そして正解のドアは" + select + "か" + dummy + "だ");
            }
            stage = 1;
        }

        void FinalChoice() {
            System.out.println("あなたが選んだドアは" + select + "だ");
            if (select != correct) {
                System.out.println("残念・・・正解のドアは" + correct + "だった・・・");
            } else {
                System.out.println("正解!" + select + "のドアが当たりだ!");
            }
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

