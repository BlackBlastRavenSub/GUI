package vol2.ch05;
import javax.swing.*;
import javax.swing.table.*;

class JTableTest03A extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest03A( "JTableTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 160 );
    w.setVisible( true );
  }

  JTableTest03A( String title ) {
    super( title );

    JTable table = new JTable( 8, 4 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );

    String[] header = { "1", "2", "3", "4" };
    for( int i = 0 ; i<4 ; i++ ){
      TableColumn col = table.getColumnModel().getColumn(i);
      col.setHeaderValue( header[i] );
    }
  }
}
