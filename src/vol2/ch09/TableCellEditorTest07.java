package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

class TableCellEditorTest07 extends JTable {

  String[] syohin = { "ノート", "シャープペンシル", "ボールペン", "レポート用紙",
                      "計算用紙", "ワープロ用紙", "ファイル", "消しゴム" };
  String[] tanka = { "100", "90", "80", "150", "120", "200", "75", "50" };

  TableCellEditorTest07() {
    super( 5, 2 );

    TableCellEditor listEditor = new ListCellEditor();

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setHeaderValue( "商品名" );
    column0.setCellEditor( listEditor );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "単価" );

    setRowHeight( 80 );
    setRowSelectionAllowed( false );
  } 

  class ListCellEditor extends AbstractCellEditor implements TableCellEditor {
    JList list;
    JScrollPane listScrollPane;
    ListCellEditor(){
      list = new JList( syohin );
      listScrollPane = new JScrollPane( list );
    }
   @Override
    public Component getTableCellEditorComponent( JTable table, Object value,
            boolean isSelected, int row, int col ) {
      return( listScrollPane );
    }
  @Override
    public Object getCellEditorValue() { 
      Object value = list.getSelectedValue();
      return( value );
    }
  }
  @Override
  public void editingStopped( ChangeEvent e ){
    super.editingStopped( e );

    TableCellEditor editor = (TableCellEditor)e.getSource();
    String selectedSyohin = (String)editor.getCellEditorValue();
    if( selectedSyohin == null ) return;

    int row = getSelectedRow();
    for( int i = 0 ; i < syohin.length ; i++ ){
      if( selectedSyohin.equals( syohin[i] ) == true ){
        setValueAt( tanka[i], row, 1 );
        break;
      }
    }
  }
  @Override
  public Class getColumnClass( int column ){
    if( column == 1 ){
      // カラム１は右詰表示になる
      return( Integer.class );
    }
    return( String.class );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest07" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest07();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 400 );
    frame.setVisible( true );
  }
}

