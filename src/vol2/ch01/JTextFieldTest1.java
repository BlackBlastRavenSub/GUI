package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;

public class JTextFieldTest1 extends JFrame {

  public static void main( String[] args ){
    JFrame w = new JTextFieldTest1( "JTextFieldTest1" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 240 );
    w.setVisible( true );
  }

  public JTextFieldTest1( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    TitledBorder tb = new TitledBorder( "テキストフィールド１" );

    JTextField tf1 = new JTextField();
    tf1.setBorder( tb );

    pane.add( tf1 );

    JTextField tf2 = new JTextField( "初期値" );
    tf2.setBorder( new TitledBorder( "テキストフィールド２" ) );
    pane.add( tf2 );

    JTextField tf3 = new JTextField();
    tf3.setText( "初期値" );
    tf3.setBorder( new TitledBorder( "テキストフィールド３" ) );
    pane.add( tf3 );

    JTextField tf4 = new JTextField( 10 );
    tf4.setBorder( new TitledBorder( "テキストフィールド４" ) );
    pane.add( tf4 );

  }
}
