package ex5;

import javax.swing.*;
import java.awt.*;

public class ImageButton02C extends JFrame {
    public static void main(String[] args) {
        ImageButton02C w = new ImageButton02C("ImageButton02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(200, 150);
        w.setVisible(true);
    }

    public ImageButton02C(String title) {
        super(title);

        JPanel pane = (JPanel) getContentPane();

        JButton item = new JButton();
        item.setIcon(new ChangeIcon(1));
        item.setPressedIcon(new ChangeIcon(2));
        item.setRolloverIcon(new ChangeIcon(3));
        item.setRolloverEnabled(true);
        item.setToolTipText("Test");
        pane.add(item);

    }

    class ChangeIcon implements Icon {
        static final int width = 200;
        static final int height = 150;
        Color color = Color.green;
        int flag;

        public ChangeIcon(int flag) {
            this.flag = flag;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(this.color);

            switch (flag) {
                case 1:
                    int[] xPoints1 = {width / 2, 0, width};
                    int[] yPoints1 = {0, height, height};
                    g.fillPolygon(xPoints1, yPoints1, xPoints1.length);
                    break;
                case 2:
                    g.fillOval(width / 2 - (width / 4), height / 2 - (height / 4), width / 2, height / 2);
                    break;
                case 3:
                    int[] xPoints2 = {0, width / 2, width};
                    int[] yPoints2 = {0, height, 0};
                    g.fillPolygon(xPoints2, yPoints2, xPoints2.length);
                    break;
            }
        }

        public int getIconWidth() {
            return this.width;
        }

        public int getIconHeight() {
            return this.height;
        }
    }


}
/*
class TestIcon implements Icon {
        static final int width = 100;
        static final int height = 100;
        Color color;

        public TestIcon() {
            color = Color.white;
        }

        public TestIcon(Color c) {
            color = c;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(this.color);
            g.fillOval(x, y, width, height);
        }

        public int getIconWidth() {
            return this.width;
        }

        public int getIconHeight() {
            return this.height;
        }
    }
 */