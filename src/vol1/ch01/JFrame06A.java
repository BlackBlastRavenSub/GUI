package vol1.ch01;
import javax.swing.*;
import java.awt.*;

public class JFrame06A {
  public static void main(String[] args) {
    System.out.println( "アイコン化はサポートされていますか" +
        Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.ICONIFIED) ); 
    System.out.println( "水平方向の最大化はサポートされていますか" +
        Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.MAXIMIZED_HORIZ) ); 
    System.out.println( "垂直方向の最大化はサポートされていますか" +
        Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.MAXIMIZED_VERT) ); 
    System.out.println( "画面全体の最大化はサポートされていますか" +
        Toolkit.getDefaultToolkit().isFrameStateSupported(JFrame.MAXIMIZED_BOTH) );   
  }
}
