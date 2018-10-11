package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI06 extends MDI01 {

JDesktopPane desktop;

  MDI06( String title ){
     super( title );
     desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 220 );
     desktop.add( frame1, new Integer(1) );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     desktop.add( frame2, new Integer(2) );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 300, 220 );
     desktop.add( frame3, new Integer(2) );

     desktop.setDesktopManager( new MyDesktopManager() );
  }

  public static void main( String[] args ){
    JFrame frame = new MDI06( "MDI 06" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }

  class MyDesktopManager extends DefaultDesktopManager {
    @Override
    public void openFrame( JInternalFrame f ) {
       System.out.println( "openFrame "+ f.getTitle() );
       super.openFrame(f);
    }
    @Override
    public void closeFrame( JInternalFrame f ) {
       System.out.println( "closeFrame "+ f.getTitle() );
       super.closeFrame(f);
    }
    @Override
    public void maximizeFrame(JInternalFrame f) {
       System.out.println( "maximizeFrame "+ f.getTitle() );
       super.maximizeFrame(f);
    }
    @Override
    public void minimizeFrame( JInternalFrame f ) {
       System.out.println( "minimizeFrame "+ f.getTitle() );
       super.minimizeFrame(f);
    }
    @Override
    public void iconifyFrame( JInternalFrame f ) {
       System.out.println( "iconifyFrame "+ f.getTitle() );
       super.iconifyFrame(f);
    }
    @Override
    public void deiconifyFrame( JInternalFrame f ) {
       System.out.println( "deiconifyFrame "+ f.getTitle() );
       super.deiconifyFrame(f);
    }
    @Override
    public void activateFrame(JInternalFrame f) {
       System.out.println( "activateFrame "+ f.getTitle() );
       super.activateFrame(f);
    }
    public void deactivateFrame(JInternalFrame f)
    {
       System.out.println( "deactivateFrame "+ f.getTitle() );
       super.deactivateFrame(f);
    }
    @Override
    public void beginDraggingFrame( JComponent c ) {
       JInternalFrame f = null;
       if( c instanceof JInternalFrame.JDesktopIcon ){
          f = ( (JInternalFrame.JDesktopIcon)c ).getInternalFrame();
       }else{
          f = (JInternalFrame)c;
       }
       System.out.println( "beginDraggingFrame " + f.getTitle() );
       super.beginDraggingFrame(c);
    }
    @Override
    public void dragFrame( JComponent c, int newX, int newY ) {
       JInternalFrame f = null;
       if( c instanceof JInternalFrame.JDesktopIcon ){
          f = ( (JInternalFrame.JDesktopIcon)c ).getInternalFrame();
       }else{
          f = (JInternalFrame)c;
       }
       System.out.println( "dragFrame " + f.getTitle() + " " + newX + " " + newY );
       super.dragFrame( c, newX, newY );
    }
    @Override
    public void endDraggingFrame( JComponent c ) {
       JInternalFrame f = null;
       if( c instanceof JInternalFrame.JDesktopIcon ){
          f = ((JInternalFrame.JDesktopIcon)c).getInternalFrame();
       }else{
          f = (JInternalFrame)c;
       }
       System.out.println( "endDraggingFrame "+ f.getTitle() );
       super.endDraggingFrame(c);
    }
    @Override
    public void beginResizingFrame( JComponent c, int direction ) {
       JInternalFrame f = (JInternalFrame)c;
       System.out.println( "beginResizingFrame "+ f.getTitle() +" "+ direction );
       super.beginResizingFrame(f, direction);
    }
    @Override
    public void resizeFrame( JComponent c, int newX, int newY, int newW, int newH ) {
       JInternalFrame f = (JInternalFrame)c;
       System.out.println( "resizeFrame "+ f.getTitle() + " " + newX + " " + newY +
         " " + newW + " " + newH );
       super.resizeFrame( f, newX, newY, newW, newH );
    }
    @Override
    public void endResizingFrame( JComponent c ) {
       JInternalFrame f = (JInternalFrame)c;
       System.out.println( "endResizingFrame "+ f.getTitle() );
       super.endResizingFrame(f);
    }
    public void setBoundsForFrame( JComponent c, 
                                     int newX, int newY, int newW, int newH ) {
       JInternalFrame f = null;
       if( c instanceof JInternalFrame.JDesktopIcon ){
          JInternalFrame.JDesktopIcon icon = (JInternalFrame.JDesktopIcon)c;
          f = icon.getInternalFrame();
          System.out.println( "setBoundsForFrame (icon)" + f.getTitle() + " " + 
            newX + " " + newY + " " + newW + " " + newH );
       } else {
          f = (JInternalFrame)c;
          System.out.println( "setBoundsForFrame "+ f.getTitle() + " " + newX + " " +
            newY + " " + newW + " " + newH );
       }
       super.setBoundsForFrame( c, newX, newY, newW, newH );
    }
  }
}