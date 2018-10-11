package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

class TableColumnTest01 extends JTable {
  TableColumnTest01() {
    super( 8, 4 );
    setRowHeight( 20 );
    setRowSelectionAllowed(false);
    
    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    
    cmodel.getColumn( 0 ).setHeaderValue( "整数型" );
    cmodel.getColumn( 1 ).setHeaderValue( "実数型" );
    cmodel.getColumn( 2 ).setHeaderValue( "日付型" );
    cmodel.getColumn( 3 ).setHeaderValue( "論理型" );
    
    cmodel.getColumn( 2 ).setMinWidth( 120 );
  }
  
  @Override
  public Class getColumnClass( int column ){
    switch( column ) {
    case 0: // カラム0は整数型になる
      return( Integer.class );
    case 1: // カラム１は実数型になる
      return( Double.class );
      
    case 2: // カラム２は日付型になる
      return( Date.class );
    case 3: // カラム３は論理型になる
      return( Boolean.class );
    default:
      return( super.getColumnClass( column ) );
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableColumnTest01" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableColumnTest01();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 360, 240 );
    frame.setVisible( true );
  }
}
