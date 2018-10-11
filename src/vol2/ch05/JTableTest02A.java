package vol2.ch05;
import javax.swing.*;

class JTableTest02A extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest02A( "JTableTest02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 180 );
    w.setVisible( true );
  }

  JTableTest02A( String title ) {
    super( title );
    JTable table = new JTable( 10, 60 );
    table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF ); //**
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );
  }
}

/***
autoResizeMode が JTable.AUTO_RESIZE_OFF でなければ、
横方向のスクロールが出来ない　 Bug Id 4127936
***/
