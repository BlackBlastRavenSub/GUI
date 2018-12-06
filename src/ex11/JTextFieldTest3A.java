package ex11;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldTest3A extends JFrame {
    ActionListener actionListener = new TextFieldTestAction(); // リスナの生成
    JTextField tf1, tf2;

    public static void main(String[] args) {
        JFrame w = new JTextFieldTest3A("JTextAreaTest1");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400, 600);
        w.setVisible(true);
    }

    public JTextFieldTest3A(String title) {
        super(title);
        JPanel pane = (JPanel) getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        tf1 = new JTextField();
        tf1.setBorder(new TitledBorder("コピー元"));
        tf1.addActionListener(actionListener);
        pane.add(tf1);

        tf2 = new JTextField();
        tf2.setBorder(new TitledBorder("コピー先"));
        tf2.addActionListener(actionListener);
        pane.add(tf2);
    }

    class TextFieldTestAction implements ActionListener { // リスナの定義
        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField) e.getSource(); // イベントソースを得る
            String string = source.getText(); // テキストフィールド内の文字列を得る
            if (source == tf1) { // テキストフィールド1なら
                System.out.println("テキストフィールド１への入力は " + string + " です");
                tf1.setText("");
                tf2.setText(string);
            }
            if (source == tf2) { // テキストフィールド2なら
                System.out.println("テキストフィールド２への入力は " + string + " です");
            }
        }
    }
}
