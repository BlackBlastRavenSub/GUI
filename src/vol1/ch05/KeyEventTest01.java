package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest01 extends JFrame {

  public static void main(String[] args) {
    KeyEventTest01 w = new KeyEventTest01( "KeyEventTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public KeyEventTest01( String title ){
    super( title );
    enableEvents( AWTEvent.KEY_EVENT_MASK );
  }
  protected void processKeyEvent( KeyEvent e ) {
    int id = e.getID();
    if( id == KeyEvent.KEY_PRESSED ){
      System.out.println( "キーが押されました" );
    }
    if( id == KeyEvent.KEY_TYPED ){
      System.out.println( "キーがタイプされました" );
    }
    if( id == KeyEvent.KEY_RELEASED ){
      System.out.println( "キーが離されました" );
    }

  }
}
