package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest01 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest01 w = new DialogTest01( "DialogTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 500, 300 );
    w.setVisible( true );
  }
  public DialogTest01( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    pane.add( new JButton( new Dialog01( "MessageDialog" ) ), BorderLayout.NORTH );
  }
  class Dialog01 extends AbstractAction {
    Dialog01( String text ){
      super( text );
    }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      JOptionPane.showMessageDialog( pane, msg );
    }
  }
}
