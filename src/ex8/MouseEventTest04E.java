package ex8;

import com.sun.tools.javac.comp.Enter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventTest04E extends JFrame {
    int x;
    int y;
    int currentX = 0;
    int currentY = 0;
    StringBuilder data = new StringBuilder();

    public static void main(String[] args) {
        MouseEventTest04E w = new MouseEventTest04E("MouseEventTest05");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(350, 250);
        w.setVisible(true);
    }

    public MouseEventTest04E(String title) {
        super(title);

        JPanel panel = (JPanel) getContentPane();
        panel.addMouseListener(new MouseCheck());
        panel.addMouseMotionListener(new MouseMotionCheck());
    }

    void graphic(Graphics g, int x, int y) {
        g.drawLine(currentX, currentY, x, y);
        currentX = x;
        currentY = y;
    }

    class MouseCheck extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            check(e);
        }

        public void mouseReleased(MouseEvent e) {
            check(e);
        }

        public void mouseClicked(MouseEvent e) {
            currentX = e.getX();
            currentY = e.getY();
            check(e);
        }

        void check(MouseEvent e) {
            int count = e.getClickCount();
            System.out.println("クリック回数は " + count);
            currentX=e.getX();
            currentY=e.getY();
        }
    }

    class MouseMotionCheck implements MouseMotionListener {
        public void mouseMoved(MouseEvent e) {
             x = e.getX();
             y = e.getY();
            System.out.println("マウスが動きました　位置は x=" + x + " y=" + y);
        }

        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            System.out.println("マウスがドラッグされました　位置は x=" + x + " y=" + y);
            graphic(getGraphics(), x, y);
        }
    }

}
