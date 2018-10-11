package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html03 extends JFrame {
  public static void main(String[] args) {
    Html03 frame = new Html03( "Html03" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 350, 200 );
    frame.setVisible( true );
  }
  Html03( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<br>文字の色を<font color=red>赤に変えたり<font color=blue>青に変えたり<br>" +
      "<br><font color=#66ccff>中間色の<font color=#993399>指定も<font color=#cc9966>出来ます<br>";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.NORTH );

  }
}
