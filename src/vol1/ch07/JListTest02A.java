package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListTest02A extends JFrame {
  JPanel pane;
  String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555", "6666", "7777" };

  public static void main(String[] args) {
    JListTest02A w = new JListTest02A( "JListTest02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 360, 280 );
    w.setVisible( true );
  }
  public JListTest02A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new JList02A( "単一選択" ) );
    tool.add( new JList02B( "単一区間選択" ) );
    tool.add( new JList02C( "複数項目選択" ) );
    tool.add( new JList02D( "複数区間選択" ) );
  }
  class JList02A extends AbstractAction {
    JList02A( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      JList list = new JList( choice );
      list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
      list.setSelectedIndex( 2 );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
  class JList02B extends AbstractAction {
    JList02B( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      JList list = new JList( choice );
      list.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
      list.setSelectionInterval( 2, 4 );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
  class JList02C extends AbstractAction {
    JList02C( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      JList list = new JList( choice );
      list.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
      int[] selected = { 2, 4, 5 };
      list.setSelectedIndices( selected );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
  class JList02D extends AbstractAction {
    JList02D( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      JList list = new JList( choice );
      list.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
      list.addSelectionInterval( 0, 2 );
      list.addSelectionInterval( 4, 6 );

      Object[]  obj = { list };
      int ans = JOptionPane.showConfirmDialog( pane, obj );
    }
  }
}
