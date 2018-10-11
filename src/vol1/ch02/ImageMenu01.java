package vol1.ch02;
import javax.swing.*;
import java.awt.*;

public class ImageMenu01 extends JFrame {

  public static void main(String[] args) {
    ImageMenu01 w = new ImageMenu01( "ImageMenu01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 540 );
    w.setVisible( true );
  }
  public ImageMenu01( String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu = new JMenu("test");
    menuBar.add( menu );

    JMenuItem item;    
    Icon icon = new ImageIcon( "exit.gif" );

    item = new JMenuItem( "Text 左" ); // テキストが左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 中央" ); // テキストが中央
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 右" ); // テキストが右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 上左" ); // テキストが上左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    item.setVerticalTextPosition( SwingConstants.TOP );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 真上" ); // テキストが真上
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    item.setVerticalTextPosition( SwingConstants.TOP );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 上右" ); // テキストが上右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    item.setVerticalTextPosition( SwingConstants.TOP );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 下左" ); // テキストが下左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 真下" ); // テキストが真下
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    menu.add( item );
    menu.addSeparator();

    item = new JMenuItem( "Text 下右" ); // テキストが下右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    menu.add( item );

  }
}
