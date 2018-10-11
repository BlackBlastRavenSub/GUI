package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI04 extends MDI01 {

JDesktopPane desktop;

  MDI04( String title ){
     super( title );
     desktop = new JDesktopPane();
     getContentPane().add( desktop, BorderLayout.CENTER );

     JInternalFrame frame1 = makeFrame( "frame 1", 10, 10, 220, 220 );
     frame1.addMouseListener( new MouseCheck() );
     desktop.add( frame1, new Integer(1) );

     JInternalFrame frame2 = makeFrame( "frame 2", 175, 80, 300, 200 );
     frame2.addMouseListener( new MouseCheck() );
     desktop.add( frame2, new Integer(2) );

     JInternalFrame frame3 = makeFrame( "frame 3", 100, 145, 300, 220 );
     desktop.add( frame3, new Integer(4) );
  }

  class MouseCheck extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      JInternalFrame f = (JInternalFrame)e.getSource();
      int layer = f.getLayer();
      int newLayer = layer + 2;
      //desktop.setLayer( f, newLayer );
      f.setLayer( new Integer(newLayer) );
      System.out.println( f.getTitle() + "のレイヤー番号は、" + layer +"から　" + 
        newLayer + "になりました" );
    }
  }

  public static void main( String[] args ){
    JFrame frame = new MDI04( "MDI 04" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
}
