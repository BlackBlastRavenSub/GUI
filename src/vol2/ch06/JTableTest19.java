package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class JTableTest19 extends JTableTestBase {
  @Override
  public void valueChanged( ListSelectionEvent e ){     
    super.valueChanged( e );
    int row = getSelectedRow();
    int column = getSelectedColumn();
    if( e.getValueIsAdjusting() == true ) {
      System.out.println( "valueChanged  ValueIsAdjustingTRUE : " +
                          row + " " + column );
    }
    else{
      System.out.println( "valueChanged  ValueIsAdjustingFALSE : " + 
                          row + " " + column );
    }
  }
  @Override
  public void columnSelectionChanged( ListSelectionEvent e ) {
    super.columnSelectionChanged( e );
    int row = getSelectedRow();
    int column = getSelectedColumn();
    if( e.getValueIsAdjusting() == true ) {
      System.out.println( "columnSelectionChanged  ValueIsAdjustingTRUE : " + 
                          row + " " + column );
    }
    else{
      System.out.println( "columnSelectionChanged  ValueIsAdjustingFALSE : " + 
                          row + " " + column );
    }
  }
  @Override
  public boolean isCellEditable( int row, int column ){
    System.out.println( "isCellEditable : " + row + " " + column );
    return( super.isCellEditable( row, column ) );
  }

  class KeyCheck extends KeyAdapter {
    @Override
    public void keyPressed( KeyEvent e ){
      JTable table = (JTable)e.getSource();
      System.out.println( "keyPressed " + 
                          table.getSelectedRow() + " " + table.getSelectedColumn() );
    }
    @Override
    public void keyReleased( KeyEvent e ){
      JTable table = (JTable)e.getSource();
      System.out.println( "keyReleased " + 
                          table.getSelectedRow() + " " + table.getSelectedColumn() );
    }
  }

  JTableTest19(){
    addKeyListener( new KeyCheck() );
    setCellSelectionEnabled( true );
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new JTableTest19();

    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
