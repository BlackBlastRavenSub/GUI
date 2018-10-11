package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest04 extends JFrame {
  int x0 = 0;
  int y0 = 0;
  JPanel panel;

  public static void main(String[] args) {
    MouseEventTest04 w = new MouseEventTest04( "MouseEventTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest04( String title ){
    super( title );
    panel = (JPanel)getContentPane();
    panel.addMouseMotionListener( new MouseMotionCheck() );
  }
  class MouseMotionCheck implements MouseMotionListener {
    public void mouseMoved( MouseEvent e ){
      int x = e.getX();
      int y = e.getY();
      System.out.println( "マウスが動きました　位置は x=" + x +" y="+ y );
    }
    public void mouseDragged( MouseEvent e ){
      int x = e.getX();
      int y = e.getY();
      System.out.println( "マウスがドラッグされました　位置は x=" + x +" y="+ y );
    }
  }
}
