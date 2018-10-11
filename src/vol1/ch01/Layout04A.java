package vol1.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Layout04A extends JFrame {

  public static void main(String[] args) {
    Layout04A w = new Layout04A( "Layout04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 340 );
    w.setVisible( true );
  }
  public Layout04A( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    for( int i=0 ; i<10 ; i++ ){
      JButton bt = new JButton( Integer.toString(i) );
      // BoxLayout では、preferredSize は無視される
      //bt.setPreferredSize( new Dimension(240, 25) ); 
      pane.add( bt );
    }
  }
}
