package vol1.ch01;
import java.awt.event.*;
import javax.swing.*;

class JFrame03 {
  public static void main(String[] args) {
    JFrame frame = new JFrame( "JFrame03" );
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize(400, 300);
    frame.setVisible(true);
  }
}
