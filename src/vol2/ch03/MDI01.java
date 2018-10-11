package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI01 extends JFrame {

  MDI01( String title ){
     super( title );
     JDesktopPane desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 300, 200 );
     desktop.add( frame1 );

     JInternalFrame frame2 = makeFrame( "frame 2", 120, 80, 300, 200 );
     desktop.add( frame2 );
  }

  JInternalFrame makeFrame( String title, int x, int y, int w, int h ){
    JInternalFrame f = new JInternalFrame( title );
    f.setClosable( true );
    f.setMaximizable( true );
    f.setIconifiable( true );
    f.setResizable( true );
    f.setBounds( x, y, w, h );
    f.setVisible( true );
    return( f );
  }
  public static void main( String[] args ){
    JFrame frame = new MDI01( "MDI 01" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 440, 340 );
    frame.setVisible( true );
  }
}
