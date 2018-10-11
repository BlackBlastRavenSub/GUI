package vol2.ch10;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.*;
import java.util.*;

public class JTable4 extends JTable3 {
  protected JTable4 table;
  protected MergeableTableModel model;
  protected TableColumnModel cm;

  public JTable4( int row, int col ){
    super();
    table = this;
    model = new MergeableTableModel( row, col );
    setModel( model );
    setCellSelectionEnabled( true );
    getTableHeader().setReorderingAllowed( false );
    MergeableTableUI ui = new MergeableTableUI( this );
    setUI( ui );
    cm = getColumnModel();
  }

  public void setValueAt( Object o, int row, int col, int rowCount, int colCount ){
    model.setValueAt( o, row, col, rowCount, colCount );
  }
  @Override
  public Rectangle getCellRect( int row, int col, boolean includeSpacing ){
    Rectangle cellRect = super.getCellRect( row, col, includeSpacing );
    return( model.getCellRect( row, col, cellRect ) );
  }
  @Override
  public int rowAtPoint( Point point ) {
    int row = super.rowAtPoint( point );
    int col = super.columnAtPoint( point );
    if( row == -1 ) row = getRowCount() - 1;
    if( col == -1 ) col = getColumnCount() - 1;
    int logicalRow = model.getLogicalRow( row, col );
    return( logicalRow );
  }
  @Override
  public int columnAtPoint( Point point ) {
    int row = super.rowAtPoint( point );
    int col = super.columnAtPoint( point );
    if( row == -1 ) row = getRowCount() - 1;
    if( col == -1 ) col = getColumnCount() - 1;
    int logicalCol = model.getLogicalColumn( row, col );
    return( logicalCol );
  }

  public int rowAtPointAbsolute( Point point ) {
    return( super.rowAtPoint( point ) );
  }


  public int columnAtPointAbsolute( Point point ) {
    return( super.columnAtPoint( point ) );
  }

  //---------- MergeableTableModel ---------------------------------------------------
  public class MergeableTableModel extends DefaultTableModel {
    public MergeableTableModel( int row, int column ){
      super( row, column );
    }

    public void setValueAt( Object o, int row, int col, int rowCount, int colCount ){
      Multicell mc = new Multicell( o, rowCount, colCount );
      super.setValueAt( mc, row, col );
      Filler filler = new Filler( row, col );
      for( int i=0; i < rowCount ; i++ ){
        for( int j=0 ; j < colCount ; j++ ){
          if( i == 0 && j == 0 ) continue;
          super.setValueAt( filler, row + i, col + j );
        }
      }
    }
    @Override
    public Object getValueAt( int row, int col ){
      Object o = super.getValueAt( row, col );
      if( o instanceof Multicell )   return( ((Multicell)o).value );
      else if( o instanceof Filler ) return( null );
      else                           return( o );
    }

    public Rectangle getCellRect( int row, int col, Rectangle cellRect ){
      Object o = super.getValueAt( row, col );
      if( o instanceof Filler ){
        cellRect = new Rectangle( 0, 0, 0, 0 );
      }
      else if( o instanceof Multicell ){
        int width  = getMulticellWidth( (Multicell)o, col );
        int height = getMulticellHeight( (Multicell)o, row );
        cellRect = new Rectangle( cellRect.x, cellRect.y, width, height );
      }
      return( cellRect );
    }

    public int getMulticellWidth( Multicell c, int col ){
      int colCount = c.colCount;
      int width = 0;
      for( int i = 0 ; i < colCount ; i++ ){
        width += cm.getColumn( col + i ).getWidth();
      }
      return( width );
    }

    public int getMulticellHeight( Multicell c, int row ){
      int rowCount = c.rowCount;
      int height = 0;
      for( int i = 0 ; i < rowCount ; i++ ){
        height += getRowHeight( row+i );
      }
      return( height );
    }

    public int getLogicalRow( int row, int col ){
      Object o = super.getValueAt( row, col );
      if( o instanceof Multicell )   return( row );
      else if( o instanceof Filler ) return( ((Filler)o).row );
      else                           return( row );
    }

    public int getLogicalColumn( int row, int col ){
      Object o = super.getValueAt( row, col );
      if( o instanceof Multicell )   return( col );
      else if( o instanceof Filler ) return( ((Filler)o).col );
      else                           return( col );
    }
    @Override
    public void setValueAt( Object v, int row, int col ){
      Object o = super.getValueAt( row, col );
      if( o instanceof Multicell )   ((Multicell)o).value = v;
      else if( o instanceof Filler ) ;
      else                           super.setValueAt( v, row, col );
    }

