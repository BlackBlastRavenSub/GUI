package vol2.ch05;
import javax.swing.*;

class JTableTest01 extends JFrame {
  
  public static void main(String[] args) {
    JFrame w = new JTableTest01( "JTableTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 160 );
    w.setVisible( true );
  }
  
  JTableTest01( String title ) {
    super( title );
    JTable table = new JTable( 8, 4 );
    getContentPane().add( table );
  }
}
