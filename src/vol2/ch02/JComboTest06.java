package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest06 extends JFrame {
  JTextField tf;
  JComboBox combo1, combo2, combo3;

  public static void main(String[] args) {
    JComboTest06 w = new JComboTest06( "JComboTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 280 );
    w.setVisible( true );
  }
  public JComboTest06( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    ComboBoxEditor ed;

    combo1 = new JComboBox( choice );
    ed = combo1.getEditor();
    System.out.println( ed );
    ed.addActionListener( new ModifyAction( combo1 ) );
    combo1.setEditable( true );
    combo1.setBorder( new TitledBorder( "指定項目を後ろに追加" ) );
    pane.add( combo1 );

    combo2 = new JComboBox( choice );
    ed = combo2.getEditor();
    ed.addActionListener( new ModifyAction( combo2 ) );
    combo2.setEditable( true );
    combo2.setBorder( new TitledBorder( "指定項目を先頭に挿入" ) );
    pane.add( combo2 );

    combo3 = new JComboBox( choice );
    ed = combo3.getEditor();
    ed.addActionListener( new ModifyAction( combo3 ) );
    combo3.setEditable( true );
    combo3.setBorder( new TitledBorder( "指定項目を削除" ) );
    pane.add( combo3 );

  }

  class ModifyAction implements ActionListener {
    JComboBox combo;
    ModifyAction( JComboBox combo ){
      this.combo = combo;
    }

    @Override
    public void actionPerformed( ActionEvent e ){
      JTextField tf = (JTextField)(e.getSource());
      String item = tf.getText();
      if( combo == combo1 ){
        combo.addItem( item ); //指定項目を後ろに追加
        combo.setSelectedItem( item );
      }
      if( combo == combo2 ){
        combo.insertItemAt( item, 0 ); //指定項目を先頭に挿入
        combo.setSelectedItem( item );
      }
      if( combo == combo3 ){
        combo.removeItem( item ); //指定項目を削除
      }
    }
  }
}
