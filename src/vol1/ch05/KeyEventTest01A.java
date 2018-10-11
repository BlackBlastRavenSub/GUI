package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest01A extends JFrame {

  public static void main(String[] args) {
    KeyEventTest01A w = new KeyEventTest01A( "KeyEventTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public KeyEventTest01A( String title ){
    super( title );
    enableEvents( AWTEvent.KEY_EVENT_MASK );
    JPanel panel = (JPanel)getContentPane();
    panel.add( new JTextField(), BorderLayout.NORTH );
    // contentpane にテキストコンポーネント貼り付けると JFrame は キーイベントを受け取れなくなる
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
