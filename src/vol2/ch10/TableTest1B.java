package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class TableTest1B extends JFrame {
  String[] columnNames = { 
    "チーム", "勝数", "負数", "引分", "勝率", "得点", "本塁打", "打率"
  };
  String[][] data = {
    { "阪神",     "87", "51", "2", ".630", "728", "141", ".287" },
    { "中日",     "73", "66", "1", ".525", "616", "137", ".268" },
    { "巨人",     "71", "66", "3", ".518", "654", "205", ".262" },
    { "ヤクルト", "71", "66", "3", ".518", "683", "159", ".283" },
    { "広島",     "67", "71", "2", ".486", "558", "153", ".259" },
    { "横浜",     "45", "94", "1", ".324", "563", "192", ".258" },
  };
        
  TableTest1B( String title ) {
    super( title );
    TableModel model = new DefaultTableModel( data, columnNames ) {
      @Override
      public Class getColumnClass( int column ) {
        return getValueAt( 0, column ).getClass();
      }
    };
    JTable table = new JTable();
    TableRowSorter<TableModel> sorter 
      = new TableRowSorter<TableModel>( model );
    sorter.addRowSorterListener( new RowSorterListener() { 
      @Override
      public void sorterChanged( RowSorterEvent event ) { 
        System.out.println( event.getType() ); 
      } 
    }); 
    table.setModel( model );
    sorter.setSortable( 0, false );
    table.setRowSorter( sorter );

    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 600, 200 );
    
    setVisible( true );
  }        

  public static void main( String[] args ) {
    JFrame frame = new TableTest1B( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
