package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html05 extends JFrame {
  public static void main(String[] args) {
    Html05 frame = new Html05( "Html05" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 400, 450 );
    frame.setVisible( true );
  }
  Html05( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html><body bgcolor=yellow>" +
      "<p>ラベルなのにテーブルが使える<p>しかも各セルの内容の右詰めを指定した" +
      "<table border align=right>" +
      "<tr><th>第１カラム</th><th>第２カラム</th></tr>" +
      "<tr><td bgcolor=red>セルの背景は赤</td><td bgcolor=green>セルの背景は緑</td></tr>" +
      "<tr><td><img src=file:./image/open.gif\">画像付きセル<img src=file:./image/exit.gif></td>" +
      "<td>ローの高さは自動設定<されます</td></tr>" +
      "<tr><td align=left>左寄せ</td><td align=center>センタリング</td></tr>" +
      "<tr><td>セル内で<p>複数行も<p>表示できます</td><td valign=top>上寄せ</td></tr>" +
      "<tr><td>aaa<p>bbbbbb<p>ccccccccc</td><td>デフォルト</td></tr>" +
      "<tr><td>1<p>2<p>3</td><td valign=bottom>下寄せ</td></tr>" +
      "</table></body>";

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.CENTER );
  }
}
