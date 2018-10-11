package vol2.ch06;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest16A extends JTableTest12 {
  
  JTableTest16A(){
    ListSelectionModel selectionModel = getSelectionModel();
    selectionModel.setSelectionInterval( 0 , 1 );
    selectionModel.addSelectionInterval( 3 , 4 );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest16A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600 , 450 );
    frame.setVisible( true );
  }
}
