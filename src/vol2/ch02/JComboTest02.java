package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest02 extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest02 w = new JComboTest02( "JComboTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public JComboTest02( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.addItemListener( new MyListSelect() );

    pane.add( combo, BorderLayout.NORTH );
  }
  class MyListSelect implements ItemListener {
    @Override
    public void itemStateChanged( ItemEvent e ){

      if( e.getStateChange()==ItemEvent.SELECTED ){
        System.out.println( "選択されました" );
      }
      else{
        System.out.println( "選択解除されました" );
      }
      System.out.println( "対象項目は "+ e.getItem() );
      System.out.println( "イベント発生元は "+ e.getItemSelectable() );
    }
  }
}
