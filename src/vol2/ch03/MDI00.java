package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI00 extends JFrame {

  MDI00(){
     super( "Internal frame" );
     JDesktopPane desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = new JInternalFrame( "frame 1" );
     frame1.setSize( 300, 200 );
     frame1.setVisible( true );
     desktop.add( frame1 );

     JInternalFrame frame2 = new JInternalFrame( "frame 2" );
     frame2.setSize( 300, 200 );
     frame2.setVisible( true );
     desktop.add( frame2 );
  }

  public static void main( String[] args ){
    JFrame frame = new MDI00();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 440, 340 );
    frame.setVisible( true );
  }
}
