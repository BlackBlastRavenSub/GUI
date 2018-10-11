package vol1.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Layout03A extends JFrame {

  public static void main(String[] args) {
    Layout03A w = new Layout03A( "Layout03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 300 );
    w.setVisible( true );
  }
  public Layout03A( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new GridLayout( 10, 1 ) );

    for( int i=0 ; i<10 ; i++ ){
      pane.add( new JButton( Integer.toString(i) ) );
    }
  }
}
