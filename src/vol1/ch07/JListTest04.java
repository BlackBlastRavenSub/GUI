package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest04 extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JListTest04 w = new JListTest04( "JListTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 210 );
    w.setVisible( true );
  }
  public JListTest04( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "abcd", "acad", "acbd", "accd", "abb", "acc" };
    JList list = new JList( choice );

    list.addListSelectionListener( new MyListSelect() );

    int found = list.getNextMatch( "acc", 0, Position.Bias.Forward );
    list.setSelectedIndex( found );

    pane.add( list, BorderLayout.CENTER );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    list.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){
      System.out.println( e ); // ListSelectionEvent を観察するため

      JList li = (JList)e.getSource();
      if( e.getValueIsAdjusting()==false ){ 
        String select = (String)li.getSelectedValue();
        tf.setText( select  );
      }
    }
  }
}
