package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyStrokeTest01A extends JFrame {

  public static void main(String[] args) {
    KeyStrokeTest01A w = new KeyStrokeTest01A( "KeyStrokeTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public KeyStrokeTest01A( String title ){
    super( title );

    Action actionF1     = new ActionF1();

    JPanel pane = (JPanel)getContentPane();

    InputMap imap =  pane.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = pane.getActionMap();
    KeyStroke k;

    k = KeyStroke.getKeyStroke( "F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "shift F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "ctrl F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "alt F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "ctrl alt F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "shift ctrl alt F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "button1 F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

  }

  class ActionF1 extends AbstractAction {
    public void actionPerformed( ActionEvent e ){
      int modifier = e.getModifiers();
      String modifierKey = KeyEvent.getKeyModifiersText( modifier );
      System.out.println( modifierKey +" F1" );
    }
  }
}
