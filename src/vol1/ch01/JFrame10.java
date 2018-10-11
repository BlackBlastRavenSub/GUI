package vol1.ch01;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JFrame10 extends JFrame {
  public static void main(String[] args) {
    new JFrame10( "JFrame10" );
  }
  public JFrame10( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    addComponentListener( new ComponentEventHandler() );
    addWindowListener( new WindowEventHandler() );
    setLocation(100,100);
    setSize(500, 300);
    System.out.println( "ウインドウの準備が出来ました" );
    setVisible(true);
    System.out.println( "ウインドウの表示がオンになりました" );
    setVisible(false);
    setVisible(true);
  }
  class ComponentEventHandler implements ComponentListener {
    public void componentMoved( ComponentEvent e ){
      System.out.println( "ウインドウが移動しました" );
      Point p = e.getComponent().getLocation();
      System.out.println( "新しい位置は "+ p.x +","+ p.y +" です。" );
    }
    public void componentResized( ComponentEvent e ){
      System.out.println( "ウインドウのサイズが変更されました" );
      Dimension d = e.getComponent().getSize();
      System.out.println( "新しい大きさは "+ d.width +","+ d.height +" です。" );
    }
    public void componentShown( ComponentEvent e ){
      System.out.println( "ウインドウが表示状態になりました" );
    }
    public void componentHidden( ComponentEvent e ){
      System.out.println( "ウインドウが非表示状態になりました" );
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
