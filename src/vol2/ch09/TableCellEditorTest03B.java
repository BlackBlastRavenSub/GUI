package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class TableCellEditorTest03B extends JTable {

  TableCellEditorTest03B() {
    super( 8, 2 );
    setRowSelectionAllowed( false );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();

    //** JTextField 型の TableCellEditor を生成する
    TableCellEditor editor0 = new DefaultCellEditor( new JTextField() );
    TableCellEditor editor1 = new DefaultCellEditor( new JTextField() );
    cmodel.getColumn(0).setCellEditor( editor0 );
    cmodel.getColumn(1).setCellEditor( editor1 );

    // Focus Listener は、JTable にセットする
    addFocusListener( new FocusCheck() ); 
  } 

  //Focus の移動をチェック
  class FocusCheck implements FocusListener {
    @Override
    public void focusLost( FocusEvent e ){
      System.out.println( "focus lost" );

      JTable table = (JTable)e.getSource();
      // 現在編集中のセルに適用されているセルエディタを取得できる
      TableCellEditor editor = table.getCellEditor();
      editor.stopCellEditing();

      TableCellEditor editor0 = table.getCellEditor( 0, 0 );
      TableCellEditor editor1 = table.getCellEditor( 0, 1 );

      if( editor == editor0 ){
        System.out.println( "カラム 0 の TableCellEditor です" );
      }
      if( editor == editor1 ){
        System.out.println( "カラム 1 の TableCellEditor です" );
      }
      System.out.println( "編集後のセルの値は " + editor.getCellEditorValue() );

      //フォーカスの移動先のコンポーネントを取得
      Component comp = e.getOppositeComponent(); 
      if( comp != null ){
        System.out.println( "フォーカスの移動先は " + comp.getClass() );
      }
      if( comp == null ){
        System.out.println( "フォーカスの移動先は 他のウインドウです" );
      }

    }
    @Override
    public void focusGained( FocusEvent e ){
      //フォーカスの移動元のコンポーネントを取得
      Component comp = e.getOppositeComponent(); 
      if( comp != null ){
        System.out.println( "フォーカスの移動元は " + comp.getClass() );
      }
      if( comp == null ){
        System.out.println( "フォーカスの移動元は 他のウインドウです" );
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest03B" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new TableCellEditorTest03B();
    JScrollPane scroll = new JScrollPane( table );
    JButton bt = new JButton( "ボタン" );

    frame.getContentPane().add( scroll, BorderLayout.CENTER );
    frame.getContentPane().add( bt, BorderLayout.SOUTH );

    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}
