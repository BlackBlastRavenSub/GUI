package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html03A extends JFrame {
  public static void main(String[] args) {
    Html03A frame = new Html03A( "Html03A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 240, 160 );
    frame.setVisible( true );
  }
  Html03A( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<body bgcolor=yellow color=red>" +
      "全体の背景色は黄色　前景色は赤<br>" +
      "<p bgcolor=white color=blue>" +
      "この段落の背景色は白<br>前景色は青</p>" +
      "<br>再び 背景色は黄色　前景色は赤";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.NORTH );

  }
}
