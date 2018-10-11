package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest27 extends JTableTestBase {

  class Control extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      int keyCode = e.getKeyCode(); 

      JTable table = (JTable)e.getSource();
      int columnIndex = table.getSelectedColumn();

      if( keyCode == KeyEvent.VK_DELETE ){
         DefaultTableColumnModel cmodel = 
           (DefaultTableColumnModel)table.getColumnModel();
         TableColumn tableColumn = cmodel.getColumn( columnIndex );
         cmodel.removeColumn( tableColumn );
      }
    }
  }
  @Override
  public boolean isCellEditable( int row, int col ) {
    return false;
  }
  @Override
  public void columnRemoved( TableColumnModelEvent e ){
    super.columnRemoved( e );
    int from = e.getFromIndex();
    int to   = e.getToIndex();
    System.out.println( "columnRemoved() from:" + from + " to:"+ to );
  }

  JTableTest27(){
    setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
    addKeyListener( new Control() );
    setRowSelectionAllowed( false ); 
    setColumnSelectionAllowed( true );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest27();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 560, 420 );
    frame.setVisible( true );
  }
}
