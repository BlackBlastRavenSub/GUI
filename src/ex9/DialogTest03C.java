package ex9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest03C extends JFrame {
    JPanel pane;

    public static void main(String[] args) {
        DialogTest03C w = new DialogTest03C("DialogTest03");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(550, 300);
        w.setVisible(true);
    }

    public DialogTest03C(String title) {
        super(title);
        pane = (JPanel) getContentPane();
        JToolBar tool = new JToolBar();
        pane.add(tool, BorderLayout.NORTH);
        tool.add(new Dialog03C("Confirm Dialog"));
    }

    class Dialog03C extends AbstractAction {
        Dialog03C(String text) {
            super(text);
        }

        public void actionPerformed(ActionEvent e) {

            Object[] msg = {"Javaは得意ですか?"};
            int ans = JOptionPane.showConfirmDialog(pane, msg, "Java Question", JOptionPane.YES_NO_OPTION);
            System.out.println(ans);
            if (ans == 0) {
                JOptionPane.showMessageDialog(pane, "Javaは得意です", "Java Answer",
                        JOptionPane.WARNING_MESSAGE);
            } else if (ans == 1) {
                JOptionPane.showMessageDialog(pane, "Javaは苦手です", "Java Answer",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
