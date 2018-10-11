package vol1.ch02;
import javax.swing.*;
import java.awt.*;

public class MenuTest02 extends JFrame {

  public static void main(String[] args) {
    MenuTest02 w = new MenuTest02( "MenuTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MenuTest02( String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu file = new JMenu( "File" );
    menuBar.add( file );

    JMenuItem item;    

    item = new JMenuItem( "Open", new ImageIcon( "open.gif" ) );
    file.add( item );

    item = new JMenuItem( "Save", new ImageIcon( "save.gif" ) );
    item.setHorizontalTextPosition( JMenuItem.LEFT ); //***
    file.add( item );

    file.addSeparator();

    item = new JMenuItem( "exit", new ImageIcon( "exit.gif" ) );
    file.add( item );
  }
}
