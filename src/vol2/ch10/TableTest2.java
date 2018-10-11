package vol2.ch10;
import javax.swing.*;

public class TableTest2 extends JFrame
{
  public static void main(String[] args){
    JFrame f = new TableTest2("Table Test 2");
    f.setDefaultCloseOperation(3);
    f.setSize( 320, 240 );
    f.setVisible( true );
  }

  public TableTest2( String title ){
    super( title );
    JTable2 table = new JTable2( 4, 2 );
    JPanel panel = new TableTestPanel( table );
    getContentPane().add( panel );
  }

}
