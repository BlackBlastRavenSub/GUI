package vol1.ch02;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;

public class MenuTest04 extends JFrame {

  ButtonGroup bg1;

  public static void main(String[] args) {
    MenuTest04 w = new MenuTest04( "MenuTest04" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 180 );
    w.setVisible( true );
  }
  public MenuTest04( String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu1 = new JMenu( "メニュー1" );
    menuBar.add( menu1 );
    JMenu menu2 = new JMenu( "メニュー2" );
    menuBar.add( menu2 );

    JMenuItem item;  

    bg1 = new ButtonGroup();  
    item = new JRadioButtonMenuItem( "和食" );
    menu1.add( item );
    bg1.add( item );
    item = new JRadioButtonMenuItem( "中華" );
    menu1.add( item );
    bg1.add( item );
    item = new JRadioButtonMenuItem( "洋食" );
    menu1.add( item );
    bg1.add( item );

    item = new JCheckBoxMenuItem( "和食" );
    menu2.add( item );
    item = new JCheckBoxMenuItem( "中華" );
    menu2.add( item );
    item = new JCheckBoxMenuItem( "洋食" );
    menu2.add( item );

    JButton btn = new JButton("クリア");
    btn.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent event ) {
        bg1.clearSelection();
      }
    });
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new FlowLayout() );
    pane.add(btn);
  }
}
