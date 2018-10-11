package vol2.ch05;
import javax.swing.*;

class JTableTest02 extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest02( "JTableTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 180 );
    w.setVisible( true );
  }

  JTableTest02( String title ) {
    super( title );
    JTable table = new JTable( 10, 60 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );
  }
}