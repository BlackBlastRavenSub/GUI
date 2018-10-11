package vol1.ch02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuTest05 extends JFrame {

  JPopupMenu popup;

  public static void main(String[] args) {
    MenuTest05 w = new MenuTest05( "MenuTest05" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 200 );
    w.setVisible( true );
  }
  public MenuTest05( String title ){
    super( title );

    popup = new JPopupMenu();
    JMenuItem item;
    
    item = new JMenuItem( "Open", new ImageIcon( "open.gif" ) );
    popup.add( item );
    item = new JMenuItem( "Save", new ImageIcon( "save.gif" ) );
    popup.add( item );
    popup.addSeparator();
    item = new JMenuItem( "Exit", new ImageIcon( "exit.gif" ) );
    popup.add( item );

    enableEvents( AWTEvent.MOUSE_EVENT_MASK );
  }

  protected void processMouseEvent( MouseEvent e ){
    //System.out.println( e );
    if( e.isPopupTrigger() ){
      popup.show( e.getComponent(), e.getX(), e.getY() );
    }
    super.processMouseEvent( e );
  }
}
