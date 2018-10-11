package vol1.ch05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest03A extends JFrame {

  public static void main(String[] args) {
    KeyEventTest03A w = new KeyEventTest03A( "KeyEventTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public KeyEventTest03A( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    JTextArea ta = new JTextArea();
    ta.addKeyListener( new KeyCheck() );
    panel.add( ta );
  }
  class KeyCheck extends KeyAdapter {
    public void keyPressed( KeyEvent e ){
      char keyChar = e.getKeyChar();
      System.out.print( "\n"+ keyChar );
      if( e.isShiftDown() )   System.out.print( " +Shift" );
      if( e.isControlDown() ) System.out.print( " +Control" );
      if( e.isAltDown() )     System.out.print( " +Alt" );
    }
  }
}
