package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class TableCellEditorTest03A extends JTable {

  // テーブルのコンストラクター
  TableCellEditorTest03A() {
    super( 8, 2 );
    setRowSelectionAllowed(false);

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();

    // Focus Listener は、JTable にセットする
    addFocusListener( new FocusCheck() ); 
  } 

  //Focus の移動をチェック
  class FocusCheck implements FocusListener {
    @Override
    public void focusLost( FocusEvent e ){
      System.out.println( "フォーカスがJTableの外に移動しました" );

      JTable table = (JTable)e.getSource();
      // 現在編集中のセルに適用されているセルエディタを取得できる
      TableCellEditor editor = table.getCellEditor();
      //フォーカスが移動しても、編集中のセルの値を確定できる
      editor.stopCellEditing();
    }
    @Override
    public void focusGained( FocusEvent e ){
    }
  }
  @Override
  public void editingStopped( ChangeEvent e ){
    super.editingStopped( e );

    int row = getSelectedRow();
    int column = getSelectedColumn();
    if( row < 0 ) row = 0;
    if( column < 0 ) column = 0;

    Object value = getValueAt( row, column );
    System.out.println( "row=" + row + " column=" + column +
            " このセルの値は " + value );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest03A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new TableCellEditorTest03A();
    JScrollPane scroll = new JScrollPane( table );
    JButton bt = new JButton( "ボタン" );

    frame.getContentPane().add( scroll, BorderLayout.CENTER );
    frame.getContentPane().add( bt, BorderLayout.SOUTH );

    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}
/****
JTableに明示的にCellEditorを設定していない場合には、JTable$GenericEditor がセルエディタとして設定されている
****/

