package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest01 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest01 w = new JComboTest01( "JComboTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest01( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "Lisp", "C++", "Smalltalk", "Java" };
    JComboBox combo = new JComboBox( choice );

    pane.add( combo, BorderLayout.NORTH );
  }
}
