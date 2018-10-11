package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest20B extends JTableTestBase {

  class KeyCheck extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      int keyCode = e.getKeyCode(); 

      JTable table = (JTable)e.getSource();
      int row = table.getSelectedRow();
      int column = table.getSelectedColumn();
      if( row == -1 )    row = 0;    //JTable表示直後の選択ロー番号を補正
      if( column == -1 ) column = 0; //JTable表示直後の選択カラム番号を補正

      if( keyCode == KeyEvent.VK_RIGHT )     column++;
      else if( keyCode == KeyEvent.VK_LEFT ) column--;
      else if( keyCode == KeyEvent.VK_DOWN ) row++;
      else if( keyCode == KeyEvent.VK_UP   ) row--;
      else return;

      e.consume(); 
      updateSelection( row, column );
    }
  }

  protected void updateSelection( int row, int column ) {
     Rectangle cellRect = getCellRect( row, column, false );
     if( cellRect != null ) {
       scrollRectToVisible( cellRect );
     }

     ListSelectionModel rowSelectionModel = getSelectionModel();
     ListSelectionModel columnSelectionModel = getColumnModel().getSelectionModel();

     rowSelectionModel.setSelectionInterval( row, row );
     columnSelectionModel.setSelectionInterval( column, column );

     boolean valueIsAdjusting1 = rowSelectionModel.getValueIsAdjusting();
     boolean valueIsAdjusting2 = columnSelectionModel.getValueIsAdjusting();

     System.out.println( row +" "+ column + " / " + 
                         valueIsAdjusting1 + " " + valueIsAdjusting2 );
  }

  JTableTest20B(){
    setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
    addKeyListener( new KeyCheck() );
    setCellSelectionEnabled( true );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest20B();

    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 400, 250 );
    frame.setVisible( true );
  }
}
