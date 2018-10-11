package vol2.ch10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.*;

public class JTable3 extends JTable2
{
  protected JTable table;

  public JTable3(){
    super();
    init();
  }
  public JTable3( int row, int col ){
    this( new DefaultTableModel( row, col ) );
  }
  public JTable3( TableModel model ){
    super( model );
    init();
  }
  
  void init(){
    setCellSelectionEnabled( true );
    table = this;
    addMouseMotionListener( new  MouseEventDispatchForRollover() );
    addMouseListener( new  MouseEventDispatchForPopupMenu() );
    setUI( new BasicTableUI() );
  }
  
  class MouseEventDispatchForRollover extends MouseMotionAdapter {
    Object prevV = null;
    @Override
    public void mouseMoved( MouseEvent e ){
      Point p = e.getPoint();
      int row = table.rowAtPoint( p );
      int col = table.columnAtPoint( p );
      if( row < 0 || col < 0 ) return;
      Object v = table.getValueAt( row, col );
      if( v != prevV ){
        if( v instanceof AbstractButton ){
          sendMouseEvent( (JComponent)v, MouseEvent.MOUSE_ENTERED, e );
        }
        if( prevV instanceof AbstractButton ){
          sendMouseEvent( (JComponent)prevV, MouseEvent.MOUSE_EXITED, e );
        }
      }
      prevV = v;
    }

    void sendMouseEvent( JComponent c, int eventId, MouseEvent e ){
      Point p = SwingUtilities.convertPoint( table, e.getX(), e.getY(), c );
      MouseEvent e2 = new MouseEvent( c, eventId,
                                      e.getWhen(), e.getModifiers(), p.x, p.y,
                                      e.getClickCount(), e.isPopupTrigger() );
      c.dispatchEvent( e2 );
      table.repaint();
    }
  }
  
  class MouseEventDispatchForPopupMenu extends MouseAdapter {
    @Override
    public void mouseReleased( MouseEvent e ){
      if( SwingUtilities.isRightMouseButton( e ) == false ) return;
      Point p = e.getPoint();
      int row = table.rowAtPoint( p );
      int col = table.columnAtPoint( p );
      if( row < 0 || col < 0 ) return;
      Object v = table.getValueAt( row, col );
      if( v instanceof JComponent == false ) return;

      JComponent c = (JComponent)v;
      JPopupMenu popup = c.getComponentPopupMenu();
      if( popup != null ){
        popup.show( table, p.x, p.y );
      }
    }
  }

  protected void updateUIorCells(){
    int numColumns = this.getColumnCount();
    int numRows = this.getRowCount();
    for( int col = 0 ; col < numColumns ; col++ ){
      for( int row = 0 ; row < numRows ; row++ ){
        Object o = getValueAt( row, col );
        if( o instanceof JComponent ){
          JComponent component = (JComponent)o;
          component.updateUI();
        }
      }
    }
  }
  public void updateUI(){
    updateUIorCells();
    repaint();
  }
}
