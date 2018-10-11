package vol1.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Layout04 extends JFrame {

  public static void main(String[] args) {
    Layout04 w = new Layout04( "Layout04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 420, 150 );
    w.setVisible( true );
  }
  public Layout04( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.X_AXIS ) );

    for( int i=0 ; i<10 ; i++ ){
      JButton bt = new JButton( Integer.toString(i) );
      bt.setPreferredSize( new Dimension(240, 25) ); 
      pane.add( bt );
    }
  }
}
