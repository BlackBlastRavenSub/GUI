package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;

class JTableTest14 extends JTableTestBase {
  @Override
  public void valueChanged( ListSelectionEvent e ){     
    super.valueChanged( e );
    if( e.getValueIsAdjusting() == true ) {
      // 前回とは異なるロー上で、マウスボタンが押された
      System.out.println( "mousePressed at Row " + getSelectedRow() );
    }
    if( e.getValueIsAdjusting() == false ) {
      // 前回とは異なるロー上で、マウスボタンが離された
      System.out.println( "mouseReleased at Row " + getSelectedRow() );
    }
  }
  @Override
  public void columnSelectionChanged( ListSelectionEvent e ) {
    super.columnSelectionChanged( e );
    if( e.getValueIsAdjusting() == true ) {
      // 前回とは異なるカラム上で、マウスボタンが押された
      System.out.println( "mousePressed at Column "+ getSelectedColumn() );
    }
    if( e.getValueIsAdjusting() == false ) {
      // 前回とは異なるカラム上で、マウスボタンが離された
      System.out.println( "mouseReleased at Column "+ getSelectedColumn() );
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest14();
    table.setCellSelectionEnabled( true );
    
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
