package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest06 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest06 w = new DialogTest06( "DialogTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest06( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog06( "Input Dialog ComboBox type" ) );
  }
  class Dialog06 extends AbstractAction {
    Dialog06( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      Object[] choice = { "First", "Second", "Third" };
      Object ans = JOptionPane.showInputDialog( pane, msg, "Input Dialog",
                         JOptionPane.PLAIN_MESSAGE, new ImageIcon( "exit.gif" ),
                         choice, choice[0] ); 
      System.out.println( ans );
    }
  }
}
