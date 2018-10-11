package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html05A extends JFrame {
  public static void main(String[] args) {
    Html05A frame = new Html05A( "Html05A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 260, 320 );
    frame.setVisible( true );
  }
  Html05A( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html><body bgcolor=yellow>" +
      "<p>セルのマージ（縦）" +
      "<table border>" +
      "<tr><th rowspan=3>題名</th><th>小分類</th><td>AAAA</td><td rowspan=3>備考</td></tr>" +
      "<tr><th rowspan=2>小分類</th><td>BBBBBBB</td></tr>" +
      "<tr><td>CCCC</td>" +
      "</table>" +
      "<p>セルのマージ（横）" +
      "<table border align=center>" +
      "<tr><th colspan=4>題名</th></tr>" +
      "<tr><th colspan=2>小分類</th><th colspan=2>小分類</th></tr>" +
      "<tr><td>AAAA</td><td>BBBBBB</td><td>CCCCCCCCC</td><td>DDDD</td></tr>" +
      "<tr><td colspan=4>備考</td></tr>" +
      "</table>" +
      "</body>";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.CENTER );

  }
}
