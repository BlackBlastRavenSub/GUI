package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest02B extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest02B w = new JComboTest02B( "JComboTest02B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest02B( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.addItemListener( new MyListSelect() );
    combo.setEditable( true );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ItemListener {
    public void itemStateChanged( ItemEvent e ){
      System.out.println( e );
      if( e.getStateChange() == ItemEvent.SELECTED ){
        JComboBox combo = (JComboBox)e.getSource();
        int selectNo = combo.getSelectedIndex();
        String select = (String)combo.getSelectedItem();
        tf.setText( selectNo +": "+ select );
      }
    }
  }
}
/****
編集可能な状態でフィールドに入力して Enter キーを押すと、Item イベントが発生する。
一度の Enter キーの押下で、DESELECTED・SELECTED の２回のItem イベントが発生する。
その場合には、JComboBox の getSelectedIndex() の戻り値は -1 となる。
フィールドの内容を変更しないで Enter キーを押しても、Item イベントは発生しない。
****/
