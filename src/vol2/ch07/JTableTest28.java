package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

class JTableTest28 extends JTableTestBase {
  @Override
  public void columnSelectionChanged( ListSelectionEvent e ){     
    DefaultListSelectionModel select = (DefaultListSelectionModel)e.getSource();
    if( select.getValueIsAdjusting() == true ){
        return;
    }

    // 選択動作を正しく完了させるために、JTable.valueChanged() を呼び出すことが必要。
    super.columnSelectionChanged( e );

    int col = getSelectedColumn();
    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();

    TableColumn column = cmodel.getColumn( col );
    System.out.println();
    System.out.println( "modelIndex = " + column.getModelIndex() );
    System.out.println( "width = " + column.getWidth() );
    System.out.println( "max width = " + column.getMaxWidth() );
    System.out.println( "min width = " + column.getMinWidth() );
    System.out.println( "resizable = " + column.getResizable() );
    System.out.println( "identifier = " + column.getIdentifier() );
    System.out.println( "headerValue " + column.getHeaderValue() );
    System.out.println( "cellRenderer " + column.getCellRenderer() );
    System.out.println( "headerRenderer " + column.getHeaderRenderer() );
    System.out.println( "cellEditor " + column.getCellEditor() );
  }

  JTableTest28(){
    setColumnSelectionAllowed(true);
    setRowSelectionAllowed(false);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest28();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
