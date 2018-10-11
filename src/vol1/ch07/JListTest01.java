package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListTest01 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JListTest01 w = new JListTest01( "JListTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JListTest01( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    pane.add( new JButton( new JList01( "JList01" ) ), BorderLayout.NORTH );
  }
  class JList01 extends AbstractAction {
    JList01( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888" };
      JList list = new JList( choice );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
}
