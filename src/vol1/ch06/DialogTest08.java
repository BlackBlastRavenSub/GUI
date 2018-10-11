package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest08 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest08 w = new DialogTest08( "DialogTest08" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest08( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog08( "Internal Input Dialog ComboBox type" ) );
  }
  class Dialog08 extends AbstractAction {
    Dialog08( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      Object[] choice = { "First", "Second", "Third" };
      Object ans = JOptionPane.showInternalInputDialog( pane, msg, "Input Dialog",
                         JOptionPane.PLAIN_MESSAGE, new ImageIcon( "exit.gif" ),
                         choice, choice[0] ); 
      System.out.println( ans );
    }
  }
}
