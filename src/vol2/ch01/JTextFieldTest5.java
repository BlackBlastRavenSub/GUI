package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JTextFieldTest5 extends JFrame {

  public static void main( String[] args ){
    JFrame w = new JTextFieldTest5( "JTextFieldTest6" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }

  public JTextFieldTest5( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    JTextField tf1 = new JTextField();
    tf1.setDocument( new NumericDocument() );
    tf1.setBorder( new TitledBorder( "テキストフィールド１" ) );
    pane.add( tf1 );

    JTextField tf2 = new JTextField();
    tf2.setDocument( new LimitedDocument( 10 ) );
    tf2.setBorder( new TitledBorder( "テキストフィールド２" ) );
    pane.add( tf2 );

  }

  class NumericDocument extends PlainDocument {
    String validValues = "0123456789.+-";

	@Override
    public void insertString( int offset, String str, AttributeSet a ) {
      if( validValues.indexOf( str ) == -1 ){
         return;
      }
      try{
        super.insertString( offset, str, a );
      }
      catch( BadLocationException e ) {
        System.out.println( e );
      }
    }
  }

  class LimitedDocument extends PlainDocument {
    int limit;
    LimitedDocument( int limit ){ this.limit = limit; }

    @Override
    public void insertString( int offset, String str, AttributeSet a ) {
      if( getLength() >= limit ){
         return;
      }
      try{
        super.insertString( offset, str, a );
      }
      catch( BadLocationException e ) {
        System.out.println( e );
      }
    }
  }

}
