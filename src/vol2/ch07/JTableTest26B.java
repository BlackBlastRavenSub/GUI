package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class JTableTest26B extends JTableTestBase {

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
        oldPos = table.getSelectedColumn();
        times = 1;
      }
      else {
        table.setCursor( new Cursor( Cursor.DEFAULT_CURSOR ) );
        int newPos = table.getSelectedColumn();
        System.out.println( "mousePressed() " + oldPos + " " + newPos );
        table.moveColumn( oldPos, newPos ); //**
        times = 0;
      }
    }
  }
  @Override
  public void columnMoved( TableColumnModelEvent e ){
    super.columnMoved( e );
    int from = e.getFromIndex();
    int to   = e.getToIndex();
    System.out.println( "columnMoved() from:" + from + " to:"+ to );
  }

  JTableTest26B(){
    addMouseListener( new MoveControl() );
    setRowSelectionAllowed( false ); 
    setColumnSelectionAllowed( true );

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest26B();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
