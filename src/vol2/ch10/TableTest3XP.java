package vol2.ch10;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class TableTest3XP extends JFrame
{
  public static void main(String[] args){
    JFrame f = new TableTest3XP("Table Test 3 XP");
    f.setDefaultCloseOperation(3);
    f.setSize( 320, 240 );
    f.setVisible( true );
  }

  public TableTest3XP( String title ){
    super( title );
    JTable3 table = new JTable3( 4, 2 );
    JPanel panel = new TableTestPanel( table );
    try{
      UIManager.setLookAndFeel( new WindowsLookAndFeel() );
      SwingUtilities.updateComponentTreeUI( panel );
    }
    catch( UnsupportedLookAndFeelException exc ) {
      System.out.println( exc );
    }
    getContentPane().add( panel );
  }

}
