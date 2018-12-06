package ex11;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JTextFieldTest6 extends JFrame {
    int result;
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();


    public static void main(String[] args) {
        JFrame w = new JTextFieldTest6("JTextFieldTest6");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400, 300);
        w.setVisible(true);
    }

    public JTextFieldTest6(String title) {
        super(title);
        JPanel panel = (JPanel) getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //ここから上部分
        JPanel input = new JPanel();
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));

        tf1.setDocument(new NumericDocument());
        tf1.setBorder(new TitledBorder("整数1"));
        input.add(tf1);

        JPanel buttons = new JPanel(new GridLayout(4, 1));
        input.add(buttons, BorderLayout.CENTER);

        String[] a = {"+", "-", "*", "/",};
        Action[] action = {
                new calcButton(a[0]), new calcButton(a[1]), new calcButton(a[2]), new calcButton(a[3]),
        };

        for (int i = 0; i < action.length; i++) {
            buttons.add(new JButton(action[i]));
        }
        tf2.setDocument(new LimitedDocument(10));
        tf2.setBorder(new TitledBorder("整数2"));
        input.add(tf2);
        panel.add(input);
        //ここまで上部分
        //ここから下部分
        JPanel output = new JPanel();
        output.setLayout(new BoxLayout(output, BoxLayout.X_AXIS));
        tf3.setBorder(new TitledBorder("結果"));
        output.add(tf3);
        panel.add(output);
    }

    class NumericDocument extends PlainDocument {
        String validValues = "0123456789.+-";

        @Override
        public void insertString(int offset, String str, AttributeSet a) {
            if (validValues.indexOf(str) == -1) {
                return;
            }
            try {
                super.insertString(offset, str, a);
            } catch (BadLocationException e) {
                System.out.println(e);
            }
        }
    }

    class LimitedDocument extends PlainDocument {
        int limit;

        LimitedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet a) {
            if (getLength() >= limit) {
                return;
            }
            try {
                super.insertString(offset, str, a);
            } catch (BadLocationException e) {
                System.out.println(e);
            }
        }
    }

    class calcButton extends AbstractAction {
        calcButton(String num) {
            putValue(Action.NAME, num);
        }

        public void actionPerformed(ActionEvent e) {
            String text = (String) getValue(Action.NAME);
            char label = text.charAt(0);

            int left = Integer.parseInt(tf1.getText());
            int right = Integer.parseInt(tf2.getText());

            //String num = (String) getValue(Action.NAME);
            switch (label) {
                case '+':
                    result = left + right;
                    System.out.println(label);
                    break;
                case '-':
                    result = left - right;
                    break;
                case '*':
                    result = left * right;
                    break;
                case '/':
                    result = left / right;
                    break;
            }
            // result = Integer.parseInt(null);
            tf3.setText(String.valueOf(result));
            //tf3.setText("111111");
            System.out.println(label);
        }
    }
}

