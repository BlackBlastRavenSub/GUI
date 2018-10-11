package vol2.ch05;
import javax.swing.*;
import javax.swing.table.*;

class JTableTest04B extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest04B( "JTableTest04B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 160 );
    w.setVisible( true );
  }

  JTableTest04B( String title ) {
    super( title );

    JTable table = new JTable( 8, 4 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    int[] width = { 20, 50, 75, 100 };
    for( int i = 0 ; i < 4 ; i++ ){
      TableColumn col = cmodel.getColumn( i );
      col.setMaxWidth( width[i] ); //**
    }
  }
}

/***
テーブルの幅を広げても、各カラムは指定された幅を保つ
***/
