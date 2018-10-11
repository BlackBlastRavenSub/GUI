package vol2.ch07;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

class JTableTest30 extends JTableTestBase {

  class Control extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      JTable table = (JTable)e.getSource();
      int keyCode = e.getKeyCode(); 
      if( keyCode == KeyEvent.VK_INSERT && e.isControlDown() ){
        getDataFromSelectedCells();
      }
    }
  }

  void getDataFromSelectedCells() {
    int[] rows    = getSelectedRows();
    int[] columns = getSelectedColumns();
    StringBuffer buffer = new StringBuffer();
    for( int r = 0 ; r < rows.length ; r++ ){
      for( int c = 0 ; c < columns.length ; c++ ){
        Object cellValue = getValueAt( rows[r], columns[c] );
        if( cellValue instanceof String ){
          buffer.append( (String)cellValue );
        }
        if( c < (columns.length - 1) ){
          buffer.append( "\t" );
        }
      }
      buffer.append( "\n" );
    }
    copyToClipboard( buffer.toString() );
  }

  void copyToClipboard( String string ){
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection contents = new StringSelection( string );
    clipboard.setContents( contents, null );
  }

  JTableTest30(){
    addKeyListener( new Control() );
    setRowSelectionAllowed( false );
    setCellSelectionEnabled( true );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest30();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
