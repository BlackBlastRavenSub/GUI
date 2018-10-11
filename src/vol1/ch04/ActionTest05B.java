package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest05B extends JFrame {

  public static void main(String[] args) {
    ActionTest05B w = new ActionTest05B( "ActionTest05B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public ActionTest05B( String title ){
    super( title );

    Action action   = new A();
    Action actionF1 = new ActionF1();

    JPanel pane = (JPanel)getContentPane();

    JButton button = new JButton( action );

    KeyStroke k = KeyStroke.getKeyStroke( "A" );

    InputMap imap = button.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = button.getActionMap();

    imap.put( k, action );
    amap.put( action, action );

    k = KeyStroke.getKeyStroke( "button1 F1" );
    imap.put( k, actionF1 );
    amap.put( actionF1, actionF1 );

    pane.add( button, BorderLayout.NORTH );

    JTextArea ta = new JTextArea();
    pane.add( ta, BorderLayout.CENTER );
  }

  class A extends AbstractAction {
    A(){
      putValue( Action.NAME, "A" );
    }
    public void actionPerformed( ActionEvent e ){
      int modifier = e.getModifiers();
      if( ( modifier & InputEvent.BUTTON1_MASK )!= 0 ){
        System.out.println( "マウスでボタンがクリックされました" );
      }
      else{
        System.out.println( "キーストロークが入力されました" );
      }
    }
  }
  class ActionF1 extends AbstractAction {
    public void actionPerformed( ActionEvent e ){
      int modifier = e.getModifiers();
      String modifierKey = KeyEvent.getKeyModifiersText( modifier );
      System.out.println( modifierKey +" F1" );
    }
  }
}
