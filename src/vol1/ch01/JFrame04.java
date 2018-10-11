package vol1.ch01;
import java.awt.event.*;
import javax.swing.*;

public class JFrame04 extends JFrame {
  public static void main(String[] args) {
    new JFrame04( "JFrame04" );
  }
  public JFrame04( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
    addWindowListener( new WindowClosing() );
    setSize(500, 300);
    setVisible(true);
  }
  class WindowClosing extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      int ans = JOptionPane.showConfirmDialog( JFrame04.this, "ほんとうに終了しますか？" );
      if( ans == JOptionPane.YES_OPTION ){
        System.exit(0);
      }
    }
  }
}
