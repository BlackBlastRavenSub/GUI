package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class Html01 extends JFrame {
  public static void main(String[] args) {
    Html01 frame = new Html01( "Html01" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 420, 200 );
    frame.setVisible( true );
  }
  Html01( String title ){
    super( title );
    Container pane = getContentPane();
   
    String htmlText1 = 
      "<html>" +
      "ラベルなのに<bbr>複数行文字列を扱えます。" +
      "<p> ｐタグでも改行できますが、ｐタグには別の意味があります。";
      
    JLabel htmlLabel = new JLabel( htmlText1 );
    htmlLabel.setBorder( new LineBorder( Color.blue, 2 ) );
    pane.add( htmlLabel, BorderLayout.NORTH );

    String htmlText2 = 
      "<html>" +
      "ボタンボタンなのに<br>複数行文字列を扱えます。" +
      "<p> ｐタグでも改行できますが、ｐタグには別の意味があります。";
      
    JButton htmlButton = new JButton( htmlText2 );
    pane.add( htmlButton, BorderLayout.CENTER );

    String htmlText3 = 
      "<html>" +
      "ラジオボタンなのに<br>複数行文字列を扱えます。" +
      "<p> ｐタグでも改行できますが、ｐタグには別の意味があります。";
      
    JRadioButton htmlRadioButton = new JRadioButton( htmlText3 );
    pane.add( htmlRadioButton, BorderLayout.SOUTH );

  }
}
