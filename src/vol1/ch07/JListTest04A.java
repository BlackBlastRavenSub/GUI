package vol1.ch07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest04A extends JFrame {
  JPanel pane;
  JTextField tf = new JTextField();
  JList list;

  public static void main(String[] args) {
    JListTest04A w = new JListTest04A( "JListTest04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 180 );
    w.setVisible( true );
  }
  public JListTest04A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new JList04A( "項目の検索とスクロール" ) );
  }

  class JList04A extends AbstractAction {
    JList04A( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){

      JButton search = new JButton( new Search( "検索" ) );

      String[] choice = { "11", "22", "33", "44", "55", "abcd", "acad", "acbd", "accd" };
      list = new JList( choice );

      list.setVisibleRowCount( 4 );
      list.addListSelectionListener( new MyListSelect() );

      JScrollPane scr = new JScrollPane( list );
      Object[] obj = { scr, search, tf };

      tf.setBorder( new TitledBorder( "選択された項目" ) );
      list.setBorder( new LineBorder( Color.black, 2 ) );

      JOptionPane.showConfirmDialog( pane, obj );
    }
  }

  class Search extends AbstractAction {
    Search( String text ) { super( text ); }
    public void actionPerformed( ActionEvent e ){
      int found = list.getNextMatch( "acc", 0, Position.Bias.Forward );
      list.setSelectedIndex( found );
      list.requestFocus();
    }
  }

  class MyListSelect implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){
      System.out.println( e ); // ListSelectionEvent を観察するため

      JList li = (JList)e.getSource();
      if( e.getValueIsAdjusting()==false ){ 
        String select = (String)li.getSelectedValue();
        tf.setText( select );
        int pos = list.getSelectedIndex();
        list.ensureIndexIsVisible( pos );
      }
    }
  }
}
