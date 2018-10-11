package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

class TableColumnTest01A extends JTable {
  TableColumnTest01A() {
    super( 5, 1 );
    setRowHeight( 60 );
    setRowSelectionAllowed(false);
  }
  @Override
  public Class getColumnClass( int column ){
    if( column==0 ){ // カラム0はイメージ型になる
      return( ImageIcon.class );
    }
    else 
    return( super.getColumnClass( column ) );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableColumnTest01A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableColumnTest01A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 200, 300 );
    frame.setVisible( true );
  }
}
