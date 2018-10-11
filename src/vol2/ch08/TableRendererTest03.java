package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class TableRendererTest03 extends JFrame {
        
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
  
  class HeaderRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value,
                                               boolean isSelected, boolean hasFocus,
                                               int row, int column ) {
      if( column==0 ){
         setBackground( Color.white );
         setText( "" );
      }
      else{
         char columnSymbol = (char)(column + '@');
         setText( String.valueOf( columnSymbol ) );
         setHorizontalAlignment( SwingConstants.CENTER );
         setBorder( new BevelBorder( BevelBorder.RAISED ) );
      }
      return( this );
    }
  }

  TableRendererTest03( String title ) {
    super( title );
    JTable table = new JTable( 20, 4 );

    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    for( int i = 0 ; i < table.getColumnCount() ; i++ ){
      TableColumn column = cmodel.getColumn(i);
      if( i == 0 ){
        column.setCellRenderer( new Column0Renderer() );
        column.setMaxWidth( 40 );
      }
      column.setHeaderRenderer( new HeaderRenderer() );
    }
  }

  public static void main(String[] args) {
    JFrame frame = new TableRendererTest03( "TableRendererTest03" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 280, 300 );
    frame.setVisible( true );
  }
}
