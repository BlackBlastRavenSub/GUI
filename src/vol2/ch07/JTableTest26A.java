package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.event.*;

class JTableTest26A extends JTableTestBase {
  @Override
  public void columnMoved( TableColumnModelEvent e ){
    super.columnMoved( e );
    int from = e.getFromIndex();
    int to   = e.getToIndex();
    if( from != to ){
      System.out.println( "from:" + from + " to:" + to );
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest26A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
