package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest03 extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest03 w = new JComboTest03( "JComboTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest03( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.addActionListener( new MyListSelect() );
    combo.setEditable( true );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ){
      System.out.println( e );
      JComboBox combo = (JComboBox)e.getSource();
      int selectNo = combo.getSelectedIndex();
      String select = (String)combo.getSelectedItem();
      tf.setText( selectNo +": "+ select );
    }
  }
}
/****
同じ項目であってもクリックする度に Action イベントが発生する。
編集可能な状態でフィールドに入力して Enter キーを押すと、Action イベントが発生する。
その場合には、JComboBox の getSelectedIndex() の戻り値は -1 となる。
また、編集フィールドの内容が同じであっても、Enter キーを押す度に、Action イベントが発生する。
****/
