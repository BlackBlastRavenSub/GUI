package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboTest05D extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    JComboTest05D w = new JComboTest05D( "JComboTest05D" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest05D( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333" };

    JComboBox combo = new JComboBox( choice );
    //存在しない項目を指定すると 最初の項目が選択される
    combo.setSelectedItem( "9999" ); 

    pane.add( combo, BorderLayout.NORTH );

    JList list = new JList( choice );
    //存在しないインデックス番号を指定しても 選択されないだけで何も起こらない。
    list.setSelectedValue( "9999", true ); 

    pane.add( list, BorderLayout.SOUTH );
  }
}
