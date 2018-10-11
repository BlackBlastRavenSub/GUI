package vol1.ch01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout01A extends JFrame {

  public static void main(String[] args) {
    Layout01A w = new Layout01A( "Layout01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public Layout01A( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    JButton buttonNorth = new JButton( "North" );
    buttonNorth.setPreferredSize( new Dimension( 300, 50 ) );
    pane.add( buttonNorth, BorderLayout.NORTH );

    JButton buttonCenter  = new JButton( "Center" );
    buttonCenter.setPreferredSize( new Dimension( 300, 50 ) );
    pane.add( buttonCenter, BorderLayout.CENTER );

    JButton buttonSouth = new JButton( "South" );
    buttonSouth.setPreferredSize( new Dimension( 300, 50 ) );
    pane.add( buttonSouth, BorderLayout.SOUTH );
  }
}
