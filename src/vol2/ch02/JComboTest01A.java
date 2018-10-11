package vol2.ch02;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class JComboTest01A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest01A w = new JComboTest01A( "JComboTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest01A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    Vector<String> v = new Vector<String>();
    v.add( "Lisp" );
    v.add( "C++" );
    v.add( "Smalltalk" );
    v.add( "Java" );
    JComboBox combo = new JComboBox( v );

    pane.add( combo, BorderLayout.NORTH );
  }
}
