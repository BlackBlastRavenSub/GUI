package vol1.ch02;
import javax.swing.*;
import java.awt.*;

public class ImageLabel02 extends JFrame {

  public static void main(String[] args) {
    ImageLabel02 w = new ImageLabel02( "ImageLabel02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 150 );
    w.setVisible( true );
  }
  public ImageLabel02( String title ){
    super( title );
    JLabel panel = new JLabel( new DrawIcon() );
    getContentPane().add( panel );
  }
  class DrawIcon implements Icon {
    static final int width  = 100;
    static final int height = 100;

    public void paintIcon( Component c, Graphics g, int x, int y ) {
      g.setColor( Color.green );
      g.fillOval( x, y, width, height );
    }
    public int getIconWidth() { 
      return this.width;
    }
    public int getIconHeight() {
      return this.height;
    }
  }
}
