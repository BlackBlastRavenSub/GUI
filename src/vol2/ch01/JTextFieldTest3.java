package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class JTextFieldTest3 extends JFrame {

  ActionListener actionListener = new TextFieldTestAction();
  JTextField tf1, tf2;

  public static void main( String[] args ){
    JFrame w = new JTextFieldTest3( "JTextFieldTest3" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 150, 120 );
    w.setVisible( true );
  }

  public JTextFieldTest3( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    tf1 = new JTextField();
    tf1.setBorder( new TitledBorder( "テキストフィールド１" ) );
    tf1.addActionListener( actionListener );
    pane.add( tf1 );

    tf2 = new JTextField( "初期値" );
    tf2.setBorder( new TitledBorder( "テキストフィールド２" ) );
    tf2.addActionListener( actionListener );
    pane.add( tf2 );
  }

  class TextFieldTestAction implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      JTextField source = (JTextField)e.getSource();
      String string = source.getText();
      if( source == tf1 ){
        System.out.println( "テキストフィールド１への入力は "+ string +" です" );
      }
      if( source == tf2 ){
        System.out.println( "テキストフィールド２への入力は "+ string +" です" );
      }
    }
  }
}
