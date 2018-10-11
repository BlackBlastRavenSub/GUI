package vol1.ch01;
import javax.swing.*;
import java.awt.*;

class JFrame09 {
  public static void main(String[] args) {
    JFrame frame = new JFrame( "JFrame09" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //***
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = screenSize.width;
    int h = screenSize.height;
    frame.setBounds( w/4, h/4, w/2, h/2 );
    frame.setMinimumSize(new Dimension(000, 100));
    frame.setVisible(true);
  }
}
