package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;

public class TableTest1A extends JFrame {
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
  
  TableTest1A( String title ) {
    super( title );
    TableModel model = new DefaultTableModel(data, columnNames);
    
    JTable table = new JTable();
    
    table.setModel( model );
    
    table.setAutoCreateRowSorter(true);
    
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 600, 200 );
    
    setVisible( true );
  }        
  
  public static void main(String[] args) {
    JFrame frame = new TableTest1A( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
