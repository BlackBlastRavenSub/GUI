package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html04 extends JFrame {
  public static void main(String[] args) {
    Html04 frame = new Html04( "Html04" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 320, 600 );
    frame.setVisible( true );
  }
  Html04( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html><body bgcolor=yellow> "+
      "<br>ラベルなのに、<br>" +
      "画像<img src=file:./image/open.gif>を" +
      "好きな場所<img src=file:./image/new.gif>に入れたり、" +
      "<br>" +
      "画像の大きさ<img src=file:./image/open.gif width=50 height=50>を変更できます。" +
      "<br><br>画像と文字の位置関係も多彩に指定できます。" +
      "<br>" +
      "<img src=file:./image/monalisa.gif align=top>top" +
      "<br><br>" +
      "<img src=file:./image/monalisa.gif align=middle>middle" +
      "<br><br>" +
      "<img src=file:./image/monalisa.gif align=bottom>bottom" +
      "<br><br>" +
      "<img src=file:./image/monalisa.gif border=8>画像に枠を付けられる" ;

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.NORTH );

  }
}
