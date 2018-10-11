package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class TableRendererTest05 extends JTable {

  Properties syohinMaster = new Properties();

  TableRendererTest05() {
    super( 8, 1 );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );
    column0.setCellRenderer( new RendererSyohin() );
    column0.setHeaderValue( "商品名" );

    try {
      FileInputStream syohinMasterFile = new FileInputStream( "syohin.dat" );
      syohinMaster.load( syohinMasterFile );
    } catch( IOException e ){
      System.out.println( e );
    }
  }        

  class RendererSyohin extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value,
                                               boolean isSelected, boolean hasFocus,
                                               int row, int column ) {
      if( value == null ){
         setText( "" ); // セルに初期データがないので、null を返してはならない
      }else{
         setText( (String)syohinMaster.get( value ) );
      }
      return( this );
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "商品一覧" );

    JTable table = new TableRendererTest05();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );

    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 280, 140 );
    frame.setVisible( true );
  }
}
