package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyStrokeTest01 extends JFrame {

  public static void main(String[] args) {
    KeyStrokeTest01 w = new KeyStrokeTest01( "KeyStrokeTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public KeyStrokeTest01( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    Action actionUp    = new ActionUp();
    Action actionDown  = new ActionDown();
    Action actionRight = new ActionRight();
    Action actionLeft  = new ActionLeft();

    JButton buttonUp = new JButton( actionUp );
    pane.add( buttonUp, BorderLayout.NORTH );
    JButton buttonDown = new JButton( actionDown );
    pane.add( buttonDown, BorderLayout.SOUTH );
    JButton buttonRight = new JButton( actionRight );
    pane.add( buttonRight, BorderLayout.EAST );
    JButton buttonLeft = new JButton( actionLeft );
    pane.add( buttonLeft, BorderLayout.WEST );

    InputMap imap = pane.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = pane.getActionMap();

    imap.put( KeyStroke.getKeyStroke("UP"), actionUp );
    amap.put( actionUp, actionUp );
    imap.put( KeyStroke.getKeyStroke("DOWN"), actionDown );
    amap.put( actionDown, actionDown );
    imap.put( KeyStroke.getKeyStroke("RIGHT"), actionRight );
    amap.put( actionRight, actionRight );
    imap.put( KeyStroke.getKeyStroke("LEFT"), actionLeft );
    amap.put( actionLeft, actionLeft );

  }

  class ActionUp extends AbstractAction {
    ActionUp(){
      putValue( Action.NAME, "上" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "上" );
    }
  }
  class ActionDown extends AbstractAction {
    ActionDown(){
      putValue( Action.NAME, "下" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "下" );
    }
  }
  class ActionRight extends AbstractAction {
    ActionRight(){
      putValue( Action.NAME, "右" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "右" );
    }
  }
  class ActionLeft extends AbstractAction {
    ActionLeft(){
      putValue( Action.NAME, "左" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "左" );
    }
  }
}
