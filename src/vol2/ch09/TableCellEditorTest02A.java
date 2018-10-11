package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

class TableCellEditorTest02A extends JTable {

  TableCellEditorTest02A() {
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
    int row, column;

    EditorSyohin( JTextField tf ){
      super( tf ); // スーパークラスのコンストラクターを呼ばないとコンパイル時にエラーになる
      setClickCountToStart( 1 ); // シングルクリックで編集可能
      addCellEditorListener( new EditorSyohinListener() );
    }
    @Override
    public Component getTableCellEditorComponent( JTable table, Object value,
                                               boolean isSelected,
                                               int row, int column ) {
       this.row = row;
       this.column = column;
       return( super.getTableCellEditorComponent( table, value, 
                                                  isSelected, row, column ) );
    }

    class EditorSyohinListener implements CellEditorListener{
      @Override
      public void editingStopped( ChangeEvent e ){
        DefaultCellEditor editor = (DefaultCellEditor)e.getSource();
        Object value = editor.getCellEditorValue();
        System.out.print( "editingStopped() " );
        System.out.println( "row=" + row +" column=" + column +
            " このセルの値は " + value );
      }
      @Override
      public void editingCanceled( ChangeEvent e ){
        System.out.println( "editingCanceled " + e );
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest02A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest02A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

