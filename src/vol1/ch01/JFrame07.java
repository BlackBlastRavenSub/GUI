package vol1.ch01;
import java.awt.event.*;
import javax.swing.*;

public class JFrame07 extends JFrame {
  public static void main(String[] args) {
    new JFrame07( "JFrame07" );
  }
  public JFrame07( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    addWindowListener( new WindowEventHandler() );
    setSize(500, 300);
    System.out.println( "ウインドウの準備が出来ました" );
    setVisible(true);
    System.out.println( "ウインドウの表示がオンになりました" );
    setVisible(false);
    setVisible(true);
  }
  class WindowEventHandler implements WindowListener {
    public void windowOpened( WindowEvent e ) {
      System.out.println( "ウインドウが開きました" );
    }
    public void windowClosing( WindowEvent e ) {
      System.out.println( "ウインドウが閉じようとしています" );
    }
    public void windowClosed( WindowEvent e ) {
      System.out.println( "ウインドウが閉じました" );
    }
    public void windowIconified( WindowEvent e ) {
      System.out.println( "ウインドウがアイコン化されました" );
    }
    public void windowDeiconified( WindowEvent e ) {
      System.out.println( "ウインドウがアイコン化から復元しました" );
    }
    public void windowActivated( WindowEvent e ) {
      System.out.println( "ウインドウが活性化しました" );
    }
    public void windowDeactivated( WindowEvent e ) {
      System.out.println( "ウインドウが非活性化しました" );
    }
  }
}
