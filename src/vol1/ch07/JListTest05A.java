package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest05A extends JFrame {
  JTextArea ta;

  public static void main(String[] args) {
    JListTest05A w = new JListTest05A( "JListTest05A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 300 );
    w.setVisible( true );
  }
  public JListTest05A( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    ta = new JTextArea();

    String[] choice = { "111", "222", "333", "444", "555", "666" };
    JList list = new JList( choice );

    list.addMouseListener( new MyListSelect() );

    pane.add( list, BorderLayout.CENTER );
    pane.add( ta, BorderLayout.SOUTH );

    ta.setBorder( new TitledBorder( "選択された項目" ) );
    list.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect extends MouseAdapter {
    public void mouseClicked( MouseEvent e ){

      JList li = (JList)e.getComponent();

      int index = li.locationToIndex( e.getPoint() );
      System.out.println( "現在、インデックス番号 "+ index + " の項目がクリックされました" );

      if( e.isShiftDown() || e.isControlDown() ){ // シフトキーやコントロールキーにより複数の項目が選択された
        System.out.println( "複数選択がなされています" );
        Object[] selects = li.getSelectedValues();
        ta.setText( "" );
        for( int i=0 ; i < selects.length ; i++ ){
          String select = (String)selects[i];
          ta.append( select +"\n" );
        }
      }
      else { // 1つの項目が選択された
        String select = (String)li.getSelectedValue();
        ta.setText( select );
      }
    }
  }
}
