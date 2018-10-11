package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class TableRendererTest02 extends JFrame {
  class Column0Renderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value,
                                       boolean isSelected, boolean hasFocus,
                                       int row, int column ) {
      setBackground( table.getTableHeader().getBackground() );
      setValue( new Integer( row+1 ) );
      setBorder( new BevelBorder( BevelBorder.RAISED ) );
      return( this );
    }
  }
  
  TableRendererTest02( String title ) {
    super( title );
    JTable table = new JTable( 20, 4 );
    
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    
    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setCellRenderer( new Column0Renderer() );
  }

  public static void main(String[] args) {
    JFrame frame = new TableRendererTest02( "TableRendererTest02" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 280, 300 );
    frame.setVisible( true );
  }
}
