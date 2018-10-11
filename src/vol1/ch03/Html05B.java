package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html05B extends JFrame {
  public static void main(String[] args) {
    Html05B frame = new Html05B( "Html05B" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 450, 200 );
    frame.setVisible( true );
  }
  Html05B( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<table border width=400 height=200>" +
      "<tr><th>col A</th><th>col B</th></tr>" +
      "<tr>" +
      "<td background=file:./image/open.gif>111111<p>22222</td>" +
      "<td background=file:./image/tree.jpg>aaaaaaa<p>bbbbbbb</td>" +
      "</tr>" +
      "</table>";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.CENTER );
  }
}
