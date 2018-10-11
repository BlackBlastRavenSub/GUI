package vol1.ch02;
import javax.swing.*;
import java.awt.*;

public class ImageLabel01 extends JFrame {

  public static void main(String[] args) {
    ImageLabel01 w = new ImageLabel01( "Imagelabel01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public ImageLabel01( String title ){
    super( title );
    JLabel panel = new JLabel( new ImageIcon( "stream.jpg" ) );
    getContentPane().add( panel );
  }
}
