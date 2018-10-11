package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html06 extends JFrame {
  public static void main(String[] args) {
    Html06 frame = new Html06( "Html06" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 300, 250 );
    frame.setVisible( true );
  }
  Html06( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html><body style=\"background-color:yellow\">スタイルタグで全体の背景色を黄色に指定" +
      "<p style=color:red;font-style:italic;font-weight:bolder;font-size:20pt;" +
      "スタイル指定も使える。<br>赤で斜体太字 ２０ポイント</p>" +
      "<p style=color:blue;background-color:green;>" +
      "もう一つのパラグラフを追加。<br>" +
      "ここはノーマルのフォントで青く表示  背景は緑</p>" +
      "<p style=text-align:center;>" +
      "センタリングもできる</p>" +
      "</body>" ;

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.CENTER );

  }
}
