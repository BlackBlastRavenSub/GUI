package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;

class Html18 extends JFrame {

  public static void main(String[] args) {
    Html18 frame = new Html18( "Html18" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
  Html18( String title ){
    super( title );
    Container pane = getContentPane();

    String[] header = new String[7];
    header[0] = "<html>" + sun("日曜日<br>Sunday");
    header[1] = "<html>月曜日<br>Monday";
    header[2] = "<html>火曜日<br>Tuesday";
    header[3] = "<html>水曜日<br>Wednesday";
    header[4] = "<html>木曜日<br>Thursday";
    header[5] = "<html>金曜日<br>Friday";
    header[6] = "<html>" + sat("土曜日<br>Saturday");
    String[][] date = {
      { "", "", "", "", day("1"), day("2"), sat("3") },
      { sun("4"),  day( "5"), day("6"), mem("7","七夕"),  day("8"),  day("9"), sat("10") },
      { sun("11"), day("12"), day("13"),day( "14"), day("15"), day("16"), sat("17") },
      { sun("18"), mem("19","終業式"), hol("20","海の日"), day("21"), day("22"), day("23"), sat("24") },
      { sun("25"), day("26"), day("27"), day("28"), day("29"), day("30"), sat("31") },
    };
        
    JTable table = new JTable( date, header );
    table.setRowHeight( 30 );
    JScrollPane scroll = new JScrollPane( table ); // JScrollPane の中に入れなければ、カラムヘッダが表示されない
    scroll.setBorder( new TitledBorder( "１９９９年７月" ) );
    pane.add( scroll );
  }
  String sun( String day ){
    return( "<html><font color=red><b>" + day );
  }
  String sat( String day ){
    return( "<html><font color=blue><i>" + day );
  }
  String hol( String day, String name ){
    return( "<html><font color=red>" + day + "<br>" + name );
  }
  String mem( String day, String name ){
    return( "<html>" + day + "<br>" + name );
  }
  String day( String day ){
    return( "<html>" + day );
  }
}

