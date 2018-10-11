package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SortableTableModel extends DefaultTableModel {
  JTable table;
  JTableHeader header;
  Vector columnNames;

  public SortableTableModel( JTable table, String[] columnNames, int rowCount ){
    super( columnNames, rowCount );
    this.table = table;
    header = table.getTableHeader();
    header.setReorderingAllowed( false );
    header.addMouseListener( new HeaderMouseAdapter() );
    this.columnNames = DefaultTableModel.convertToVector( columnNames );
  }

  class HeaderMouseAdapter extends MouseAdapter {
    int clickCount = 0;
    @Override
    public void mousePressed( MouseEvent e ){
      Point mousePoint = new Point( e.getX(), e.getY() );
      int selectedHeaderColumn = header.columnAtPoint( mousePoint );

      clickCount++;
      boolean reverseOrder = false;
      if( ( clickCount % 2 ) == 0 ) reverseOrder = true;
      sort( selectedHeaderColumn, reverseOrder );
    }
  }
  //@SuppressWarnings("unchecked")
  void sort( int selectedHeaderColumn, boolean reverseOrder ){
    Vector vec = getDataVector();
    Object[] array = vec.toArray();
    Arrays.sort( array, 
    (Comparator<? super Object>)new Compare<Object>( 
      selectedHeaderColumn, reverseOrder ) );
        Arrays.sort( array, 
    (Comparator<? super Object>)new Compare<Object>( 
      selectedHeaderColumn, reverseOrder ) );
    vec = DefaultTableModel.convertToVector( array );
    setDataVector( vec, columnNames );
  }
  
  class Compare<T> implements Comparator<Object> {
    int sortKey;
    boolean reverseOrder;
    Compare( int sortKey, boolean reverseOrder ){
      this.sortKey = sortKey;
      this.reverseOrder = reverseOrder;
    }
    @Override
    @SuppressWarnings("unchecked")
    public int compare( Object o1, Object o2 ){
      Vector v1 = (Vector)o1;
      Vector v2 = (Vector)o2;
      Object data1 = v1.get( sortKey );
      Object data2 = v2.get( sortKey );
      if( data1 instanceof Comparable && data2 instanceof Comparable ){
        Comparable<Object> c1 = (Comparable<Object>)data1;
        Comparable<Object> c2 = (Comparable<Object>)data2;
        int ans = c1.compareTo( c2 );
        if( reverseOrder ) ans *= -1;
        return( ans );
      }
      else{
        return( 0 );
      }
    }
    @Override
    public boolean equals( Object obj ){
      return( equals( obj ) );
    }
  }
}
