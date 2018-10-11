package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest20 extends JTableTestBase {
  
  class KeyCheck extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      JTable table = (JTable)e.getSource();
      int row = table.getSelectedRow();
      int column = table.getSelectedColumn();
      int keyCode = e.getKeyCode(); 
      if( keyCode == KeyEvent.VK_RIGHT ){
        if( column == table.getColumnCount() - 1 ){ //右端まで来た
          column = 0;
          if( row < table.getRowCount() - 1 ) row++;
          updateSelection( row, column );
          e.consume(); 
        }
      }
      System.out.println( "keyPressed " + keyCode + " " + row + " " + column );
    }
  }

  void updateSelection( int row, int column ) {
    setRowSelectionInterval( row , row );
    setColumnSelectionInterval( column , column );
  }
  
  
  JTableTest20(){
    addKeyListener( new KeyCheck() );
    setCellSelectionEnabled( true );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest20();
    
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
