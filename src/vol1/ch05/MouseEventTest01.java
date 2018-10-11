package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest01 extends JFrame {

  public static void main(String[] args) {
    MouseEventTest01 w = new MouseEventTest01( "MouseEventTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest01( String title ){
    super( title );
    enableEvents( AWTEvent.MOUSE_EVENT_MASK );
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
