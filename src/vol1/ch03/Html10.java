package vol1.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Html10 extends JFrame {
  JButton bt = new JButton( "<html>これは<p>ボタンです" );

  public static void main(String[] args) {
    Html10 frame = new Html10( "Html10" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 350, 350 );
    frame.setVisible( true );
  }
  Html10( String title ){
    super( title );
    Container pane = getContentPane();
   
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );
    JMenu menu = new JMenu( "<html>２行になった<p>メニューバーです" );
    menuBar.add( menu );

    String str1 = "<html>ファイルを<p><img src=file:./image/new.gif<p>新規作成します";
    String str2 = "<html>ファイルを<p><img src=file:./image/open.gif<p>開きます";
    String str3 = "<html>ファイルを<p><img src=file:./image/save.gif<p>保管します";

    JMenuItem item1 = new JMenuItem( str1 );
    item1.addActionListener( new CheckAction() );
    menu.add( item1 );
    menu.addSeparator();

    JMenuItem item2 = new JMenuItem( str2 );
    item2.addActionListener( new CheckAction() );
    menu.add( item2 );
    menu.addSeparator();

    JMenuItem item3 = new JMenuItem( str3 );
    item3.addActionListener( new CheckAction() );
    menu.add( item3 );

    pane.add( bt, BorderLayout.SOUTH );
  }
  class CheckAction extends AbstractAction{
    public void actionPerformed( ActionEvent e ){
      AbstractButton b = (AbstractButton)e.getSource();
      String text = b.getText() + " ]が選ばれました。";
      bt.setText( text );
    }
  } 
}

