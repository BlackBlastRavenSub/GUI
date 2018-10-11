package vol1.ch03;
import javax.swing.*;
import java.awt.*;

class Html06A extends JFrame {
  public static void main(String[] args) {
    Html06A frame = new Html06A( "Html06A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 300, 200 );
    frame.setVisible( true );
  }
  Html06A( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "<head><style> #html06 { text-decoration: underline } </style></head>" +
      "<body style=background-color:yellow>スタイルタグで全体の背景色を黄色に指定<br>" +
      "<P id=html06>ID Html06 が指定されたので<br>この段落内では改行しても下線付きで表示</P>" ;

    JLabel htmlComponent = new JLabel( htmlText1 );
    pane.add( htmlComponent, BorderLayout.CENTER );

  }
}
