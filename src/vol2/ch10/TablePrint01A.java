package vol2.ch10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class TablePrint01A extends JFrame implements ActionListener {
  JTable4 table;
  JButton printFixScale, printAutoScale;

  public static void main(String[] args){
    JFrame f = new TablePrint01A("Table Print 01A");
    f.setDefaultCloseOperation(3);
    f.setSize( 1000, 500 );
    f.setVisible( true );
  }

  public TablePrint01A( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();

    JToolBar tool = new JToolBar();

    printFixScale = new JButton( "固定スケール印刷" );
    printFixScale.addActionListener( this );
    tool.add( printFixScale );

    printAutoScale = new JButton( "自動スケール印刷" );
    printAutoScale.addActionListener( this );
    tool.add( printAutoScale );

    pane.add( tool, BorderLayout.NORTH );

    JTabbedPane[] tabPane = new JTabbedPane[15];
    table = new JTable4( 1, 15 );
    table.setRowHeight( 400 );
    for( int i=0 ; i< 15 ; i++ ){
      tabPane[i] = new JTabbedPane();
      for( int j=0 ; j<16 ; j++ ){
        tabPane[i].addTab( Integer.toString(j), new JPanel() );
      }
      tabPane[i].setTabPlacement( SwingConstants.LEFT );
      table.setValueAt( tabPane[i], 0, i );
    }
    JScrollPane sp = new JScrollPane( table );
    sp.setPreferredSize( new Dimension( 1000, 500 ) );
    pane.add( sp, BorderLayout.CENTER );
  }
  @Override
  public void actionPerformed( ActionEvent e ){
    JButton button = (JButton)e.getSource();
    try{
      if( button == printAutoScale ){
        table.print( JTable.PrintMode.FIT_WIDTH );
      }
      if( button == printFixScale ){
        table.print( JTable.PrintMode.NORMAL );
      }
    }
    catch( PrinterException exc ){
      exc.printStackTrace();
    }
  }
}
