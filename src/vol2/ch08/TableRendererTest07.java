package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class TableRendererTest07 extends JTable {

  // テーブルのコンストラクター
  TableRendererTest07() {
    super( 8, 3 );
    setRowSelectionAllowed(false);
    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    cmodel.getColumn(0).setCellRenderer( renderer );
    renderer.setToolTipText( "column 0" );
    setToolTipText( "JTable" );
  } 

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableRendererTest07" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new TableRendererTest07();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll, BorderLayout.CENTER );

    frame.setSize( 240, 200 );
    frame.setVisible( true );
  }
}
