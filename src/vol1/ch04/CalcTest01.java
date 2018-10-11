package vol1.ch04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalcTest01 extends JFrame {

  JTextField field = new JTextField();

  public static void main(String[] args) {
    CalcTest01 w = new CalcTest01( "CalcTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 220 );
    w.setVisible( true );
  }

  public CalcTest01( String title ) {
    super( title );

    JPanel pane = (JPanel)getContentPane();

    pane.add( field, BorderLayout.NORTH );

    JPanel keyPanel = new JPanel( new GridLayout( 4,4 ) );
    pane.add( keyPanel, BorderLayout.CENTER ); 

    String[] a = { "7","8","9","/",
                   "4","5","6","*",
                   "1","2","3","C",
                   "0","+","-","="  };

    Action[] action = {
      new NumKey(a[0]),  new NumKey(a[1]),   new NumKey(a[2]),   new FuncKey(a[3]),
      new NumKey(a[4]),  new NumKey(a[5]),   new NumKey(a[6]),   new FuncKey(a[7]),
      new NumKey(a[8]),  new NumKey(a[9]),   new NumKey(a[10]),  new FuncKey(a[11]),
      new NumKey(a[12]), new FuncKey(a[13]), new FuncKey(a[14]), new FuncKey(a[15])
    };

    for( int i=0; i< action.length ; i++ ){
      keyPanel.add( new JButton( action[i] ) ); 
    }
  }

  class NumKey extends AbstractAction {
    NumKey( String num ){
      putValue( Action.NAME, num );
    }
    public void actionPerformed( ActionEvent e ){
      String num = (String)getValue( Action.NAME );
      field.setText( field.getText() + num );
    }
  }

  class FuncKey extends AbstractAction {
    FuncKey( String label ){
      putValue( Action.NAME, label );
    }
    public void actionPerformed( ActionEvent e ){
      String label = (String)getValue( Action.NAME );
      if( label.equals( "C" ) ){
        field.setText( "" );
      }
    }
  }

}
