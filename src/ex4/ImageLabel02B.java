package ex4;

import vol1.ch02.ImageLabel02;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ImageLabel02B extends JFrame {
    public static void main(String[] args) {
        ImageLabel02B w = new ImageLabel02B("ImageLabel02");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(250, 150);
        w.setVisible(true);
    }

    public ImageLabel02B(String title) {
        super(title);
        JLabel panel = new JLabel(new ImageLabel02B.DrawIcon());
        getContentPane().add(panel);
    }

    class DrawIcon implements Icon {
        static final int width = 100;
        static final int height = 100;

        public void paintIcon(Component c, Graphics g, int x, int y) {

            Color color;
            Random rnd = new Random();
            int red = 0;
            int green = 0;
            int blue = 0;
            int wi = width;
            int he = height;
            int X = x;
            int Y = y;
            for (int i = 0; i < 30; i++) {
                red = rnd.nextInt(256);
                green = rnd.nextInt(256);
                blue = rnd.nextInt(256);
                color = new Color(red, green, blue);
                g.setColor(color);
                g.fillOval(X, Y, wi, he);
                X = X+(X/2);
                Y = Y+(Y/2);
                wi /= 2;
                he /= 2;
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
