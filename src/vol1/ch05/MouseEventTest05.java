package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest05 extends JFrame {

  public static void main(String[] args) {
    MouseEventTest05 w = new MouseEventTest05( "MouseEventTest05" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest05( String title ){
    super( title );

    JPanel panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );

  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      System.out.println( "==========\nマウスボタンが押されました" );
      check( e );
    }
    public void mouseReleased( MouseEvent e ){
      System.out.println( "---------\nマウスボタンが離されました" );
      check( e );
    }
    public void mouseClicked( MouseEvent e ){
      System.out.println( "---------\nマウスがクリックされました" );
      check( e );
    }
    void check( MouseEvent e ){
      int count = e.getClickCount();
      System.out.println( "クリック回数は "+ count );
    }
  }
}
