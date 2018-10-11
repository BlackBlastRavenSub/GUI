package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;

class JTableTest15 extends JTableTestBase {
  @Override
  public void valueChanged( ListSelectionEvent e ){     
    super.valueChanged( e );
    if( e.getValueIsAdjusting() == true ) {
      return;
    }

    int rowCount = getSelectedRowCount();   
    int[] rows = getSelectedRows();
    System.out.print( " seleted row( " );
    for( int i = 0 ; i < rowCount ; i++ ){
      System.out.print( rows[i] + " " );
    }
    System.out.print( ")\n" );
  }
  @Override
  public void columnSelectionChanged( ListSelectionEvent e ) {
    super.columnSelectionChanged( e );
    if( e.getValueIsAdjusting() == true ) {
      return;
    }
    
    int columnCnt = getSelectedColumnCount();
    int[] columns = getSelectedColumns();
    System.out.print( " selected column( " );
    for( int i = 0 ; i < columnCnt ; i++ ){
      System.out.print( columns[i] + " " );
    }
    System.out.print( ")\n" );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest15();
    table.setCellSelectionEnabled( true );

    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
