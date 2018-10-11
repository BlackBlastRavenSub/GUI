package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest06A extends JFrame {

  public static void main(String[] args) {
    MouseEventTest06A w = new MouseEventTest06A( "MouseEventTest06A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest06A( String title ){
    super( title );

    JPanel panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );

  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      System.out.println( "----------------------" );
      int button = e.getModifiersEx();

      if( (button & MouseEvent.BUTTON1_DOWN_MASK)!=0 ){
        System.out.println( "左ボタンが押されました" );
      }
      if( (button & MouseEvent.BUTTON2_DOWN_MASK)!=0 ){
        System.out.println( "中ボタンが押されました" );
      }
      if( (button & MouseEvent.BUTTON3_DOWN_MASK)!=0 ){
        System.out.println( "右ボタンが押されました" );
      }
    }
  }
}
