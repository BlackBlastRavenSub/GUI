package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest03A extends JFrame {
  JPanel panel;
  JButton bt1;
  JButton bt2;

  public static void main(String[] args) {
    MouseEventTest03A w = new MouseEventTest03A( "MouseEventTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest03A( String title ){
    super( title );

    panel = (JPanel)getContentPane();

    bt1 = new JButton( "ボタン１" );
    bt1.addMouseListener( new MouseCheck() );
    panel.add( bt1, BorderLayout.CENTER );

    bt2 = new JButton( "ボタン２" );
    bt2.addMouseListener( new MouseCheck() );
    panel.add( bt2, BorderLayout.SOUTH );

  }

  class MouseCheck extends MouseAdapter {
    public void mouseClicked( MouseEvent e ){
      JComponent source = (JComponent)e.getSource();
      if( source == bt1 ){
        System.out.print( "マウスイベントの発生場所は ボタン１：" );
      }
      if( source == bt2 ){
        System.out.print( "マウスイベントの発生場所は ボタン２：" );
      }
      System.out.println( "---------\nマウスがクリックされました" );

      Point point1 = e.getPoint();
      Point point2 = SwingUtilities.convertPoint( source, point1, panel );
      System.out.println( "マウスの位置は メインウインドウの座標系で X=" + point2.getX() +" Y="+ point2.getY() );
    }
  }
}
