package vol1.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Html11 extends JFrame {
  JButton bt = new JButton( "<html>これは<p>ボタンです" );
  JPopupMenu pmenu = new JPopupMenu();

  public static void main(String[] args) {
    Html11 frame = new Html11( "Html1" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 350, 350 );
    frame.setVisible( true );
  }
  Html11( String title ){
    super( title );
    Container pane = getContentPane();
   
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );
    JMenu menu = new JMenu( "<html>２行になった<p>メニューバーです" );
    menuBar.add( menu );

    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );

    pane.addMouseListener( new CheckPopup() );

    Action item1 = new CheckAction( 
                  "<html>ファイルを<p><img src=file:./image/new.gif<p>新規作成します" );
    Action item2 = new CheckAction(
                  "<html>ファイルを<p><img src=file:./image/open.gif<p>開きます" );
    Action item3 = new CheckAction(
                  "<html>ファイルを<p><img src=file:./image/save.gif<p>保管します" );

    menu.add( item1 );
    menu.addSeparator();
    pmenu.add( item1 );
    pmenu.addSeparator();
    tool.add( item1 );
    tool.addSeparator();

    menu.add( item2 );
    menu.addSeparator();
    pmenu.add( item2 );
    pmenu.addSeparator();
    tool.add( item2 );
    tool.addSeparator();

    menu.add( item3 );
    pmenu.add( item3 );
    tool.add( item3 );

    pane.add( bt,BorderLayout.SOUTH );
  }
  class CheckAction extends AbstractAction{
    CheckAction( String text ){ super(text); }
    public void actionPerformed( ActionEvent e ){
      AbstractButton b = (AbstractButton)e.getSource();
      String text = b.getText() + " ]が選ばれました。";
      bt.setText( text );
    }
  }
  class CheckPopup extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      if( SwingUtilities.isRightMouseButton( e ) ){
        pmenu.show( e.getComponent(), e.getX(), e.getY() );
      }
    }
  }
}

