package vol1.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Html12 extends JFrame {
  JButton bt = new JButton( "<html>これは<p>ボタンです" );
  JPopupMenu pmenu = new JPopupMenu();

  public static void main(String[] args) {
    Html12 frame = new Html12( "Html2" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 350, 350 );
    frame.setVisible( true );
  }
  Html12( String title ){
    super( title );
    Container pane = getContentPane();
   
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );
    JMenu menu = new JMenu( "<html>２行になった<p>メニューバーです" );
    menuBar.add( menu );

    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );

    pane.addMouseListener( new CheckPopup() );

    Action item1 = new CheckAction( "New" );
    String str1 = "<html>ファイルを<p><img src=file:./image/new.gif<p>新規作成します";
    Action item2 = new CheckAction( "Open" );
    String str2 = "<html>ファイルを<p><img src=file:./image/open.gif<p>開きます";
    Action item3 = new CheckAction( "Save" );
    String str3 = "<html>ファイルを<p><img src=file:./image/save.gif<p>保管します";

    menu.add( item1 ).setToolTipText( str1 );
    menu.addSeparator();
    pmenu.add( item1 ).setToolTipText( str1 );
    pmenu.addSeparator();
    tool.add( item1 ).setToolTipText( str1 );
    tool.addSeparator();

    menu.add( item2 ).setToolTipText( str2 );
    menu.addSeparator();
    pmenu.add( item2 ).setToolTipText( str2 );
    pmenu.addSeparator();
    tool.add( item2 ).setToolTipText( str2 );
    tool.addSeparator();

    menu.add( item3 ).setToolTipText( str3 );
    pmenu.add( item3 ).setToolTipText( str3 );
    tool.add( item3 ).setToolTipText( str3 );

    pane.add( bt,BorderLayout.SOUTH );
  }
  class CheckAction extends AbstractAction{
    CheckAction( String text ){ super(text); }
    public void actionPerformed( ActionEvent e ){
      AbstractButton b = (AbstractButton)e.getSource();
      String text = b.getToolTipText() + " ]が選ばれました。";
      bt.setText( text );
    }
  } 
  class CheckPopup extends MouseAdapter {
    public void mousePressed( MouseEvent e ){
      if( SwingUtilities.isLeftMouseButton( e ) ){
        pmenu.show( e.getComponent(), e.getX(), e.getY() );
      }
    }
  }
}

