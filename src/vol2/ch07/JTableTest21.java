package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest21 extends JTableTestBase {
  @Override
  public boolean isCellEditable( int row, int col ) {
    return false;
  }

  class Control extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      JTable table = (JTable)e.getSource();

      int row = table.getSelectedRow();
      int rowCount = table.getRowCount();
      if( row < 0 || rowCount <= row ) return;

      int keyCode = e.getKeyCode(); 

      if( keyCode == KeyEvent.VK_DELETE ){
         DefaultTableModel model = (DefaultTableModel)table.getModel();
         model.removeRow( row );
      }
      if( keyCode == KeyEvent.VK_INSERT ){
         DefaultTableModel model = (DefaultTableModel)table.getModel();
         Object[] rowData= { null, null, null, null, null, null, null };
         model.insertRow( row, rowData );
      }
      e.consume(); 
    }
  }

  JTableTest21(){
    addKeyListener( new Control() );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest21();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
