package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest03 extends JFrame {

  public static void main(String[] args) {
    KeyEventTest03 w = new KeyEventTest03( "KeyEventTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public KeyEventTest03( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    JTextArea ta = new JTextArea();
    ta.addKeyListener( new KeyCheck() );
    panel.add( ta );
  }
  class KeyCheck implements KeyListener {
    public void keyPressed( KeyEvent e ){
      System.out.println( "==========\nキーが押されました" );
      check( e );
    }
    public void keyTyped( KeyEvent e ){
      System.out.println( "---------\nキーがタイプされました" );
      check( e );
    }
    public void keyReleased( KeyEvent e ){
      System.out.println( "---------\nキーが離されました" );
      check( e );
    }
    void check( KeyEvent e ){
      char keyChar = e.getKeyChar();
      System.out.println( "keyChar : "+ keyChar );

      int keyCode = e.getKeyCode();
      String keyText = KeyEvent.getKeyText( keyCode );
      System.out.println( "keyCode : "+ keyCode +" "+ keyText );

      int modifier = e.getModifiers();
      String modifierText = KeyEvent.getKeyModifiersText( modifier );
      System.out.println( "modifier : "+ modifier +" "+ modifierText );

    }
  }
}
