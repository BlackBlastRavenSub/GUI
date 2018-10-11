package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Html14 extends JFrame {
  JLabel  size = new JLabel();  

  public static void main(String[] args) {
    Html14 frame = new Html14( "Html14" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 350, 400 );
    frame.setVisible( true );
  }
  Html14( String title ){
    super( title );
    Container pane = getContentPane();

    String[] sizes = new String[8]; 
    sizes[0] = "通常";
    sizes[1] = "<html><font size=1>サイズ１</font>";
    sizes[2] = "<html><font size=2>サイズ２</font>";
    sizes[3] = "<html><font size=3>サイズ３</font>";
    sizes[4] = "<html><font size=4>サイズ４</font>";
    sizes[5] = "<html><font size=5>サイズ５</font>";
    sizes[6] = "<html><font size=6>サイズ６</font>";
    sizes[7] = "<html><font size=7>サイズ７</font>";
    JComboBox comb = new JComboBox( sizes );
    comb.setBorder( new TitledBorder( "文字のサイズ" ) );
    comb.addItemListener( new CheckSize() );
    pane.add( comb, BorderLayout.NORTH );
    pane.add( size, BorderLayout.SOUTH );
  }
  class CheckSize implements ItemListener {
    public void itemStateChanged( ItemEvent e ){
      String text = e.getItem() + " ]が選ばれました。";
      size.setText( text );
    }
  } 
}
