package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

class TableCellEditorTest05 extends JTable {

  String[] syohin = { "ノート", "シャープペンシル", "ボールペン", "レポート用紙",
                      "計算用紙", "ワープロ用紙", "ファイル", "消しゴム" };
  String[] tanka = { "100", "90", "80", "150", "120", "200", "75", "50" };
  JComboBox cb;
  int editingRow;

  TableCellEditorTest05() {
    super( 8, 2 );

    JComboBox comboBox = new JComboBox( syohin );
    TableCellEditor editorSyohin = new DefaultCellEditor( comboBox );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );

    column0.setCellEditor( editorSyohin );
    column0.setHeaderValue( "商品名" );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "単価" );

    setRowHeight( 20 );
    setRowSelectionAllowed( false );
  } 
  @Override
  public void editingStopped( ChangeEvent e ){
    super.editingStopped( e );

    if( getSelectedColumn() != 0 ){
      // この連動処理は カラム0 の編集が終了した時点でのみ行う
      return;
    }
    DefaultCellEditor editor = (DefaultCellEditor)e.getSource();
    String selectedSyohin = (String)editor.getCellEditorValue();

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
    return( super.getColumnClass( column ) );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest05" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest05();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

