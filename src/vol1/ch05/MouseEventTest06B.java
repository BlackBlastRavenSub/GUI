package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest06B extends JFrame {

  public static void main(String[] args) {
    MouseEventTest06B w = new MouseEventTest06B( "MouseEventTest06B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest06B( String title ){
    super( title );

    JPanel panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );

  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      System.out.println( "---------\nマウスボタンが押されました" );
      int modifier = e.getModifiers();
      String modifierText = e.getMouseModifiersText( modifier ); 
      System.out.println( "モディファイヤは "+ modifier +" "+ modifierText );
    }
  }
}
