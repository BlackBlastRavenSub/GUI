package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest01A extends JFrame {

  public static void main(String[] args) {
    MouseEventTest01A w = new MouseEventTest01A( "MouseEventTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest01A( String title ){
    super( title );
    enableEvents( AWTEvent.MOUSE_EVENT_MASK );
    JPanel panel = (JPanel)getContentPane();
    panel.add( new JButton("ボタン"), BorderLayout.NORTH );
    // contentpane にボタンを貼り付けると その領域では JFrame は キーイベントを受け取れなくなる
  }
  protected void processMouseEvent( MouseEvent e ) {
    int id = e.getID();
    if( id == MouseEvent.MOUSE_PRESSED ){
      System.out.println( "マウスボタンが押されました" );
    }
    if( id == MouseEvent.MOUSE_RELEASED ){
      System.out.println( "マウスボタンが離されました" );
    }
    if( id == MouseEvent.MOUSE_CLICKED ){
      System.out.println( "マウスボタンがクリックされました" );
    }
    if( id == MouseEvent.MOUSE_ENTERED ){
      System.out.println( "マウスが入ってきました" );
    }
    if( id == MouseEvent.MOUSE_EXITED ){
      System.out.println( "マウスが出ていきました" );
    }
  }
}
