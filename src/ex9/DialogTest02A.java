package ex9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest02A extends JFrame {
    JPanel pane;

    public static void main(String[] args) {
        DialogTest02A w = new DialogTest02A("DialogTest02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(550, 300);
        w.setVisible(true);
    }

    public DialogTest02A(String title) {
        super(title);
        pane = (JPanel) getContentPane();
        JToolBar tool = new JToolBar();
        pane.add(tool, BorderLayout.NORTH);
        tool.add(new Dialog02A("Input Dialog ComboBox type"));
        // tool.add( new Dialog02A( "Error Icon" ) );
        //tool.add( new Dialog02B( "Information Icon" ) );
        //tool.add( new Dialog02C( "Warning Icon" ) );
        //tool.add( new Dialog02D( "Question Icon" ) );
        //tool.add( new Dialog02E( "Plain Icon" ) );
        //tool.add( new Dialog02F( "Original Icon" ) );
    }

    class Dialog02A extends AbstractAction {
        Dialog02A(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"血液型を選んでください"};

            Object[] choice = {"A", "B", "O", "AB"}; // 選択肢
            Object ans = JOptionPane.showInputDialog(pane, msg, "Input Dialog",
                    JOptionPane.PLAIN_MESSAGE, new ImageIcon("exit.gif"),
                    choice, choice[0]);
            System.out.println(ans);

            // JOptionPane.showMessageDialog(pane, msg, "Error",
            // JOptionPane.ERROR_MESSAGE);
        }
    }

    class Dialog02B extends AbstractAction {
        Dialog02B(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"1st line", "2nd line", "3rd line", "4th line"};
            JOptionPane.showMessageDialog(pane, msg, "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class Dialog02C extends AbstractAction {
        Dialog02C(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"1st line", "2nd line", "3rd line", "4th line"};
            JOptionPane.showMessageDialog(pane, msg, "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    class Dialog02D extends AbstractAction {
        Dialog02D(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"1st line", "2nd line", "3rd line", "4th line"};
            JOptionPane.showMessageDialog(pane, msg, "Question",
                    JOptionPane.QUESTION_MESSAGE);
        }
    }

    class Dialog02E extends AbstractAction {
        Dialog02E(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"1st line", "2nd line", "3rd line", "4th line"};
            JOptionPane.showMessageDialog(pane, msg, "Plain",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class Dialog02F extends AbstractAction {
        Dialog02F(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"1st line", "2nd line", "3rd line", "4th line"};
            JOptionPane.showMessageDialog(pane, msg, "Original Icon",
                    JOptionPane.PLAIN_MESSAGE, new ImageIcon("exit.gif"));
        }
    }
}
