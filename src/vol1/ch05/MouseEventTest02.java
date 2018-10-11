package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest02 extends JFrame {

  public static void main(String[] args) {
    MouseEventTest02 w = new MouseEventTest02( "MouseEventTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest02( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );
  }
  class MouseCheck implements MouseListener {
    public void mousePressed( MouseEvent e ){
      System.out.println( "マウスボタンが押されました" );
    }
    public void mouseReleased( MouseEvent e ){
      System.out.println( "マウスボタンが離されました" );
    }
    public void mouseClicked( MouseEvent e ){
      System.out.println( "マウスがクリックされました" );
    }
    public void mouseEntered( MouseEvent e ){
      System.out.println( "マウスが入ってきました" );
    }
    public void mouseExited( MouseEvent e ){
      System.out.println( "マウスが出ていきました" );
    }
  }
}
