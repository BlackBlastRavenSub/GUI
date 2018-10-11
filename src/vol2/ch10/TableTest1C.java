package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TableTest1C extends JFrame {
  String[] columnNames = { 
    "チーム", "勝数", "負数", "引分", "勝率", "得点", "本塁打", "打率"
  };
  Object[][] data = {
    { "阪神",     87, 51, 2, .630, 728, 141, ".287" },
    { "中日",     73, 66, 1, .525, 616, 137, ".268" },
    { "巨人",     71, 66, 3, .518, 654, 205, ".262" },
    { "ヤクルト",  71, 66, 3, .518, 683, 159, ".283" },
    { "広島",     67, 71, 2, .486, 558,  153,  ".259" },
    { "横浜",     45, 94, 1, .324, 563, 192, ".258" },
  };
  
  TableRowSorter<TableModel> sorter = null;
  
  TableTest1C( String title ) {
    super( title );
    TableModel model = new DefaultTableModel( data, columnNames ) {
      @Override
      public Class getColumnClass( int column ) {
        return getValueAt( 0, column ).getClass();
      }
    };
    JTable table = new JTable();
    sorter = new TableRowSorter<TableModel>( model );
    
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
    getContentPane().add( scroll , BorderLayout.CENTER );
    JPanel p = new JPanel();
    p.setLayout( new FlowLayout() );
    
    JButton bt = null;
    
    bt = new JButton(" ヤクルト ");
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        sorter.setRowFilter(
          RowFilter.regexFilter( "ヤクルト" , 0 ) );
      }
    });
    p.add( bt );
    
    bt = new JButton(" 勝数 > 71 " );
    bt.addActionListener( new ActionListener(){
      @Override
      public void actionPerformed( ActionEvent e ){
        sorter.setRowFilter( 
          RowFilter.numberFilter(
            RowFilter.ComparisonType.AFTER , 71 , 1 ) );
      }
    });
    p.add( bt );
    
    bt = new JButton( "勝or負 < 60" );
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        sorter.setRowFilter(
          RowFilter.numberFilter(
            RowFilter.ComparisonType.BEFORE , 60 , 1 , 2 ) );
      }
    });
    p.add( bt );
    
    bt = new JButton(" 勝and負 > 60 ");
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        java.util.List<RowFilter<Object, Object>> filters 
          = new ArrayList<RowFilter<Object, Object>>(); 
        filters.add(
          RowFilter.numberFilter(RowFilter.ComparisonType.AFTER, 60, 1)); 
        filters.add(
          RowFilter.numberFilter(RowFilter.ComparisonType.AFTER, 60, 2)); 
        sorter.setRowFilter(RowFilter.andFilter(filters)); 
      }
    });
    p.add( bt );
    
    bt = new JButton( "打率 <= .262" );
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        RowFilter<Object,Object> filter = 
          new RowFilter<Object,Object>() {
          @Override
          public boolean include(Entry<? extends Object, 
                                 ? extends Object> entry) {
            for ( int i = 0; i < entry.getValueCount() - 1; i++ ) {
              float f = new Float( (String)entry.getValue(7) );
              if ( f <= 0.262 ) {
                return true;
              }
            }
            return false;
          }
        };
        sorter.setRowFilter(filter);
      }
    });
    p.add( bt );
    
    bt = new JButton( "勝ち越し" );
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        RowFilter<Object,Object> filter = 
          new RowFilter<Object,Object>() {
          @Override
          public boolean include(Entry<? extends Object, 
                                 ? extends Object> entry) {
            for ( int i = 0; i < entry.getValueCount() - 1; i++ ) {
              if ( (Integer)entry.getValue(1) > (Integer)entry.getValue(2) ) {
                return true;
              }
            }
            return false;
          }
        };
        sorter.setRowFilter(filter);
      }
    });
    p.add( bt );
    
    bt = new JButton(" 解除 ");
    bt.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        sorter.setRowFilter( null );
      }
    });
    p.add( bt );
    
    getContentPane().add( p , BorderLayout.SOUTH );
    
    setSize( 800, 200 );
    
    setVisible( true );
  }        
  
  public static void main( String[] args ) {
    JFrame frame = new TableTest1C( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
