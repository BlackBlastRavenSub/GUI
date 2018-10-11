package vol1.ch01;
import java.awt.event.*;
import javax.swing.*;

public class JFrame07A extends JFrame {
  public static void main(String[] args) {
    new JFrame07A( "JFrame07A" );
  }
  public JFrame07A( String title ){
    super( title );
    //*** setDefaultCloseOperation() を指定しない場合
    addWindowListener( new WindowEventHandler() );
    setSize(500, 300);
    setVisible(true);
  }
  class WindowEventHandler implements WindowListener {
    public void windowOpened( WindowEvent e ) { }
    public void windowClosing( WindowEvent e ) {
      System.out.println( "ウインドウが閉じようとしています" );
      System.exit(0); //ここで明示的にアプリケーション終了を指定
    }
    public void windowClosed( WindowEvent e ) {
      //*** System.exit() を明示的に呼び出している場合には、このイベントは通知されない
      System.out.println( "ウインドウが閉じました" );
    }
    public void windowIconified( WindowEvent e ) { }
    public void windowDeiconified( WindowEvent e ) { }
    public void windowActivated( WindowEvent e ) { }
    public void windowDeactivated( WindowEvent e ) { }
  }
}
