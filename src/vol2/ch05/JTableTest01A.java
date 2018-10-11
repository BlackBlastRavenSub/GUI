package vol2.ch05;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

class JTableTest01A extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest01A( "JTableTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 180 );
    w.setVisible( true );
  }
  
  JTableTest01A( String title ) {
    super( title );
    JTable table = new JTable( 8, 4 );
    JTableHeader header = table.getTableHeader();
    getContentPane().add( header, BorderLayout.NORTH );
    getContentPane().add( table, BorderLayout.CENTER );
  }
}
