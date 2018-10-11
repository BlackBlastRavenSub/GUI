package vol1.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Layout02A extends JFrame {

  public static void main(String[] args) {
    Layout02A w = new Layout02A( "Layout02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 340 );
    w.setVisible( true );
  }
  public Layout02A( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new FlowLayout() );

    for( int i=0 ; i<10 ; i++ ){
      JButton bt = new JButton( Integer.toString(i) );
      bt.setPreferredSize( new Dimension(240, 25) );
      pane.add( bt );
    }
  }
}
