package vol2.ch09;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class JTable2 extends JTable
{
  protected TableCellRenderer genericRenderer = new GenericCellRenderer();
  protected TableCellEditor genericEditor = new GenericCellEditor();
  
  public JTable2( int row, int col ){
    super( row, col );
    setCellSelectionEnabled( true );
  }
  
  protected class GenericCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent
    ( JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int col ) {
      JComponent c = (JComponent)value;
      // テーブルの各行の高さを調整する
      Dimension d = c.getPreferredSize();
      if( table.getRowHeight(row) < d.height ){
        table.setRowHeight(row, d.height);
      }
      return c;
    }
  }
  
  protected class GenericCellEditor 
    extends AbstractCellEditor implements TableCellEditor {
    protected JComponent c = null;
    @Override
    public Object getCellEditorValue() { 
      return c;
    }
    @Override    
    public Component getTableCellEditorComponent
    ( JTable table, Object value,
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

