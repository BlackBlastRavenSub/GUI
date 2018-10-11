package vol1.ch01;
import javax.swing.*;

public class JFrame05 {
  public static void main(String[] args) {
    JFrame frame = new JFrame( "JFrame05" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setState( JFrame.ICONIFIED ); //アイコン化
    frame.setIconImage( new ImageIcon( "500kei.jpg" ).getImage() );
    frame.setSize( 400, 300 );
    frame.setVisible(true);
  }
}
