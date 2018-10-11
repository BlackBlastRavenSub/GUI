package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class JTextFieldTest4 extends JFrame {

  public static void main( String[] args ){
    JFrame w = new JTextFieldTest4( "JTextFieldTest4" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }

  public JTextFieldTest4( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    NumericField tf1 = new NumericField();
    tf1.setBorder( new TitledBorder( "数字だけのテキストフィールド" ) );
    pane.add( tf1 );

    LimitedField tf2 = new LimitedField( 10 );
    tf2.setBorder( new TitledBorder( "桁数制限のテキストフィールド" ) );
    pane.add( tf2 );

  }

  class NumericField extends JTextField {
    String validValues = "0123456789.+-\b";
    public NumericField(){
      enableEvents( AWTEvent.KEY_EVENT_MASK );
    }

    @Override
    protected void processKeyEvent( KeyEvent e ){
      char chr = e.getKeyChar();
      int code = e.getKeyCode();
      if( code == 0 && validValues.indexOf( chr ) == -1 ){
         e.consume();
      }
      super.processKeyEvent( e );
    }
  }

  class LimitedField extends JTextField {
    private int column, length;

    public LimitedField( int column ){
      this.column = column;
      enableEvents( AWTEvent.KEY_EVENT_MASK );
    }

    @Override
    protected void processKeyEvent( KeyEvent e ){
      if( length >= column &&
          e.getKeyCode() == 0 && e.getKeyChar() != '\b' )
      {
         e.consume();
      }
      if( e.getID()==KeyEvent.KEY_RELEASED ){
        length = getText().length();
      }
      super.processKeyEvent( e );
    }
  }

}
