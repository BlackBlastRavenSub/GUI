package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html02 extends JFrame {
  public static void main(String[] args) {
    Html02 frame = new Html02( "Html02" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 350, 300 );
    frame.setVisible( true );
  }
  Html02( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<br><font size=6>フォントサイズを</font><font size=2>変えたり</font>" +
      "<br><br>" +
      "<i>斜体</i>や<u>下線付き</u>や<b>太字</b>や<s>抹消線付き</s>にしたり" +
      "<br>" +
      "<p align=center>センタリング</p>" +
      "<p align=right>右寄せもＯＫ</p>" +
      "<br><br>" +
      "標準に対して<sup>上付き</sup><sub>下付き</sub>もできます。" ;
     
    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.NORTH );

  }
}
