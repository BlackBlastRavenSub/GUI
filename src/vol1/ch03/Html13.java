package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Html13 extends JFrame {
  JLabel  style = new JLabel();

  public static void main(String[] args) {
    Html13 frame = new Html13( "Html13" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 250, 300 );
    frame.setVisible( true );
  }
  Html13( String title ){
    super( title );
    Container pane = getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    String[] styles = new String[5];
    styles[0] = "通常";
    styles[1] = "<html><img src=file:./image/italic.gif><i>斜体</i>";
    styles[2] = "<html><img src=file:./image/bold.gif><b>太字</b>";
    styles[3] = "<html><img src=file:./image/under.gif><u>アンダーライン</u>";
    styles[4] = "<html><img src=file:./image/strike.gif><s>抹消線</s>";
    JList list = new JList( styles );
    list.setBorder( new TitledBorder( "文字のスタイル" ) );
    list.addListSelectionListener( new CheckStyle() );
    JScrollPane scroll = new JScrollPane( list );
    pane.add( scroll );
    pane.add( style );

  }
  class CheckStyle implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){
      JList list = (JList)e.getSource();
      String text = list.getSelectedValue() + " ]が選ばれました";
      style.setText( text );
    }
  } 
}
