package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest02B extends JFrame {
  JPanel panel;
  JButton bt;

  public static void main(String[] args) {
    MouseEventTest02B w = new MouseEventTest02B( "MouseEventTest02B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MouseEventTest02B( String title ){
    super( title );

    panel = (JPanel)getContentPane();
    panel.addMouseListener( new MouseCheck() );

    bt = new JButton("ボタン");
    bt.addMouseListener( new MouseCheck() );

    panel.add( bt, BorderLayout.NORTH );
  }

  class MouseCheck extends MouseAdapter {
    public void mouseClicked( MouseEvent e ){
      JComponent source = (JComponent)e.getSource();
      if( source == panel ){
        System.out.print( "マウスイベントの発生場所は パネル：" );
      }
      if( source == bt ){
        System.out.print( "マウスイベントの発生場所は ボタン：" );
      }
      System.out.println( "マウスがクリックされました" );
    }
  }
}
