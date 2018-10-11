package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

class TableCellEditorTest01 extends JTable {

  TableCellEditorTest01() {
    super( 8, 2 );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setCellEditor( new EditorSyohin( new JTextField() ) );
    column0.setHeaderValue( "商品名" );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "単価" );

    setRowHeight( 20 );
    setRowSelectionAllowed( false );
  } 

  class EditorSyohin extends DefaultCellEditor {
    EditorSyohin( JTextField tf ){
      super( tf ); // スーパークラスのコンストラクターを呼ばないとコンパイル時にエラーになる
      setClickCountToStart( 1 ); // シングルクリックで編集可能
    }
    @Override
    public Component getTableCellEditorComponent( JTable table, Object value,
                                               boolean isSelected,
                                               int row, int column ) {
       System.out.println( value + " " + row + " " + column );
       return( super.getTableCellEditorComponent( table, value, 
                                                  isSelected, row, column ) );
    }   
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest01" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest01();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

