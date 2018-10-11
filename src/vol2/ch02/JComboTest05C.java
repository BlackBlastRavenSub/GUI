package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest05C extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest05C w = new JComboTest05C( "JComboTest05C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest05C( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333" };

    JComboBox combo = new JComboBox( choice );
    combo.setSelectedItem( "2222" );

    pane.add( combo, BorderLayout.NORTH );

    JList list = new JList( choice );
    list.setSelectedValue( "2222", true );

    pane.add( list, BorderLayout.SOUTH );
  }
}
