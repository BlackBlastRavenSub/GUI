package vol1.ch02;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ImageLabel03B extends JFrame {

  public static void main(String[] args) {
    ImageLabel03B w = new ImageLabel03B( "ImageLabel03B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 280 );
    w.setVisible( true );
  }
  public ImageLabel03B( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    panel.setLayout( new GridLayout( 3, 3 ) );

    JLabel item;    
    Icon icon = new ImageIcon( "exit.gif" );

    item = new JLabel( "Text 左" ); // テキストが左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 中央" ); // テキストが中央
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 右" ); // テキストが右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 上左" ); // テキストが上左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    item.setVerticalTextPosition( SwingConstants.TOP );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 真上" ); // テキストが真上
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    item.setVerticalTextPosition( SwingConstants.TOP );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 上右" ); // テキストが上右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    item.setVerticalTextPosition( SwingConstants.TOP );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 下左" ); // テキストが下左
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.LEFT );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 真下" ); // テキストが真下
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.CENTER );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "Text 下右" ); // テキストが下右
    item.setIcon( icon );
    item.setHorizontalTextPosition( SwingConstants.RIGHT );
    item.setVerticalTextPosition( SwingConstants.BOTTOM );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

  }
}
