package vol2.ch06;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

class JTableTest13 extends JTableTestBase {
  @Override
  public void columnSelectionChanged( ListSelectionEvent e ){  
    super.columnSelectionChanged( e ); 
    DefaultListSelectionModel selection = (DefaultListSelectionModel)e.getSource();
    System.out.println( selection );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest13();
    table.setColumnSelectionAllowed(true); //**
    table.setRowSelectionAllowed(false);   //**
    
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
