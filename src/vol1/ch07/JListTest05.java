package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest05 extends JFrame {

  public static void main(String[] args) {
    JListTest05 w = new JListTest05( "JListTest05" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }
  public JListTest05( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    String[] choice = { "111", "222", "333", "444", "555", "666" };
    JList list = new JList( choice );

    list.addMouseListener( new MyListSelect() );

    pane.add( list, BorderLayout.CENTER );
  }
  class MyListSelect extends MouseAdapter {
    public void mouseClicked( MouseEvent e ){

      JList li = (JList)e.getComponent();

      int index = li.locationToIndex( e.getPoint() );
      System.out.println( "インデックス番号 "+ index + " の項目をクリックしました" );
      Point point = li.indexToLocation( index );
      System.out.println( "この項目の位置は x="+ point.x + " y="+ point.y );
    }
  }
}
