package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI03 extends MDI01 {
  
  JDesktopPane desktop;
  
  MDI03( String title ){
     super( title );
     desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 220 );
     frame1.addMouseListener( new MouseCheck() );
     frame1.addFocusListener( new FocusCheck() );
     desktop.add( frame1, new Integer(1) );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     frame2.addMouseListener( new MouseCheck() );
     frame2.addFocusListener( new FocusCheck() );
     desktop.add( frame2, new Integer(2) );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 280, 220 );
     frame3.addMouseListener( new MouseCheck() );
     frame3.addFocusListener( new FocusCheck() );
     desktop.add( frame3, new Integer(2) );
  }

  class MouseCheck extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      System.out.println( f.getTitle() +" mouse pressed" );
    }
    @Override
    public void mouseReleased( MouseEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      System.out.println( f.getTitle() +" mouse released" );
    }
    @Override
    public void mouseClicked( MouseEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      System.out.println( f.getTitle() +" mouse clicked" );
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

  public static void main( String[] args ){
    JFrame frame = new MDI03( "MDI 03" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
}

/**
最初のマウスクリックで インターナルフレームの選択が行われる。
そのインターナルフレーム上での２回目以降のマウスクリックがマウスイベントとして通知される。
**/
