package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI03A extends MDI01 {

JDesktopPane desktop;

  MDI03A( String title ){
     super( title );
     desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 220 );
     frame1.addMouseListener( new MouseCheck() );
     frame1.addFocusListener( new FocusCheck() );
     frame1.addKeyListener( new KeyCheck() );
     desktop.add( frame1, new Integer(1) );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     frame2.addMouseListener( new MouseCheck() );
     frame2.addFocusListener( new FocusCheck() );
     frame2.addKeyListener( new KeyCheck() );
     desktop.add( frame2, new Integer(2) );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 280, 220 );
     frame3.addMouseListener( new MouseCheck() );
     frame3.addFocusListener( new FocusCheck() );
     frame3.addKeyListener( new KeyCheck() );
     desktop.add( frame3, new Integer(2) );
  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      System.out.println( f.getTitle() +" mouse pressed" );
      f.requestFocus();
    }
  }
  class FocusCheck implements FocusListener {
    @Override
    public void focusGained( FocusEvent e ){
       JInternalFrame f = (JInternalFrame)e.getSource();
       System.out.println( f.getTitle() +" focus gained" );
    }
    @Override
    public void focusLost( FocusEvent e ){
       JInternalFrame f = (JInternalFrame)e.getSource();
       System.out.println( f.getTitle() +" focus lost" );
    }
  }
  class KeyCheck extends KeyAdapter {
    JInternalFrame lastOne = null;
    int x = 0;
    int y = 15;
    @Override
    public void keyPressed( KeyEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      Component pane = f.getContentPane();
      Graphics g = pane.getGraphics();
      String text = String.valueOf( e.getKeyChar() );
      if( f == lastOne ) x += 10; else x = 0;
      g.drawString( text, x, y );
      lastOne = f;
    }
  }

  public static void main( String[] args ){
    JFrame frame = new MDI03A( "MDI 03A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
}
