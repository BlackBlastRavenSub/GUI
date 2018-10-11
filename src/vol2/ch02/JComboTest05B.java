package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest05B extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest05B w = new JComboTest05B( "JComboTest05B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest05B( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333" };

    JComboBox combo = new JComboBox( choice );
    //存在しないインデックス番号を指定すると IllegalArgumentException が発生する
    combo.setSelectedIndex( 9 );

    pane.add( combo, BorderLayout.NORTH );

    JList list = new JList( choice );
    //存在しないインデックス番号を指定しても 選択されないだけで何も起こらない。
    list.setSelectedIndex( 9 );

    pane.add( list, BorderLayout.SOUTH );
  }
}
