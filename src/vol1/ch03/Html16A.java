package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Html16A extends JFrame {
  JTabbedPane tab = new JTabbedPane();
  JLabel month = new JLabel();

  public static void main(String[] args) {
    Html16A frame = new Html16A( "Html16A" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 540, 500 );
    frame.setVisible( true );
  }
  Html16A( String title ){
    super( title );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu menu = new JMenu( "タブ位置" );
    menuBar.add( menu );

    String str1 = "上タブ";
    String str2 = "下タブ";
    String str3 = "左タブ";
    String str4 = "右タブ";
    ButtonGroup bg = new ButtonGroup();
    JMenuItem item1 = new JRadioButtonMenuItem( str1 );
    item1.addActionListener( new TopTab() );
    menu.add( item1 );
    bg.add( item1 );
    item1.setSelected(true);

    JMenuItem item2 = new JRadioButtonMenuItem( str2 );
    item2.addActionListener( new BottomTab() );
    menu.add( item2 );
    bg.add( item2 );

    JMenuItem item3 = new JRadioButtonMenuItem( str3 );
    item3.addActionListener( new LeftTab() );
    menu.add( item3 );
    bg.add( item3 );

    JMenuItem item4 = new JRadioButtonMenuItem( str4 );
    item4.addActionListener( new RightTab() );
    menu.add( item4 );
    bg.add( item4 );
    
    Container pane = getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    String[] months = new String[12];
    months[0] = "<html>１月<br>睦月";
    months[1] = "<html>２月<br>如月";
    months[2] = "<html>３月<br>弥生";
    months[3] = "<html>４月<br>卯月";
    months[4] = "<html>５月<br>皐月";
    months[5] = "<html>６月<br>水無月";
    months[6] = "<html>７月<br>文月";
    months[7] = "<html>８月<br>葉月";
    months[8] = "<html>９月<br>長月";
    months[9] = "<html>１０月<br>神無月";
    months[10] = "<html>１１月<br>霜月";
    months[11] = "<html>１２月<br>師走";
    for( int i=0 ; i<12 ; i++ ){
      tab.addTab( months[i], new JPanel() ); //各タブには対応するコンポーネントをセットする必要がある
    }
    tab.addChangeListener( new CheckMonth() );
    JScrollPane scroll = new JScrollPane( tab );
    pane.add( month, BorderLayout.NORTH );
    pane.add( scroll, BorderLayout.CENTER );
  }
  class CheckMonth implements ChangeListener {
    public void stateChanged( ChangeEvent e ){
      JTabbedPane tab = (JTabbedPane)e.getSource();
      int index = tab.getSelectedIndex();
      String text = tab.getTitleAt( index );
      text += " ]が選ばれました。";
      month.setText( text );
    }
  }
  class TopTab implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      tab.setTabPlacement( SwingConstants.TOP ); //タブを上端にする
    }
  }
  class BottomTab implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      tab.setTabPlacement( SwingConstants.BOTTOM ); //タブを下端にする
    }
  }
  class LeftTab implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      tab.setTabPlacement( SwingConstants.LEFT ); //タブを左端にする
    }
  }
  class RightTab implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      tab.setTabPlacement( SwingConstants.RIGHT ); //タブを右端にする
    }
  }
}

