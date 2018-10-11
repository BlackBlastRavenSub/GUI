package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;

class JTableTest25 extends JTableTestBase {

  JTableTest25() {
     Vector<Object> winRates = new Vector<Object>();
     for( int row = 0 ; row < getRowCount() ; row++ ){
       winRates.addElement( getWinRate(row ) );
     }
     DefaultTableModel model = (DefaultTableModel)getModel();
     System.out.println( "DefaultTableModel.addColumn()" );
     model.addColumn( "勝率2", winRates );
     
     TableColumn colWinRate = getColumn( "勝率2" );
     colWinRate.setMinWidth( 100 );
  }        

  String getWinRate( int row ){
    int col = getColumn("勝率").getModelIndex();
    Float work = new Float( (String)getValueAt( row, col ) );
    float rate = work.floatValue();
    int num = (int)(rate * 20);
    String asta = "";
    for( int i = 0 ; i < num ; i++ ){
      asta += "*";
    }
    return( asta );
  }
  @Override
  public void columnAdded( TableColumnModelEvent e ){
    super.columnAdded( e );
    int from = e.getFromIndex();
    int to   = e.getToIndex();
    System.out.println( "columnAdded()  from:" + from + " to:" + to );
  }
  @Override
  public void tableChanged( TableModelEvent e ){
    super.tableChanged( e );
    int type     = e.getType();
    int column   = e.getColumn();
    int firstRow = e.getFirstRow();
    int lastRow  = e.getLastRow();
    System.out.println( "tableChanged()  type=" + type + " column=" + column +
                        " firstRow=" + firstRow + " lastRow=" + lastRow );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest25();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
