package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest05A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest05A w = new JComboTest05A( "JComboTest05A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest05A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333" };

    JComboBox combo = new JComboBox( choice );
    combo.setSelectedIndex( 2 );

    pane.add( combo, BorderLayout.NORTH );

    JList list = new JList( choice );
    list.setSelectedIndex( 2 );

    pane.add( list, BorderLayout.SOUTH );
  }
}
