package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;

class Html16 extends JFrame {
  JLabel month = new JLabel();

  public static void main(String[] args) {
    Html16 frame = new Html16( "Html16" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
  Html16( String title ){
    super( title );
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
    JTabbedPane tab = new JTabbedPane();
    for( int i=0 ; i<12 ; i++ ){
      tab.addTab( months[i], new JPanel() ); //各タブには対応するコンポーネントをセットする必要がある
    }
    tab.addChangeListener( new CheckMonth() );
    pane.add( month );
    pane.add( tab );
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
}

