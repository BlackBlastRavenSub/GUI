package vol1.ch05;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest04A extends JFrame {
  int x0 = 0;
  int y0 = 0;
  JPanel panel;

  public static void main(String[] args) {
    MouseEventTest04A w = new MouseEventTest04A( "MouseEventTest04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest04A( String title ){
    super( title );
    panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );
    panel.addMouseMotionListener( new MouseCheck() );
  }
  class MouseCheck extends MouseInputAdapter {
    public void mousePressed( MouseEvent e ){
      x0 = e.getX();
      y0 = e.getY();
    }
    public void mouseDragged( MouseEvent e ){
      Graphics g = panel.getGraphics();
      int x = e.getX();
      int y = e.getY();
      g.drawLine( x0, y0, x, y );
      x0 = x;
      y0 = y;
    }
  }
}
