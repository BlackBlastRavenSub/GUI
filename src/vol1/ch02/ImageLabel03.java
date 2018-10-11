package vol1.ch02;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ImageLabel03 extends JFrame {

  public static void main(String[] args) {
    ImageLabel03 w = new ImageLabel03( "ImageLabel03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 420 );
    w.setVisible( true );
  }
  public ImageLabel03( String title ){
    super( title );
    JPanel panel = (JPanel)getContentPane();
    panel.setLayout( new FlowLayout() );

    JLabel item;
    Icon icon = new ImageIcon( "exit.gif" );

    item = new JLabel( "デフォルト" );
    item.setIcon( icon );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "左寄せ", icon, SwingConstants.LEFT );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "中央", icon, SwingConstants.CENTER );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "右寄せ", icon, SwingConstants.RIGHT );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "LEADING", icon, SwingConstants.LEADING );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "TRAILING", icon, SwingConstants.TRAILING );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

    item = new JLabel( "左寄せ" );
    item.setIcon( icon );
    item.setHorizontalAlignment( SwingConstants.LEFT );
    item.setPreferredSize( new Dimension(350, 50) );
    item.setBorder( new LineBorder( Color.black) );
    panel.add( item );

  }
}
