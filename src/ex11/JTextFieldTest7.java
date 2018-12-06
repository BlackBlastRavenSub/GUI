package ex11;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldTest7 extends JFrame {
    ActionListener actionListener = new TextFieldTestAction(); // リスナの生成
    JTextField input;
    DefaultListModel model = new DefaultListModel();

    public static void main(String[] args) {
        JFrame w = new JTextFieldTest7("JTextAreaTest1");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400, 400);
        w.setVisible(true);
    }

    public JTextFieldTest7(String title) {
        super(title);
        JList jList = new JList(model);
        // jList.addListSelectionListener(new JTextFieldTest7.ListListener());
        JScrollPane scrollPane = new JScrollPane(jList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel pane = (JPanel) getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        input = new JTextField();
        input.setBorder(new TitledBorder("項目入力"));
        input.addActionListener(actionListener);
        pane.add(input);
    }

    class TextFieldTestAction implements ActionListener { // リスナの定義
        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField) e.getSource(); // イベントソースを得る
            String string = source.getText(); // テキストフィールド内の文字列を得る
            if (source == input) { // テキストフィールド2なら
                System.out.println("テキストフィールド２への入力は " + string + " です");
                model.addElement(string);
                input.setText("");
            }
        }
    }
}

