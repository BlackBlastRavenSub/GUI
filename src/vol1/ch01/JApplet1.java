package vol1.ch01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JApplet1 extends JApplet {
  Container contentPane;

  public void init(){
    contentPane = getContentPane();

    JToolBar toolBar = new JToolBar();
    contentPane.add( toolBar, BorderLayout.NORTH );
    toolBar.add( new Red() );
    toolBar.add( new Blue() );

    // JApplet ではメニューも使える。
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar ); // メニューバーは直接 JApplet に add 出来る。
    JMenu menu = new JMenu( "color" );
    menuBar.add( menu );
    menu.add( new Red() );
    menu.add( new Blue() );

  }
  class Red extends AbstractAction {
    Red(){ super( "red" ); } // 表示ラベルの設定
    public void actionPerformed( ActionEvent e ){
      contentPane.setBackground( Color.red );
    }
  }
  class Blue extends AbstractAction {
    Blue(){ super( "blue" ); } // 表示ラベルの設定
    public void actionPerformed( ActionEvent e ){
      contentPane.setBackground( Color.blue );
    }
  }
}    
