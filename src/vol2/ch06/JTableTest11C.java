package vol2.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest11C extends JTableTestBase {

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest11C();

    Dimension dim1 = new Dimension( 8, 8 );
    table.setIntercellSpacing( dim1 );
    Dimension dim2 = table.getIntercellSpacing();
    System.out.println( dim2 );

    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