    class Multicell {
      Object value;
      int rowCount, colCount;
      Multicell( Object o, int rowCount, int colCount ){
        value = o;
        this.rowCount = rowCount;   
        this.colCount = colCount;
      }
    }
    class Filler{
      int row, col;
      Filler( int row, int col ){
        this.row = row;  
        this.col = col;
      }
    }
  }
  //--------------------- end of MergeableTableModel ---------------------------------
  //---------- MergeableTableUI ------------------------------------------------------
  public class MergeableTableUI extends BasicTableUI {
    protected JTable4 table;

    public MergeableTableUI( JTable4 table ){
      this.table = table;
    }
    @Override
    public void paint( Graphics g, JComponent c ) {
      Rectangle clip = g.getClipBounds();

      Rectangle bounds = table.getBounds();
      bounds.x = bounds.y = 0;

      if( table.getRowCount() <= 0 || table.getColumnCount() <= 0 ||
          !bounds.intersects(clip) ) {
        return;
      }

      Point upperLeft = clip.getLocation();
      Point lowerRight = new Point(clip.x + clip.width - 1, clip.y + clip.height - 1);
      int rMin = table.rowAtPointAbsolute( upperLeft );  //**
      int rMax = table.rowAtPointAbsolute( lowerRight ); //**
      if( rMin == -1 ) rMin = 0;
      if( rMax == -1 ) rMax = table.getRowCount() - 1;

      int cMin = table.columnAtPointAbsolute( upperLeft ); //**
      int cMax = table.columnAtPointAbsolute( lowerRight ); //**
      if( cMin == -1 ) cMin = 0;
      if( cMax == -1 ) cMax = table.getColumnCount() - 1;

      paintGrid( g, rMin, rMax, cMin, cMax );
      paintCells( g, rMin, rMax, cMin, cMax );
    }
    
    private void paintGrid( Graphics g, int rMin, int rMax, int cMin, int cMax ) {
      g.setColor(table.getGridColor());

      Rectangle minCell = table.getCellRect( rMin, cMin, true );
      Rectangle maxCell = table.getCellRect( rMax, cMax, true );
      Rectangle damagedArea = minCell.union( maxCell );

      if( table.getShowHorizontalLines() ) {
        int tableWidth = damagedArea.x + damagedArea.width;
        int y = damagedArea.y;
        for( int row = rMin ; row <= rMax ; row++ ) {
           y += table.getRowHeight( row );
           g.drawLine( damagedArea.x, y - 1, tableWidth-1, y - 1 );
        }
      }
      if( table.getShowVerticalLines() ) {
        TableColumnModel cm = table.getColumnModel();
        int tableHeight = damagedArea.y + damagedArea.height;
        int x;
        x = damagedArea.x;
        for( int column = cMin ; column <= cMax ; column++ ) {
          int w = cm.getColumn(column).getWidth();
          x += w;
          g.drawLine( x - 1, 0, x - 1, tableHeight - 1 );
        }
      }
    }
    
    private void paintCells( Graphics g, int rMin, int rMax, int cMin, int cMax ) {
      TableColumnModel cm = table.getColumnModel();
      int columnMargin = cm.getColumnMargin();

      Rectangle cellRect;
      TableColumn aColumn;
      int columnWidth;
      for( int row = rMin ; row <= rMax ; row++ ) {
        cellRect = table.getCellRect( row, cMin, false );
        for( int column = cMin ; column <= cMax ; column++ ) {
          aColumn = cm.getColumn( column );
          columnWidth = aColumn.getWidth();
          cellRect.width = columnWidth - columnMargin;
          paintCell( g, cellRect, row, column );
          cellRect.x += columnWidth;
        }
      }
      rendererPane.removeAll();
    }

    //*** 基本的には、この paintCell()で、各セル毎に、cellRectを取得し直せば
    // セルのマージ可能なテーブルの表示を実現出来る
    
    private void paintCell(Graphics g, Rectangle cellRect, int row, int column) {

      cellRect = table.getCellRect( row, column, false ); //**

      if( table.isEditing() && table.getEditingRow() == row &&
                                 table.getEditingColumn() == column ) {
        Component component = table.getEditorComponent();
        component.setBounds( cellRect );
        component.validate();
      }
      else {
        TableCellRenderer renderer = table.getCellRenderer(row, column);
        Component component = table.prepareRenderer(renderer, row, column);
        rendererPane.paintComponent( g, component, table, cellRect.x, cellRect.y,
                                        cellRect.width, cellRect.height, true );
      }
    }
  }
  //------------------------ end of MergeableTableUI ---------------------------------
}
//----------------------- end of JTable4 ---------------------------------------------
