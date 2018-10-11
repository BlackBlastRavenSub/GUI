package vol1.ch06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest05B extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest05B w = new DialogTest05B( "DialogTest05B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public DialogTest05B( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();
    pane.add( new JButton( new Dialog05B( "Input Dialog [タイトル・アイコン指定]" ) ), BorderLayout.NORTH );
  }
  class Dialog05B extends AbstractAction {
    Dialog05B( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "1st line", "2nd line", "3rd line", "4th line" };
      String ans = JOptionPane.showInputDialog( pane, msg, "ユーザーからの文字列を受け付けます", 
                                          JOptionPane.INFORMATION_MESSAGE );
      System.out.println( ans );
    }
  }
}
