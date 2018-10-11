package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.util.*;
import java.text.*;

class TablePrint02 extends JFrame {
  JTextArea ta;
  JTable2 table;
  JFrame frame;
  DecimalFormat format = new DecimalFormat( "#### :" );

  public static void main(String[] args) {
    JFrame frame = new TablePrint02( "TablePrint02" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 600, 700 );
    frame.setVisible( true );
  }
  TablePrint02( String title ){
    super( title );
    frame = this;
    JPanel pane = (JPanel)getContentPane();

    String[] columnNames = { "行", "テキスト" };
    DefaultTableModel model = new DefaultTableModel( columnNames, 0 );
    table = new JTable2( model );
    TableColumn column0 = table.getColumnModel().getColumn( 0 );
    column0.setMaxWidth( 30 );

    JScrollPane scr = new JScrollPane( table );
    pane.add( scr );

    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );

    Action newAction = new NewAction( "新規" );
    Action loadAction = new LoadAction( "読み込み" );
    Action printAction  = new PrintAction( "印刷" );

    tool.add( newAction );
    tool.add( loadAction );
    tool.add( printAction );
  }
  //-----------------------------------------------
  class PrintAction extends AbstractAction{
    PrintAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      MessageFormat header = new MessageFormat( frame.getTitle() );
      MessageFormat footer = new MessageFormat( "ページ {0} {1}" );
      
      try{
        table.print( JTable.PrintMode.FIT_WIDTH, header, footer );
      }
      catch( PrinterException exc ){
        exc.printStackTrace();
      }
    }
  }
  //-----------------------------------------------------
  class LoadAction extends AbstractAction{
    LoadAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      JFileChooser fileChooser = new JFileChooser( "." );
      int ret = fileChooser.showOpenDialog( frame );
      File file = fileChooser.getSelectedFile();
      if( ret != JFileChooser.APPROVE_OPTION || file == null ) return;
      frame.setTitle( file.getName() ); //**
      try{
        int line = 1;
        boolean eof = false;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while( eof==false ){
          String lineNumber = format.format( line );
          JLabel lineLabel = new JLabel( lineNumber );
          lineLabel.setVerticalAlignment( JLabel.TOP );
          JTextArea ta = new JTextArea();
          for (int i = 0; i < 10; i++) {
            String lineText = reader.readLine();
            if( lineText == null ) {
              eof = true;
              break;
            }
            ta.append( lineText + "\n" );
            line++;
          }
          Vector<JComponent> row = new Vector<JComponent>();
          row.add( lineLabel );
          row.add( ta );
          DefaultTableModel model = (DefaultTableModel)table.getModel();
          model.addRow(row);
        }
      }
      catch( FileNotFoundException ex ){
        
      }
      catch( IOException ex ) {
      }
    }
  }

  class NewAction extends AbstractAction{
    NewAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      DefaultTableModel model = (DefaultTableModel)table.getModel();
      int rowCount = model.getRowCount();
      for( int i = rowCount-1 ; i >= 0 ; i-- ){
        model.removeRow( i );
      }
    }
  }
}
