package vol1.ch02;
import javax.swing.*;

public class MenuTest01B extends JFrame {

  public static void main(String[] args) {
    MenuTest01B w = new MenuTest01B( "MenuTest01B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 250 );
    w.setVisible( true );
  }
  public MenuTest01B(String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu file = new JMenu( "File" );
    menuBar.add( file );

    JMenuItem item;    
    item = new JMenuItem( "Open" );
    file.add( item );
    item = new JMenuItem( "Save" );
    file.add( item );
    file.addSeparator();
    item = new JMenuItem( "Exit" );
    file.add( item );
  }
}
