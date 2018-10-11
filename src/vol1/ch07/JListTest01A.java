package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListTest01A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JListTest01A w = new JListTest01A( "JListTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JListTest01A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new JList01A( "横優先" ) );
    tool.add( new JList01B( "縦優先" ) );
    tool.add( new JList01C( "縦一列" ) );
  }
  class JList01A extends AbstractAction {
    JList01A( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888" };
      JList list = new JList( choice );
      list.setVisibleRowCount( 3 );
      list.setLayoutOrientation( JList.HORIZONTAL_WRAP );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
  class JList01B extends AbstractAction {
    JList01B( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888" };
      JList list = new JList( choice );
      list.setVisibleRowCount( 3 );
      list.setLayoutOrientation( JList.VERTICAL_WRAP );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
  class JList01C extends AbstractAction {
    JList01C( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888" };
      JList list = new JList( choice );
      list.setLayoutOrientation( JList.VERTICAL );
      list.setVisibleRowCount( 3 );
      JScrollPane scr = new JScrollPane( list );

      Object[]  obj = { scr };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
}
