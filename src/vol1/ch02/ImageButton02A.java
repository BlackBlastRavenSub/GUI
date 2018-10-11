package vol1.ch02;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ImageButton02A extends JFrame {

  public static void main(String[] args) {
    ImageButton02A w = new ImageButton02A( "ImageButton02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }
  public ImageButton02A( String title ){
    super( title );

    JMenuBar bar = new JMenuBar();
    setJMenuBar( bar );
    JMenu menu = new JMenu( "menu" );
    bar.add( menu );

    JMenuItem item = new JMenuItem();
    item.setIcon( new TestIcon()  );
    item.setPressedIcon( new TestIcon( Color.blue ) );
    item.setRolloverIcon( new TestIcon( Color.green ) );
    item.setRolloverEnabled(true);
    item.setToolTipText( "Test" );
    menu.add( item );

  }

  class TestIcon implements Icon {
    static final int width  = 32;
    static final int height = 32;
    Color color;

    public TestIcon() { 
      color = Color.white;
    }
    public TestIcon( Color c ) { 
      color = c;
    }
    public void paintIcon( Component c, Graphics g, int x, int y ) {
      g.setColor( this.color );
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
