package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest05A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest05A w = new DialogTest05A( "DialogTest05A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest05A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    pane.add( new JButton( new Dialog05A( "Input Dialog" ) ), BorderLayout.NORTH );
  }
  class Dialog05A extends AbstractAction {
    Dialog05A( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      String ans = JOptionPane.showInputDialog( pane, msg, "初期値を指定出来ます" );
      System.out.println( ans );
    }
  }
}
