package vol2.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest17 extends JTableTest13 {

  JTableTest17(){
    setRowSelectionAllowed( false ); 
    setColumnSelectionAllowed( true );
    setColumnSelectionInterval( 2 , 3 );
    addColumnSelectionInterval( 5 , 6 );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest17();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
