package vol2.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest11 extends JTableTestBase {

  class Selection extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      JTable table = (JTable)e.getSource();
      int row    = table.getSelectedRow();
      int column = table.getSelectedColumn();
      System.out.println( row + " " + column );
    }
  }
  
  JTableTest11(){
    addMouseListener( new Selection() );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest11();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
