package vol1.ch01;
import java.awt.event.*;
import javax.swing.*;

public class JFrame08 extends JFrame {
  public static void main(String[] args) {
    new JFrame08( "JFrame08" );
  }
  public JFrame08( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    Runtime.getRuntime().addShutdownHook( new Shutdown1() );
    Runtime.getRuntime().addShutdownHook( new Shutdown2() );
    addWindowListener( new WindowEventHandler() );
    setSize(500, 300);
    setVisible(true);
  }
  class Shutdown1 extends Thread {
    public void run() {
      System.out.println( "シャットダウンフック１が呼び出されました" );
    }
  }
  class Shutdown2 extends Thread {
    public void run() {
      System.out.println( "シャットダウンフック２が呼び出されました" );
    }
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
    public void windowIconified( WindowEvent e ) { }
    public void windowDeiconified( WindowEvent e ) { }
    public void windowActivated( WindowEvent e ) { }
    public void windowDeactivated( WindowEvent e ) { }
  }
}
