package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest02 extends JFrame {

  public static void main(String[] args) {
    KeyEventTest02 w = new KeyEventTest02( "KeyEventTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 120 );
    w.setVisible( true );
  }
  public KeyEventTest02( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();

    JTextField tf = new JTextField();
    tf.addKeyListener( new KeyCheck() );

    panel.add( tf, BorderLayout.NORTH );
  }
  class KeyCheck implements KeyListener {
    public void keyPressed( KeyEvent e ){
      System.out.println( "キーが押されました" );
    }
    public void keyTyped( KeyEvent e ){
      System.out.println( "キーがタイプされました" );
    }
    public void keyReleased( KeyEvent e ){
      System.out.println( "キーが離されました" );
    }
  }
}
