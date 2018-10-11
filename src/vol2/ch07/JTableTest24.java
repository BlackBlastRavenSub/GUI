package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest24 extends JTable {

  String[] names = { "阪神", "巨人",  "広島",  "ヤクルト", "中日",  "横浜" };
  ImageIcon[] icons = { 
    new ImageIcon( "./image/tigers.gif"),
    new ImageIcon( "./image/giants.gif" ),
    new ImageIcon( "./image/carp.gif" ),
    new ImageIcon( "./image/swallows.gif" ),
    new ImageIcon( "./image/dragons.gif" ),
    new ImageIcon( "./image/baystars.gif" )
  };
  String[] win  = { "14" , "11", "10", "11", "9" , "5" };
  String[] lose = { "6"  , "9" , "9" , "11", "10", "15" };
  String[] even = {  "1" , "0",  "1",  "0",  "1",  "1" };
  String[] rate = { ".700", ".550", ".526", ".500", ".473", ".250" };
  String[] diff = { "---", "3.0", "0.0", "3.0", "4.5", "3.0" };

  class TableModel24 extends DefaultTableModel {
    TableModel24( int rowNum, int colNum ){
       super( rowNum, colNum );
    }
    @Override
    public Class getColumnClass( int col ) {
      return getValueAt( 0, col ).getClass();
    }
  }
  @Override
  public void columnAdded( TableColumnModelEvent e ){
    super.columnAdded( e );
    int from = e.getFromIndex();
    int to   = e.getToIndex();
    System.out.println( "columnAdded()  from:"+ from +" to:"+ to );
  }
  @Override
  public void tableChanged( TableModelEvent e ){
    super.tableChanged( e );
    int type     = e.getType();
    int column   = e.getColumn();
    int firstRow = e.getFirstRow();
    int lastRow  = e.getLastRow();
    System.out.println( "tableChanged()  type=" + type +" column=" + column + 
                        " firstRow=" + firstRow + " lastRow=" + lastRow );
  }

  JTableTest24(){
    // 行の数をあらかじめ指定しておく。
    DefaultTableModel model =  new TableModel24( 6, 0 );
    setModel( model );
    setRowHeight( 60 );

    model.addColumn( "チーム", names );
    model.addColumn( "icon", icons );
    model.addColumn( "勝数", win );
    model.addColumn( "負数", lose );
    model.addColumn( "分数", even );
    model.addColumn( "勝率", rate );
    model.addColumn( "ゲーム差", diff );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest24();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
