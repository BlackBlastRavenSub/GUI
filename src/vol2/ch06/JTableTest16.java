package vol2.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest16 extends JTableTest12 {
  
  JTableTest16(){
    setRowSelectionInterval( 0 , 1 );
    addRowSelectionInterval( 3 , 4 );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest16();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600 , 450 );
    frame.setVisible( true );
  }
}
