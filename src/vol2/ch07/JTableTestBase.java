package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

class JTableTestBase extends JTable {

  BufferedReader reader;
  protected DefaultTableModel model;

  protected String[] columnNames = 
    { "チーム", "icon", "勝数", "負数", "分数", "勝率", "ゲーム差" };
  String[] names = { "広島", "中日",  "巨人",  "横浜", "阪神",  "ヤクルト" };
  ImageIcon[] icons = { new ImageIcon( "./image/carp.gif" ),  
                        new ImageIcon( "./image/dragons.gif" ),
                        new ImageIcon( "./image/giants.gif" ),
                        new ImageIcon( "./image/baystars.gif" ),
                        new ImageIcon( "./image/tigers.gif" ),
                        new ImageIcon( "./image/swallows.gif") };

  class TableModel1 extends DefaultTableModel {
    TableModel1( String[] columnNames, int rowNum ){
       super( columnNames, rowNum );
    }
    public Class getColumnClass( int col ) {
      return getValueAt( 0, col ).getClass();
    }
    public boolean isCellEditable( int row, int col ) {
      return true;
    }
  }

  JTableTestBase() {
    model =  new TableModel1( columnNames, 0 );
    setModel( model );
    setRowHeight( 60 );

    addData( model, "central.dat" );
  }

  void addData( DefaultTableModel model, String dataFileName ){
    try {
      reader = new BufferedReader( new FileReader( dataFileName ) );
      for( int i = 0 ; i < 6 ; i++ ){
        String line = reader.readLine();
        Vector<Object> row = readLine( line );
        model.addRow( row );
      }
    }
    catch ( IOException e ) {
       System.out.println( e );
    }
  } 

  Vector<Object> readLine( String line ){       
    StringTokenizer st = new StringTokenizer( line );
    Vector<Object> row = new Vector<Object>();
    for( int i = 0 ; i < 6 ; i++ ){
      String data = st.nextToken();
      row.addElement( data );
      if( i==0 ){
         row.addElement( getIcon( data ) );
      }
    }
    return( row );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTestBase();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 420 );
    frame.setVisible( true );
  }

  ImageIcon getIcon( String team ){
    int i;
    for( i = 0 ; i < 6 ; i++ ){
      if( team.equals( names[i] ) ) break;
    }
    return( icons[i] );
  }
}
