package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class TableCellEditorTest03 extends JTable {

  // テーブルのコンストラクター
  TableCellEditorTest03() {
    super( 8, 2 );
    setRowSelectionAllowed( false );

    // Focus Listener は、JTable にセットする
    addFocusListener( new FocusCheck() ); 
  } 

  //Focus の移動をチェック
  class FocusCheck implements FocusListener {
    @Override
    public void focusLost( FocusEvent e ){
      System.out.println( "フォーカスがJTableの外に移動しました" );
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
    if( row < 0 ) row=0;
    if( column < 0 ) column=0;

    Object value = getValueAt( row, column );
    System.out.println( "row=" + row +" column=" + column +
            " このセルの値は " + value );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest03" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new TableCellEditorTest03();
    JScrollPane scroll = new JScrollPane( table );
    JButton bt = new JButton( "ボタン" );

    frame.getContentPane().add( scroll, BorderLayout.CENTER );
    frame.getContentPane().add( bt, BorderLayout.SOUTH );

    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}
