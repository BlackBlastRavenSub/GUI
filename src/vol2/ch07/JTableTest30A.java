package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.*;

class JTableTest30A extends JTableTestBase {
  class Control extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      JTable table = (JTable)e.getSource();
      int keyCode = e.getKeyCode(); 
      if( keyCode == KeyEvent.VK_INSERT && e.isShiftDown() ){
        String data = copyFromClipboard();
        setDataToCells( data );
      }
    }
  }

  String copyFromClipboard(){
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable content = clipboard.getContents( this );
    String string = null;
    try {
      string = (String)content.getTransferData(DataFlavor.stringFlavor);
    }
    catch( UnsupportedFlavorException e ){
      System.err.println(e);
    }
    catch( IOException e ){
      System.err.println(e);
    }
    return( string );
  }

  void setDataToCells( String totalData ) {
    int rowCount    = getRowCount();
    int columnCount = getColumnCount();
    int row    = getSelectedRow();
    int baseColumn = getSelectedColumn();
    int column = baseColumn;

    StringTokenizer rowTokenizer = new StringTokenizer( totalData, "\n" );
    while( rowTokenizer.hasMoreTokens() ){
      if( row >= rowCount ) break;
      String rowData = rowTokenizer.nextToken();

      StringTokenizer columnTokenizer = new StringTokenizer( rowData, "\t" );
      while( columnTokenizer.hasMoreTokens() ){
        if( column >= columnCount ) break;
        String cellData = columnTokenizer.nextToken();
        setValueAt( cellData, row, column );
        column++;
      }
      row++;
      column = baseColumn;
    }
  }
  @Override
  public void tableChanged( TableModelEvent e ){
    super.tableChanged(e);
    int type     = e.getType();
    int column   = e.getColumn();
    int firstRow = e.getFirstRow();
    int lastRow  = e.getLastRow();
    System.out.println( "type=" + type +" column=" + column + 
                        " firstRow=" + firstRow + " lastRow=" + lastRow );
  }

  JTableTest30A(){
    addKeyListener( new Control() );
    setRowSelectionAllowed( false );
    setCellSelectionEnabled( true );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest30A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
