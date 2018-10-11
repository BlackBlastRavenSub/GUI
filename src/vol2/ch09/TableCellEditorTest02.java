package vol2.ch09;
import javax.swing.*;
import javax.swing.event.*;

class TableCellEditorTest02 extends JTable {

  TableCellEditorTest02() {
    super( 8, 2 );
    setRowSelectionAllowed( false );
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
    JFrame frame = new JFrame( "TableCellEditorTest02" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest02();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

