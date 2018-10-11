package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest03 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest03 w = new DialogTest03( "DialogTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 550, 300 );
    w.setVisible( true );
  }
  public DialogTest03( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog03( "Confirm Dialog" ) );
  }
  class Dialog03 extends AbstractAction {
    Dialog03( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg );
      System.out.println( ans );
    }
  }
}
