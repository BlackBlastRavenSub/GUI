package vol2.ch06;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest17A extends JTableTest13 {

  JTableTest17A() {
    setRowSelectionAllowed( false ); 
    setColumnSelectionAllowed( true );

    TableColumnModel columnModel = getColumnModel();
    ListSelectionModel selectionModel = columnModel.getSelectionModel();
    selectionModel.setSelectionInterval( 2 , 3 );
    selectionModel.addSelectionInterval( 5 , 6 );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest17A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600 , 450 );
    frame.setVisible( true );
  }
}
