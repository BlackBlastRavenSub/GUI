package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html03B extends JFrame {
  public static void main(String[] args) {
    Html03B frame = new Html03B( "Html03B" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 240, 160 );
    frame.setVisible( true );
  }
  Html03B( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<body style=background-color:yellow;color:red>" +
      "全体の背景色は黄色　前景色は赤<br>" +
      "<p style=background-color:white;color:blue>" +
      "この段落の背景色は白<br>前景色は青</p>" +
      "<br>再び 背景色は黄色　前景色は赤";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.NORTH );

  }
}
