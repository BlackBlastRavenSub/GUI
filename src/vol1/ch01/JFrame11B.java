package vol1.ch01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrame11B extends JFrame {
  JPanel contentPane;
  public static void main(String[] args) {
    new JFrame11B( "JFrame11B" );
  }
  public JFrame11B( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setContentPane( new MyContentPane() );
    setSize( 350, 200 );
    setVisible(true);
  }
  class MyContentPane extends JPanel{
    MyContentPane(){
      setLayout( null );
      JLabel label = new JLabel( "自分で作ったパネルを ContentPane にしてみました" );
      label.setBounds( 0, 0, 300, 28 );
      JButton b1 = new JButton( "ボタン１" );
      b1.setBounds( 0, 30, 100, 28 );
      JButton b2 = new JButton( "ボタン２" );
      b2.setBounds( 0, 60, 100, 28 );
      add( label );
      add( b1 );
      add( b2 );
    }
  }
}
