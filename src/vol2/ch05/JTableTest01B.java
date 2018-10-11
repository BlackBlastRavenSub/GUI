package vol2.ch05;
import javax.swing.*;

class JTableTest01B extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest01B( "JTableTest01B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 180 );
    w.setVisible( true );
  }

  JTableTest01B( String title ) {
    super( title );
    JTable table = new JTable( 8, 4 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );
  }
}
