package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest07 extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest07 w = new DialogTest07( "DialogTest07" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest07( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog07( "JList in JOptionPane" ) );
  }
  class Dialog07 extends AbstractAction {
    Dialog07( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      String[] choice = { "One", "Two", "Three" };
      JList list = new JList( choice );

      JRadioButton bt1 = new JRadioButton( "ラジオボタン" );
      JCheckBox    bt2 = new JCheckBox( "チェックボックス" );
      Object[] msg = { list, bt1, bt2 };
      
      int ans = JOptionPane.showConfirmDialog( pane, msg, "JOptionPane の中で JList が使える",
                                           JOptionPane.OK_CANCEL_OPTION );
      System.out.println( list.getSelectedValue() );
    }
  }
}
