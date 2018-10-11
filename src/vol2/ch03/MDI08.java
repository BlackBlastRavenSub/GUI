package vol2.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MDI08 extends JFrame {

JDesktopPane desktop;

  class MouseCheck extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      new WindowList();
    }
  }
  class WindowList extends JInternalFrame {
    WindowList() {
      super( "Window List", true, true ); // resizable & closable
      JInternalFrame[] frames = desktop.getAllFrames();
      int frameCount = frames.length;
      String[] frameNames = new String[frameCount];
      for( int i=0 ; i<frameCount ; i++ ){
        frameNames[i] = frames[i].getTitle() + " : layer " + frames[i].getLayer();
	/* 選択されているフレームの欄に印を付ける */
        if( frames[i].isSelected() ) frameNames[i] += "**"; 
      }
      JList list = new JList( frameNames );
      JScrollPane scroll = new JScrollPane( list );
      getContentPane().add( scroll, BorderLayout.CENTER );
      setBounds( 0,0, 120,300 );
      setVisible( true );
      desktop.add( this, new Integer( 10 ) );
    }
  }

  public static void main( String[] args ){
    JFrame frame = new MDI08( "MDI 08" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 650, 450 );
    frame.setVisible(true);
  }

  MDI08( String title ){
    super( title );
    desktop = new JDesktopPane();
    Container pane = getContentPane();
    pane.add( desktop, BorderLayout.CENTER );
    setupInternalFrames( desktop );
    desktop.addMouseListener( new MouseCheck() );
  }

  void setupInternalFrames( JDesktopPane desktop ){
    JInternalFrame frame1 = new JInternalFrame( "frame 1", true, true, true, true );
    frame1.setBounds( 110, 10, 300, 200 );
    frame1.setVisible( true );
    desktop.add( frame1, new Integer(1) ); // レイヤー1

    JInternalFrame frame2 = new JInternalFrame( "frame 2" , true, true, true, true );
    frame2.setBounds( 140, 40, 300, 200 );
    frame2.setVisible( true );
    desktop.add( frame2, new Integer(1) ); // レイヤー1

    JInternalFrame frame3 = new JInternalFrame( "frame 3" , true, true, true, true );
    frame3.setBounds( 170, 70, 300, 200 );
    frame3.setVisible( true );
    desktop.add( frame3, new Integer(1) ); // レイヤー1

    JInternalFrame frame4 = new JInternalFrame( "frame 4" , true, true, true, true );
    frame4.setBounds( 220, 120, 300, 200 );
    frame4.setVisible( true );
    desktop.add( frame4, new Integer(2) ); // レイヤー2

    JInternalFrame frame5 = new JInternalFrame( "frame 5" , true, true, true, true );
    frame5.setBounds( 270, 170, 300, 200 );
    frame5.setVisible( true );
    desktop.add( frame5, new Integer(2) ); // レイヤー2

    JInternalFrame frame6 = new JInternalFrame( "frame 6" , true, true, true, true );
    frame6.setBounds( 320, 220, 300, 200 );
    frame6.setVisible( true );
    desktop.add( frame6, new Integer(3) ); // レイヤー3
  }
}
