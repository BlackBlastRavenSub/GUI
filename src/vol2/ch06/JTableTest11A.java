package vol2.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest11A extends JTableTestBase {
  
  class Selection extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      JTable table = (JTable)e.getSource();
      Point point = e.getPoint();
      int row    = table.rowAtPoint( point );
      int column = table.columnAtPoint( point );
      System.out.println( row + " " + column );
    }
  }

  JTableTest11A(){
    addMouseListener( new Selection() );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest11A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
