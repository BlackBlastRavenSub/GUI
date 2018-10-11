package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyStrokeTest01B extends JFrame {

  public static void main(String[] args) {
    KeyStrokeTest01B w = new KeyStrokeTest01B( "KeyStrokeTest01B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public KeyStrokeTest01B( String title ){
    super( title );

    Action actionF1     = new ActionF1();
    Action actionLeftF1 = new ActionLeftF1();

    JPanel pane = (JPanel)getContentPane();

    InputMap imap =  pane.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = pane.getActionMap();
    KeyStroke k;

    k = KeyStroke.getKeyStroke( "released F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "released shift F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    k = KeyStroke.getKeyStroke( "released button1 F1" );
    imap.put( k, actionLeftF1 );
    amap.put( actionLeftF1, actionLeftF1 );

  }

  class ActionF1 extends AbstractAction {
    public void actionPerformed( ActionEvent e ){
      int modifier = e.getModifiers();
      String modifierKey = KeyEvent.getKeyModifiersText( modifier );
      System.out.println( modifierKey +" F1" );
    }
  }
  class ActionLeftF1 extends AbstractAction {
    public void actionPerformed( ActionEvent e ){
      System.out.println( "マウス左ボタン + F1" );
    }
  }
}
