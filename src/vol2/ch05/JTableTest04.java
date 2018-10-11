package vol2.ch05;
import javax.swing.*;
import javax.swing.table.*;

class JTableTest04 extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest04( "JTableTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 160 );
    w.setVisible( true );
  }
  
  JTableTest04( String title ) {
    super( title );
    
    JTable table = new JTable( 8, 4 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );
    
    table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    int[] width = { 20, 50, 75, 100 };
    for( int i = 0 ; i < 4 ; i++ ){
      TableColumn col = cmodel.getColumn(i);
      col.setWidth( width[i] );
    }
  }
}

/***
JTable の setAutoResizeMode() の指定の如何に関わらず、
線幅の指定は無視される
***/
