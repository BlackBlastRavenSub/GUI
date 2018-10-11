package vol2.ch03;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

class MDI10 extends JFrame {

JDesktopPane desktop;
WindowList windowList = null;
JInternalFrame frame1, frame2, frame3, frame4, frame5, frame6;

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      if( windowList == null ){ 
         windowList = new WindowList();
         windowList.open();
      }else{
         windowList.close();
      }
    }
  }

  class WindowList extends JInternalFrame implements ActionListener {
    JPopupMenu menu;
    JMenuItem[] m = new JMenuItem[6];
    String[] commandName = { "Close", "Activate", "Maximize", "Iconize", 
      "Restore", "Deactivate" };
    JInternalFrame[] frames;
    JList list;

    WindowList() {
      super( "Window List", true, true ); // resizable & closable
      setupWindowListMenu();
      setupWindowList();
      setBounds( 0,0, 150,300 );
      desktop.add( this, new Integer(100) );
    }

    void setupWindowList(){
      frames = desktop.getAllFrames();
      int frameCount = frames.length;
      String[] frameNames = new String[frameCount];
      for( int i=0 ; i<frameCount ; i++ ){
        frameNames[i] = frames[i].getTitle() + " : layer " + frames[i].getLayer();
        if( frames[i].isMaximum() ) frameNames[i] += "###"; 
                             //最大化されているウィンドウの欄に印を付ける
        if( frames[i].isSelected() ) frameNames[i] += "***"; 
                             //選択されているウィンドウの欄に印を付ける
        if( frames[i].isIcon() ) frameNames[i] += "___"; 
                             //最小化されているウィンドウの欄に印を付ける
        if( frames[i].isClosed() ) frameNames[i] += "..."; 
                             //閉じているウィンドウの欄に印を付ける
      }
      list = new JList( frameNames );
      list.addMouseListener( new PopupCheck() );
      JScrollPane scroll = new JScrollPane( list );
      getContentPane().add( scroll, BorderLayout.CENTER );
    }

    void setupWindowListMenu(){
      menu = new JPopupMenu();
      for( int i=0 ; i<6 ; i++ ){
        m[i] = new JMenuItem( commandName[i] );
        m[i].addActionListener( this );
        menu.add( m[i] );
      }
    }
    class PopupCheck extends MouseAdapter {
      @Override
      public void mousePressed( MouseEvent e ){
        menu.show( e.getComponent(), e.getX(), e.getY() );
      }
    }

    void close(){
        try {
          windowList.setClosed(true);
        }catch( PropertyVetoException pve ){
          System.out.println( pve );
        }
        windowList = null;
    }

    void open(){
        try {
          windowList.setVisible(true);
          windowList.setSelected(true);
        }catch( PropertyVetoException pve ){
          System.out.println( pve );
        }
    }
    @Override
    public void actionPerformed( ActionEvent e ){
      JMenuItem mi = (JMenuItem)e.getSource();
      int row = list.getSelectedIndex();
      if( row < 0 ) return;

      try {
        if( mi == m[0] ){ // close
          frames[row].setClosed(true);
        }
        if( mi == m[1] ){ // activate
          frames[row].setSelected(true);
          frames[row].requestFocus();
        }
        if( mi == m[2] ){ // maximize
          frames[row].setMaximum(true);
        }
        if( mi == m[3] ){ // iconize
          frames[row].setIcon(true);
        }
        if( mi == m[4] ){ // restore
          frames[row].setIcon(false);
          frames[row].setMaximum(false);
        }
        if( mi == m[5] ){ // deactivate
          frames[row].setSelected(false);
        }
      }catch( PropertyVetoException pve ){
        System.out.println( pve );
      }
      windowList.close();
    }
  }

  public static void main( String[] args ){
    MDI10 frame = new MDI10( "MDI 10" );
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
    frame.setSize( 650, 500 );
    frame.setVisible(true);
  }

  MDI10( String title ){
     super( title );
     desktop = new JDesktopPane();
     Container pane = getContentPane();
     pane.add( desktop, BorderLayout.CENTER );
     setupInternalFrames( );
     desktop.addMouseListener( new MouseCheck() );
  }

  void setupInternalFrames( ){
     frame1 = new JInternalFrame( "frame 1", true, true, true, true );
     frame1.setBounds( 110, 10, 300, 200 );
     frame1.setVisible( true );
     desktop.add( frame1, new Integer(1) ); // レイヤー1

     frame2 = new JInternalFrame( "frame 2" , true, true, true, true );
     frame2.setBounds( 140, 40, 300, 200 );
     frame2.setVisible( true );
     desktop.add( frame2, new Integer(1) ); // レイヤー1

     frame3 = new JInternalFrame( "frame 3" , true, true, true, true );
     frame3.setBounds( 170, 70, 300, 200 );
     frame3.setVisible( true );
     desktop.add( frame3, new Integer(1) ); // レイヤー1

     frame4 = new JInternalFrame( "frame 4" , true, true, true, true );
     frame4.setBounds( 220, 120, 300, 200 );
     frame4.setVisible( true );
     desktop.add( frame4, new Integer(2) ); // レイヤー2

     frame5 = new JInternalFrame( "frame 5" , true, true, true, true );
     frame5.setBounds( 270, 170, 300, 200 );
     frame5.setVisible( true );
     desktop.add( frame5, new Integer(2) ); // レイヤー2

     frame6 = new JInternalFrame( "frame 6" , true, true, true, true );
     frame6.setBounds( 320, 220, 300, 200 );
     frame6.setVisible( true );
     desktop.add( frame6, new Integer(3) ); // レイヤー3
  }
}