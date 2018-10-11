package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest05E extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest05E w = new JComboTest05E( "JComboTest05E" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest05E( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333" };
    JComboBox combo = new JComboBox( choice );
    combo.setSelectedItem( "2222" );
    combo.setEditable( true );

    pane.add( combo, BorderLayout.NORTH );
  }
}
