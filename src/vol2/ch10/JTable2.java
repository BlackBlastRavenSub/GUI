package vol2.ch10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.*;
import java.util.*;

public class JTable2 extends JTable
{
  JTable table;
  protected TableCellRenderer genericRenderer = new GenericCellRenderer();
  protected TableCellEditor genericEditor = new GenericCellEditor();
  protected ArrayList<Integer> rowHeightFix = new ArrayList<Integer>();

  public JTable2(){
     super();
  }
  public JTable2( int row, int col ){
    this( new DefaultTableModel( row, col ) );
  }
  public JTable2( TableModel model ){ 
    super( model );
    setCellSelectionEnabled( true );
    table = this;
  }

  // ローの高さが固定かどうか
  public void setRowHeightFix( int row ){
    rowHeightFix.add( row );
  }
  public boolean isRowHeightFix( int row ){
    for(int i : rowHeightFix ) {
      if( row == i ) return( true );
    }
    return( false );
  }
  
  protected class GenericCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( 
      JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int col ) {
      if( value instanceof JComponent ==false ){
        return( super.getTableCellRendererComponent( 
                  table, value,
                  isSelected, hasFocus, row, col ) );
      }
      JComponent c = (JComponent)value;
      if( isRowHeightFix( row )== false ){
        //ローの高さが固定でない ならば、テーブルの各行の高さを調整する
        // テーブルの各行の高さを調整する
        Dimension d = c.getPreferredSize();
        if( table.getRowHeight(row) < d.height ){
          table.setRowHeight(row, d.height);
        }
      }
      return c;
    }
  }

  protected class GenericCellEditor extends AbstractCellEditor 
    implements TableCellEditor {
    protected JComponent c = null;
    @Override
    public Object getCellEditorValue() {
      return c;
    }
    @Override
    public Component getTableCellEditorComponent( 
      JTable table, Object value,
      boolean isSelected, int row, int col ) {
      c = (JComponent)value;
      return( c );
    }
  }
  @Override
  public TableCellRenderer getCellRenderer( int row, int col ) {
    TableCellRenderer renderer;
    Object o = getValueAt( row, col );
    if( o instanceof JComponent ){
      renderer = genericRenderer;
    }
    else{
      renderer = super.getCellRenderer( row, col );
    }
    return renderer;
  }
  @Override
  public TableCellEditor getCellEditor( int row, int col ) {
    TableCellEditor editor;
    Object o = getValueAt( row, col );
    if( o instanceof JComponent ){
      editor = genericEditor;
    }
    else{
      editor = super.getCellEditor( row, col );
    }
    return editor;
  }
}
