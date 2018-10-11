package vol1.ch03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Html10A extends JFrame {
  JButton btt = new JButton( "<html>これは<p>ボタンです" );

  public static void main(String[] args) {
    Html10A frame = new Html10A( "Html10A" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 350, 350 );
    frame.setVisible( true );
  }
  Html10A( String title ){
    super( title );
    Container pane = getContentPane();
   
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu1 = new JMenu( "<html>チェックボックス<p>メニューアイテム" );
    menuBar.add( menu1 );
    JMenu menu2 = new JMenu( "<html>ラジオボタン<p>メニューアイテム" );
    menuBar.add( menu2 );

    String str11 = "<html>２行になった<p>チェックボックスメニューアイテム１";
    String str12 = "<html>２行になった<p>チェックボックスメニューアイテム２";
    String str13 = "<html>２行になった<p>チェックボックスメニューアイテム３";

    JMenuItem item11 = new JCheckBoxMenuItem( str11 );
    item11.addActionListener( new CheckAction() );
    menu1.add( item11 );
    menu1.addSeparator();

    JMenuItem item12 = new JCheckBoxMenuItem( str12 );
    item12.addActionListener( new CheckAction() );
    menu1.add( item12 );
    menu1.addSeparator();

    JMenuItem item13 = new JCheckBoxMenuItem( str13 );
    item13.addActionListener( new CheckAction() );
    menu1.add( item13 );

    String str21 = "<html>２行になった<p>ラジオボタンメニューアイテム１";
    String str22 = "<html>２行になった<p>ラジオボタンメニューアイテム２";
    String str23 = "<html>２行になった<p>ラジオボタンメニューアイテム３";
    ButtonGroup bg = new ButtonGroup();

    JMenuItem item21 = new JRadioButtonMenuItem( str21 );
    item21.addActionListener( new CheckAction() );
    menu2.add( item21 );
    bg.add( item21 );
    menu2.addSeparator();

    JMenuItem item22 = new JRadioButtonMenuItem( str22 );
    item22.addActionListener( new CheckAction() );
    menu2.add( item22 );
    bg.add( item22 );
    menu2.addSeparator();

    JMenuItem item23 = new JRadioButtonMenuItem( str23 );
    item23.addActionListener( new CheckAction() );
    bg.add( item22 );
    menu2.add( item23 );

    pane.add( btt, BorderLayout.SOUTH );
  }
  class CheckAction extends AbstractAction{
    public void actionPerformed( ActionEvent e ){
      AbstractButton b = (AbstractButton)e.getSource();
      String text;
      if( b.isSelected() ){
        text = b.getText() + " ]が On になりました。";
      }else{
        text = b.getText() + " ]が Off になりました。";
      }
      btt.setText( text );
    }
  } 
}

