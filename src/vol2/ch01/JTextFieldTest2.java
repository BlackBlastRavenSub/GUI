package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;

public class JTextFieldTest2 extends JFrame {

  public static void main( String[] args ){
    JFrame w = new JTextFieldTest2( "JTextFieldTest2" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 160, 120 );
    w.setVisible( true );
  }

  public JTextFieldTest2( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    JPasswordField pf1 = new JPasswordField();
    pf1.setBorder( new TitledBorder( "パスワードフィールド１" ) );
    pane.add( pf1 );

    JPasswordField pf2 = new JPasswordField();
    pf2.setEchoChar( '#' );
    pf2.setBorder( new TitledBorder( "パスワードフィールド２" ) );
    pane.add( pf2 );

  }
}
