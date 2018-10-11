package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest05 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest05 w = new DialogTest05( "DialogTest05" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest05( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    pane.add( new JButton( new Dialog05( "Input Dialog" ) ), BorderLayout.NORTH );
  }
  class Dialog05 extends AbstractAction {
    Dialog05( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      String ans = JOptionPane.showInputDialog( pane, msg );
      System.out.println( "["+ ans +"]" );
    }
  }
}
