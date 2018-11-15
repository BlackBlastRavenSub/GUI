package ex8;

import com.sun.tools.javac.comp.Enter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest02D extends JFrame {
    StringBuilder data = new StringBuilder();

    public static void main(String[] args) {
        KeyEventTest02D w = new KeyEventTest02D("KeyEventTest03");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(350, 250);
        w.setVisible(true);
    }

    public KeyEventTest02D(String title) {
        super(title);
        JPanel panel = (JPanel) getContentPane();
        JTextArea ta = new JTextArea();
        ta.addKeyListener(new KeyCheck());
        panel.add(ta);
    }

    class KeyCheck implements KeyListener {
        public void keyPressed(KeyEvent e) {
            check(e);
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_ENTER) {
                output();
            }
        }

        public void keyTyped(KeyEvent e) {
            check(e);
        }

        public void keyReleased(KeyEvent e) {
            check(e);
        }

        void check(KeyEvent e) {
            char keyChar = e.getKeyChar();

            data.append(keyChar);
        }

        void output() {
            String outdata = new String(data);
            System.out.println(outdata);
            data.delete(0,outdata.length());
        }
    }
}
