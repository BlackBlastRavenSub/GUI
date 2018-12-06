package ex11;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListTest10A extends JFrame {

    ActionListener actionListener = new TextFieldTestAction(); // リスナの生成
    JTextField input;
    DefaultListModel model = new DefaultListModel();

    public static void main(String[] args) {
        JFrame w = new JListTest10A("JTextAreaTest1");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400, 400);
        w.setVisible(true);
    }

    public JListTest10A(String title) {
        super(title);
        JList jList = new JList(model);
        // jList.addListSelectionListener(new JTextFieldTest7.ListListener());
        JButton button = new JButton(new Button());
        //input.add(button, BorderLayout.CENTER);
        //button.add(new JButton("追加"));
        getContentPane().add(button, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(jList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel pane = (JPanel) getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        input = new JTextField();
        input.setBorder(new TitledBorder("項目入力"));
        input.addActionListener(actionListener);
        pane.add(input);
    }

    class Button extends AbstractAction {
        Button() {
            putValue( Action.NAME, "追加" );
        }
        public void actionPerformed(ActionEvent e) { // ボタンがクリックされたときの処理
            System.out.println("Action02 が処理されました");
            //input = (JTextField) e.getSource(); // イベントソースを得る
            String string = input.getText(); // テキストフィールド内の文字列を得る
            model.addElement(string);
            input.setText("");
        }
    }

    class TextFieldTestAction implements ActionListener { // リスナの定義
        public void actionPerformed(ActionEvent e) {

        }
    }
}
