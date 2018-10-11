package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest05A extends JFrame {

  public static void main(String[] args) {
    ActionTest05A w = new ActionTest05A( "ActionTest05A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public ActionTest05A( String title ){
    super( title );

    Action action = new A();

    JPanel pane = (JPanel)getContentPane();

    JButton button = new JButton( action );

    KeyStroke keyStroke = KeyStroke.getKeyStroke( "A" );

    InputMap imap = button.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    imap.put( keyStroke, action );
    button.getActionMap().put( action, action );

    pane.add( button, BorderLayout.NORTH );

    JTextArea ta = new JTextArea();
    pane.add( ta, BorderLayout.CENTER );
  }

  class A extends AbstractAction {
    A(){
      putValue( Action.NAME, "A" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "A が押されました" );
    }
  }
}
