package vol1.ch01;

import javax.swing.*;
import java.awt.*;

public class JFrame09A {
    public static void main(String[] args) {
        JFrame frame = new JFrame( "JFrame09" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //***
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width;
        int h = screenSize.height;
        frame.setBounds( w/4, h/4, w/4, h/4 );
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setVisible(true);
    }
}
