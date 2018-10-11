package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class TableRendererTest01 extends JFrame {
  class Renderer01 extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value,
                                            boolean isSelected, boolean hasFocus,
                                            int row, int column ) {
      System.out.println( row + " "+ column + " "+ isSelected + " " + hasFocus );
      return( super.getTableCellRendererComponent( 
                table, value, isSelected, hasFocus, row, column ) );
    }
  }

  TableRendererTest01( String title ) {
    super( title );
    JTable table = new JTable( 10, 10 );

    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    for( int i = 0 ; i < table.getColumnCount() ; i++ ){
      TableColumn column = cmodel.getColumn( i );
      column.setCellRenderer( new Renderer01() );
    }
  }

  public static void main(String[] args) {
    JFrame frame = new TableRendererTest01( "TableRendererTest01" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 280, 140 );
    frame.setVisible( true );
  }
}
