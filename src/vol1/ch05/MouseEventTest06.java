package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest06 extends JFrame {

  public static void main(String[] args) {
    MouseEventTest06 w = new MouseEventTest06( "MouseEventTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest06( String title ){
    super( title );

    JPanel panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );

  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      System.out.println( "----------------------" );
      if( SwingUtilities.isLeftMouseButton( e ) ){
        System.out.println( "左ボタンが押されました" );
      }
      if( SwingUtilities.isMiddleMouseButton( e ) ){
        System.out.println( "中ボタンが押されました" );
      }
      if( SwingUtilities.isRightMouseButton( e ) ){
        System.out.println( "右ボタンが押されました" );
      }
    }
  }
}
