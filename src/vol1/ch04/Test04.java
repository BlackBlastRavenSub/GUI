package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test04 extends JFrame {

  public static void main(String[] args) {
    Test04 w = new Test04( "Test04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public Test04( String title ){
    super( title );

    JPanel pane = (JPanel)getContentPane();

    JToolBar toolbar = new JToolBar();
    pane.add( toolbar, BorderLayout.NORTH );

    JButton buttonOpen = new JButton( new ImageIcon( "open.gif" ) );
    toolbar.add( buttonOpen );
    buttonOpen.addActionListener( new OpenListener() );
    buttonOpen.setToolTipText( "開く" );

    JButton buttonSave = new JButton( new ImageIcon( "save.gif" ) );
    toolbar.add( buttonSave );
    buttonSave.addActionListener( new SaveListener() );
    buttonSave.setToolTipText( "保存" );

    toolbar.addSeparator();

    JButton buttonExit = new JButton( new ImageIcon( "exit.gif" ) );
    toolbar.add( buttonExit );
    buttonExit.addActionListener( new ExitListener() );
    buttonExit.setToolTipText( "終了" );


    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu = new JMenu( "ファイル" );
    menuBar.add( menu );

    JMenuItem menuOpen = new JMenuItem( new ImageIcon( "open.gif" ) );
    menu.add( menuOpen );
    menuOpen.addActionListener( new OpenListener() );
    menuOpen.setText( "開く" );
    menuOpen.setToolTipText( "開く" );

    JMenuItem menuSave = new JMenuItem( new ImageIcon( "save.gif" ) );
    menu.add( menuSave );
    menuSave.addActionListener( new SaveListener() );
    menuSave.setText( "保存" );
    menuSave.setToolTipText( "保存" );

    menu.addSeparator();

    JMenuItem menuExit = new JMenuItem( new ImageIcon( "exit.gif" ) );
    menu.add( menuExit );
    menuExit.addActionListener( new ExitListener() );
    menuExit.setText( "終了" );
    menuExit.setToolTipText( "終了" );

  }

  class OpenListener implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Open" );
    }
  }

  class SaveListener implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Save" );
    }
  }

  class ExitListener implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Exit" );
    }
  }

}
