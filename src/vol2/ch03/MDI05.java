package vol2.ch03;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class MDI05 extends MDI01 {

JDesktopPane desktop;

  MDI05( String title ){
     super( title );
     desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 220 );
     desktop.add( frame1, new Integer(1) );
     frame1.addInternalFrameListener( new InternalFrameCheck() );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     desktop.add( frame2, new Integer(2) );
     frame2.addInternalFrameListener( new InternalFrameCheck() );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 300, 220 );
     desktop.add( frame3, new Integer(2) );
     frame3.addInternalFrameListener( new InternalFrameCheck() );
  }

  public static void main( String[] args ){
    JFrame frame = new MDI05( "MDI 05" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }

  class InternalFrameCheck implements InternalFrameListener {
    @Override
    public void internalFrameOpened(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameOpened" );
    }
    @Override
    public void internalFrameClosing(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameClosing" );
    }
    @Override
    public void internalFrameClosed(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameClosed" );
    }
    @Override
    public void internalFrameIconified(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameIconified" );
    }
    @Override
    public void internalFrameDeiconified(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameDeiconified" );
    }
    @Override
    public void internalFrameActivated(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameActivated" );
    }
    @Override
    public void internalFrameDeactivated(InternalFrameEvent e){
       JInternalFrame f = e.getInternalFrame();
       System.out.println( f.getTitle() +" internalFrameDeactivated" );
    }
  }
}
