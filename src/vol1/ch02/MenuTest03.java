package vol1.ch02;
import javax.swing.*;
import java.awt.*;

public class MenuTest03 extends JFrame {

  public static void main(String[] args) {
    MenuTest03 w = new MenuTest03( "MenuTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 200 );
    w.setVisible( true );
  }
  public MenuTest03( String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu file = new JMenu( "File" );
    menuBar.add( file );

    Icon icon;
    JMenuItem item;    

    item = new JMenuItem( new ImageIcon( "open.gif" ) );
    item.setToolTipText( "開く" ); //**
    file.add( item );

    item = new JMenuItem( new ImageIcon( "save.gif" ) );
    item.setToolTipText( "保存" ); //**
    file.add( item );

    file.addSeparator();

    item = new JMenuItem( new ImageIcon( "exit.gif" ) );
    item.setToolTipText( "終了" ); //**
    file.add( item );
  }
}
