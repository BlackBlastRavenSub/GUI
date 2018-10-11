package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;

class Html17 extends JFrame {

  public static void main(String[] args) {
    Html17 frame = new Html17( "Html17" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
  Html17( String title ){
    super( title );
    Container pane = getContentPane();

    String[] header = new String[7];
    header[0] = "<html><font color=red><b>日曜日<br>Sunday</b></font>";
    header[1] = "<html>月曜日<br>Monday";
    header[2] = "<html>火曜日<br>Tuesday";
    header[3] = "<html>水曜日<br>Wednesday";
    header[4] = "<html>木曜日<br>Thursday";
    header[5] = "<html>金曜日<br>Friday";
    header[6] = "<html><font color=blue><i>土曜日<br>Saturday</i></font>";
    
    DefaultTableModel model = new DefaultTableModel( header, 6 );
    JTable table = new JTable( model );
    JScrollPane scroll = new JScrollPane( table ); // JScrollPane の中に入れなければ、カラムヘッダが表示されない
    pane.add( scroll );
  }
}

