package vol2.ch10;
import javax.swing.*;

public class TableTest3 extends JFrame
{
  public static void main(String[] args){
    JFrame f = new TableTest3("Table Test 3");
    f.setDefaultCloseOperation(3);
    f.setSize( 320, 240 );
    f.setVisible( true );
  }

  public TableTest3( String title ){
    super( title );
    JTable3 table = new JTable3( 4, 2 );
    JPanel panel = new TableTestPanel( table );
    getContentPane().add( panel );
  }

}
