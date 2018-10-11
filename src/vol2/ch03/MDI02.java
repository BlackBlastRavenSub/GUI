package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

class MDI02 extends MDI01 {

  MDI02( String title ){
     super( title );
     JDesktopPane desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 200 );
     desktop.add( frame1 );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     desktop.add( frame2, new Integer(1) );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 280, 220 );
     desktop.add( frame3, new Integer(3) );

     frame1.setLayer( new Integer(1) );
  }

  public static void main( String[] args ){
    JFrame frame = new MDI02( "MDI 02" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
}
