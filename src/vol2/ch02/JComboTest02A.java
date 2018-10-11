package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest02A extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest02A w = new JComboTest02A( "JComboTest02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest02A( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.addItemListener( new MyListSelect() );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ItemListener {
    public void itemStateChanged( ItemEvent e ){
      //同じ項目をもう一度クリックしても、Item イベントは発生しない
      if( e.getStateChange() == ItemEvent.SELECTED ){
        JComboBox combo = (JComboBox)e.getSource();
        int selectNo = combo.getSelectedIndex();
        String select = (String)combo.getSelectedItem();
        tf.setText( selectNo +": "+ select );
      }
    }
  }
}
