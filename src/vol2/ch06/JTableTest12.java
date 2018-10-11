package vol2.ch06;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;

class JTableTest12 extends JTableTestBase {
  @Override
  public void valueChanged( ListSelectionEvent e ){     
    /* 選択動作を正しく完了させるために、JTable.valueChanged() を呼び出すことが必要 */
    super.valueChanged( e ); 
    DefaultListSelectionModel selection = (DefaultListSelectionModel)e.getSource();
    System.out.println( selection );
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    JTable table = new JTableTest12();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
