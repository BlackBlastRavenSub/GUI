package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest01C extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest01C w = new JComboTest01C( "JComboTest01C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest01C( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "Lisp", "C++", "Smalltalk", "Java" };
    JComboBox combo = new JComboBox( choice );
    combo.setEditable(true);
    
    ComboBoxEditor ed = combo.getEditor();
    Component comp = ed.getEditorComponent();
    System.out.println( ed );
    System.out.println( comp );

    pane.add( combo, BorderLayout.NORTH );
  }
}
