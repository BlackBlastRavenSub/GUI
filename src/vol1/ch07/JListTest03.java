package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class JListTest03 extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JListTest03 w = new JListTest03( "JListTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JListTest03( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "1111", "2222", "3333", "4444", "5555" };
    JList list = new JList( choice );
    list.addListSelectionListener( new MyListSelect() );

    pane.add( list, BorderLayout.CENTER );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    list.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){

      JList li = (JList)e.getSource();
      if( e.getValueIsAdjusting()==false ){ 
        String select = (String)li.getSelectedValue();
        tf.setText( select  );
      }
    }
  }
}
