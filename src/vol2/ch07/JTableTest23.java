package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest23 extends JTableTestBase {

  public boolean isCellEditable( int row, int col ) {
    return false;
  }

  class MoveControl extends MouseAdapter {
    int times = 0;
    int oldPos;
    @Override
    public void mousePressed( MouseEvent e ){
      JTable table = (JTable)e.getSource();

      if( times == 0 ){
        table.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
        oldPos = table.getSelectedRow();
        times = 1;
      }
      else {
        table.setCursor( new Cursor( Cursor.DEFAULT_CURSOR ) );
        int newPos = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        System.out.println( oldPos + " " + newPos );
        model.moveRow( oldPos, oldPos, newPos ); //**
        times = 0;
      }
    }
  }
  @Override
  public void tableChanged( TableModelEvent e ){
    super.tableChanged( e );
    int type     = e.getType();
    int column   = e.getColumn();
    int firstRow = e.getFirstRow();
    int lastRow  = e.getLastRow();
    System.out.println( "type="+ type + " column=" + column + 
                        " firstRow=" + firstRow + " lastRow=" + lastRow );
  }

  JTableTest23(){
    addMouseListener( new MoveControl() );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest23();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
