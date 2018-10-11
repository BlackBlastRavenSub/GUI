package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest03B extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest03B w = new DialogTest03B( "DialogTest03B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 550, 300 );
    w.setVisible( true );
  }
  public DialogTest03B( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog03B( "Confirm Dialog original icon" ) );
  }
  class Dialog03B extends AbstractAction {
    Dialog03B( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg, "Confirm Dialog original icon",
                                      JOptionPane.YES_NO_CANCEL_OPTION, 
                                      JOptionPane.PLAIN_MESSAGE, new ImageIcon( "exit.gif" ) );
      System.out.println( ans );
    }
  }
}
