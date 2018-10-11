package vol2.ch03;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

class MDI09 extends JFrame {

JDesktopPane desktop;
WindowList windowList = null;

  class MouseCheck extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      if( windowList == null ){ 
        windowList = new WindowList();
      }
      else{
        windowList.dispose();
        windowList = null;
      }
    }
  }

  class WindowList extends JInternalFrame {
    WindowList() {
      super( "Window List", true, true ); // resizable & closable
      setupWindowList();
      setBounds( 0,0, 150,300 );
      setVisible(true);
      desktop.add( this, new Integer( 100 ) );
    }
    void setupWindowList(){
      DefaultMutableTreeNode root = new DefaultMutableTreeNode( "Desktop" );
      int frameCount = 0;
      for( int i= desktop.lowestLayer() ; i<= desktop.highestLayer() ; i++ ){
        JInternalFrame[] frames = desktop.getAllFramesInLayer(i);
        if( frames == null ) break;
        frameCount = frames.length;
        if( frameCount < 1 ) continue;

        DefaultMutableTreeNode layerRoot = new DefaultMutableTreeNode( "layer "+ i );
        root.add( layerRoot );
        for( int j = 0 ; j < frameCount ; j++ ){
          String frameName = frames[j].getTitle();
          /* 選択されているフレームの欄に印を付ける */
          if( frames[j].isSelected() ) frameName += "**"; 
          layerRoot.add( new DefaultMutableTreeNode( frameName ) );
        }
      }
      JTree tree = new JTree( root );
      for( int row=0 ; row < tree.getRowCount() ; row++ ){
        tree.expandRow( row );
      }
      JScrollPane scroll = new JScrollPane( tree );
      getContentPane().add( scroll, BorderLayout.CENTER );
    }
  }

  public static void main( String[] args ){
    JFrame frame = new MDI09( "MDI 09" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 650, 450 );
    frame.setVisible( true );
  }

  MDI09( String title ){
    super( title );
    desktop = new JDesktopPane();
    Container pane = getContentPane();
    pane.add( desktop, BorderLayout.CENTER );
    MouseCheck mouseCheck = new MouseCheck();
    setupInternalFrames( desktop );
    desktop.addMouseListener( mouseCheck );
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
