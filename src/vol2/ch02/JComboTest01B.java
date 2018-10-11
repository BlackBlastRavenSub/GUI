package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest01B extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest01B w = new JComboTest01B( "JComboTest01B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest01B( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "Lisp", "C++", "Smalltalk", "Java" };
    JComboBox combo = new JComboBox( choice );
    combo.setEditable(true); //**

    pane.add( combo, BorderLayout.NORTH );
  }
}
