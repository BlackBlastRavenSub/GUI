package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest04 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest04 w = new DialogTest04( "DialogTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest04( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog04( "Option Dialog" ) );
  }
  class Dialog04 extends AbstractAction {
    Dialog04( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      Object[] option = { "Option1", "Option2", "Option3" };
      int ans = JOptionPane.showOptionDialog( pane, msg, "Option Dialog", 
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                  option, option[0] );
      System.out.println( ans );
    }
  }
}
