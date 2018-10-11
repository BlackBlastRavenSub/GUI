package vol2.ch05;
import javax.swing.*;
import javax.swing.table.*;

class JTableTest03 extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest03( "JTableTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 160 );
    w.setVisible( true );
  }
  
  JTableTest03( String title ) {
    super( title );
    
    JTable jt = new JTable( 8, 4 );
    JScrollPane scr = new JScrollPane( jt );
    getContentPane().add( scr );
    
    TableColumn col = jt.getColumn( "A" );
    Object headerValue = col.getHeaderValue();
    System.out.println( headerValue );
    
    col.setHeaderValue( "第１欄" );
    col.setIdentifier( "A" );
    
    TableColumn col1 = jt.getColumn( "A" );
    System.out.println( col1.getHeaderValue() );
  }
}
