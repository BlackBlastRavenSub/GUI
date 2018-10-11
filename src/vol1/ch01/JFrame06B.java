package vol1.ch01;
import javax.swing.*;
import java.awt.event.*;

public class JFrame06B {
  public static void main(String[] args) {
    JFrame frame = new JFrame( "JFrame06B" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setIconImage( new ImageIcon( "500kei.jpg" ).getImage() );
    frame.setSize( 400, 300 );
    frame.setVisible(true);
    frame.setExtendedState( JFrame.MAXIMIZED_VERT ); //垂直方向に最大化
  }
}
