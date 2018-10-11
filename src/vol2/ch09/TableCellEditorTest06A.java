package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

class TableCellEditorTest06A extends JTable {

  TableCellEditorTest06A() {
    super( 8, 2 );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();

    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setHeaderValue( "単価" );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "割引" );

    setRowHeight( 20 );
    setRowSelectionAllowed( false );
  } 
  @Override
  public Class getColumnClass( int column ){
    if( column == 1 ){
      // カラム１は CheckBox になる
      return( Boolean.class );
    }
    return( super.getColumnClass( column ) );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest06A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest06A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

