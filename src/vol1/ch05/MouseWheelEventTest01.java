package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseWheelEventTest01 extends JFrame {
  JPanel panel;
  JButton bt;

  public static void main(String[] args) {
    MouseWheelEventTest01 w = new MouseWheelEventTest01( "MouseWheelEventTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseWheelEventTest01( String title ){
    super( title );

    panel = (JPanel)getContentPane();
    panel.addMouseWheelListener( new MouseCheck() );
  }

  class MouseCheck implements MouseWheelListener {
    public void mouseWheelMoved( MouseWheelEvent e ){
      System.out.println( "-----------------" );

      int wheelRotation = e.getWheelRotation();
      System.out.println( "スクロール方向は "+ wheelRotation );

      int unitsToScroll = e.getUnitsToScroll();
      System.out.println( "スクロール単位は "+ unitsToScroll );

      int scrollAmount = e.getScrollAmount();
      System.out.println( "スクロール量は "+ scrollAmount );

      int scrollType = e.getScrollType();
      System.out.println( "スクロールタイプは " + scrollType );

    }
  }
}
