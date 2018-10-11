package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest04A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest04A w = new DialogTest04A( "DialogTest04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest04A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog04A( "Option Dialog" ) );
  }
  class Dialog04A extends AbstractAction {
    Dialog04A( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      JButton bt1 = new JButton( "Option 1" );
      JButton bt2 = new JButton( "Option 2" );
      JButton bt3 = new JButton( "Option 3" );
      Object[] option = { bt1, bt2, bt3 };
      int ans = JOptionPane.showOptionDialog( pane, msg, "Option Dialog", 
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                  option, option[0] );
      System.out.println( ans );
    }
  }
}
