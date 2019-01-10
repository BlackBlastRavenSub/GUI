package last;

import javafx.scene.layout.Pane;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Monty_Hall extends JFrame {
    boolean tag;
    int key;
    Boolean gameClear;
    int flag;
    int highScore = 0;
    String text = "現在のハイスコアは" + String.valueOf(highScore) + "だ!";
    Game game = new Game();
    JLabel textField = new JLabel();
    JScrollPane jScrollPane = new JScrollPane();

    JButton[][] jButtonList;

    public static void main(String args[]) {
        Monty_Hall Vision = new Monty_Hall();
        Vision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vision.setSize(700, 900);
        Vision.setVisible(true);
        //System.out.println("ようこそ!現在のハイスコアは" + highScore + "だ!");

        //システム部分

        // game.Input(55);
        //game.Input(88);
    }


    public Monty_Hall() {
        try {
            InputStream data = new FileInputStream("highscore.txt");
            InputStreamReader tmp = new InputStreamReader(data);
            BufferedReader reader = new BufferedReader(tmp);
            highScore = Integer.parseInt(reader.readLine());
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        JPanel pane = (JPanel) getContentPane(); // コンテントペインを得る
        enableEvents(AWTEvent.KEY_EVENT_MASK); // キーイベントを有効に
        jScrollPane.setViewportView(textField);
        JPanel buttonPane = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            buttonPane.add(new JButton(new Door("Door" + (i + 1))));
        }
        pane.add(buttonPane, BorderLayout.CENTER);
        buttonPane.setSize(700, 700);

        pane.add(jScrollPane, BorderLayout.SOUTH);
        //textField.setFont(new Font("",Font.PLAIN,80));
        textField.setBorder(new EmptyBorder(200, 10, 10, 10));
        //textField.setEditable(false);
        textField.setBackground(Color.white);
        textField.setSize(700, 200);
        setVisible(true);
        textField.setText("ようこそ!現在のハイスコアは" + highScore + "だ!");
    }

/*
    String setTextField(String input) {
        return getTextField() + input;
    }

    public JTextField getTextField() {
        return textField;
    }
    */

    class Game {
        int correct;
        int select = 0;
        int dummy;
        int stage = 0;//現在の段階
        int score = 0;

        void random() {
            Random random = new Random();
            correct = random.nextInt(99) + 1;
            do {
                dummy = random.nextInt(99) + 1;
            } while (correct != dummy);
        }

        void showHighScore() {

        }

        void showText(String input) {
            String output;
            text = "<html>" + textField.getText() + "<br>" + input + "<html>";
            textField.setText(text);
            //System.out.println(text);
            // textField.setText("ここに文字を書く<br>改行後<html>");
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
            if (!tag) {
                showText("ようこそ!現在のハイスコアは" + highScore + "だ!");
            }
            showText("あなたが選んだドアは" + select + "だ");
            if (select != correct) {
                showText("そして正解のドアは" + select + "か" + correct + "だ");
            } else {
                showText("そして正解のドアは" + select + "か" + dummy + "だ");
            }
            stage = 1;
        }

        void FinalChoice() {
            showText("あなたが選んだドアは" + select + "だ");
            if (select != correct) {
                GameOver();
            } else {
                GameClear();
            }
        }

        void GameClear() {
            score++;
            gameClear = true;
            key = 0;
            showText("正解!" + select + "のドアが当たりだ!");
            //showText("スペースキーで続行:Qキーでハイスコアを保存して終了");
            showText("次のステージ!");
            reset();
            //Scanner s = new Scanner(System.in);
            String key = "q"; //s.next();
            if (key.equals("q")) {

            }
            if (key.equals(" ")) {

            }
        }

        void GameOver() {
            showText("残念・・・正解のドアは" + correct + "だった・・・");
            showText("ハイスコアは" + highScore + "で、今回のスコアは" + score + "だ!");
            if (score > highScore) {
                showText("おめでとう!ハイスコアだ!");
                highScore = score;
                try {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt")));
                    writer.println(highScore);
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            score = 0;
            reset();
        }

        void reset() {
            stage = 0;
            random();
        }
    }

    class Door extends AbstractAction {
        Door(String num) {
            putValue(Action.NAME, num);
        }

        public void actionPerformed(ActionEvent e) {
            String num = (String) getValue(Action.NAME);
            String number = num.substring(4);
            System.out.println(num);
            game.Input(Integer.parseInt(number));
            jScrollPane.getVerticalScrollBar().setValue(0);
            jScrollPane.getViewport().scrollRectToVisible(new Rectangle(0, Integer.MAX_VALUE - 1, 1, 1));
            tag = true;
        }
    }

    public class EventTest extends Applet implements KeyListener {
        public void init() {
            addKeyListener(this);
        }

        public void keyPressed(KeyEvent e) {
            addKeyListener(new KeyAdapter() { // (1)
                @Override
                public void keyPressed(KeyEvent e) { // (2)
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_Q:
                            key = 1;
                            break;
                        case KeyEvent.VK_SPACE:
                            key = 2;
                            break;
                        default:

                    }
                }
            });
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }
}
/*皆さんは「モンティ・ホール問題」と呼ばれるものを聞いたことがありますか？ //<>// //<>// //<>//
 例えば・・・皆さんの前に3つの箱があり、そのうち1つにはお宝が入っています。
 まず、みなさんはその中から1つを選びます。すると、あなたが選んでいないハズレの箱が一つ開きます。
 そして、あなたはもう一度箱を選び直すことができます
 その場合、箱を選び直した場合と選び直さなかった場合ではどちらのほうが当たる確率が高いか？と言うものです
 そんなわけで、今回はそれをモチーフにしたゲームを作成しました
 今回、あなたの前には100枚のドアがあります。正解のドアは一つだけです。
 まずあなたがドアを1枚選ぶと、もう一枚のドアが示されます。そして正解のドアは2つの内のどちらかです
 ・・・あなたは何回連続で正解のドアを開けられますか!?(失敗した場合ハイスコアは記録されません!)*/

