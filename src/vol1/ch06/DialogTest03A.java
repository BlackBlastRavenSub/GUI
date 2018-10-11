package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest03A extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest03A w = new DialogTest03A( "DialogTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest03A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog03A( "DEFAULT" ) );
    tool.add( new Dialog03B( "YES_NO" ) );
    tool.add( new Dialog03C( "YES_NO_CANCEL" ) );
    tool.add( new Dialog03D( "OK_CANCEL" ) );
  }
  class Dialog03A extends AbstractAction {
    Dialog03A( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg, "了解",
                                          JOptionPane.DEFAULT_OPTION );
      System.out.println( ans );
    }
  }
  class Dialog03B extends AbstractAction {
    Dialog03B( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg, "はい・いいえ",
                                           JOptionPane.YES_NO_OPTION );
      System.out.println( ans );
    }
  }
  class Dialog03C extends AbstractAction {
    Dialog03C( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg, "はい・いいえ・取消し",
                                           JOptionPane.YES_NO_CANCEL_OPTION );
      System.out.println( ans );
    }
  }
  class Dialog03D extends AbstractAction {
    Dialog03D( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      int ans = JOptionPane.showConfirmDialog( pane, msg, "了解・取消し",
                                           JOptionPane.OK_CANCEL_OPTION );
      System.out.println( ans );
    }
  }
}
