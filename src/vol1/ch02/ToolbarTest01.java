package vol1.ch02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolbarTest01 extends JFrame {

  public static void main(String[] args) {
    ToolbarTest01 w = new ToolbarTest01( "ToolbarTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public ToolbarTest01( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    JToolBar toolbar = new JToolBar();
    pane.add( toolbar, BorderLayout.NORTH );

    JButton item;    

    item = new JButton( "Open", new ImageIcon( "open.gif" ) );
    toolbar.add( item );

    item = new JButton( "Save", new ImageIcon( "save.gif" ) );
    item.setHorizontalTextPosition( JMenuItem.LEFT ); //***
    toolbar.add( item );

    toolbar.addSeparator();

    item = new JButton( "exit", new ImageIcon( "exit.gif" ) );
    toolbar.add( item );

  }
}
