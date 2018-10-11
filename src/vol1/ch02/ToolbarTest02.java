package vol1.ch02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolbarTest02 extends JFrame {

  public static void main(String[] args) {
    ToolbarTest02 w = new ToolbarTest02( "ToolbarTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public ToolbarTest02( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    JMenuBar mb = new JMenuBar();
    setJMenuBar( mb );

    JMenu file = new JMenu( "File" );
    JToolBar toolbar = new JToolBar();

    mb.add( file );
    mb.add( toolbar );

    AbstractButton item;    

    item = new JButton( "Open", new ImageIcon( "open.gif" ) );
    file.add( item );
    item = new JMenuItem( "Open", new ImageIcon( "open.gif" ) );
    toolbar.add( item );

    item = new JButton( "Save", new ImageIcon( "save.gif" ) );
    file.add( item );
    item = new JMenuItem( "Save", new ImageIcon( "save.gif" ) );
    toolbar.add( item );

    file.addSeparator();
    toolbar.addSeparator();

    item = new JButton( "Exit", new ImageIcon( "exit.gif" ) );
    file.add( item );
    item = new JMenuItem( "Exit", new ImageIcon( "exit.gif" ) );
    toolbar.add( item );
  }
}
