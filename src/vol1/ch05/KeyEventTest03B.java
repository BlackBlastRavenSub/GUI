package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest03B extends JFrame {

  public static void main(String[] args) {
    KeyEventTest03B w = new KeyEventTest03B( "KeyEventTest03B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public KeyEventTest03B( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    JTextArea ta = new JTextArea();
    ta.addKeyListener( new KeyCheck() );
    panel.add( ta );
  }
  class KeyCheck extends KeyAdapter {
    public void keyTyped( KeyEvent e ){
      char keyChar = e.getKeyChar();
      System.out.print( "\n"+ keyChar );
      if( e.isShiftDown() )   System.out.print( " +Shift" );
      if( e.isControlDown() ) System.out.print( " +Control" );
      if( e.isAltDown() )     System.out.print( " +Alt" );
    }
  }
}
