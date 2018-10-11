package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;

class TableCellEditorTest06 extends JTable {

  TableCellEditorTest06() {
    super( 8, 2 );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();

    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setHeaderValue( "単価" );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "割引" );
    column1.setCellEditor( new DefaultCellEditor( new JCheckBox() ) );

    setRowHeight( 20 );
    setRowSelectionAllowed( false );
  } 

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest06" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest06();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

