package vol1.ch04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyStrokeTest02 extends JFrame {

  JTextField field = new JTextField();

  public static void main(String[] args) {
    KeyStrokeTest02 w = new KeyStrokeTest02( "KeyStrokeTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 220 );
    w.setVisible( true );
  }

  public KeyStrokeTest02( String title ) {
    super( title );
    JPanel pane = (JPanel)getContentPane();

    String[] ks = { "ESCAPE","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12",

                    "1","2","3","4","5","6","7","8","9","0",
                    "MINUS","CIRCUMFLEX","BACK_SLASH","BACK_SPACE",

                    "Q","W","E","R","T","Y","U","I","O","P",
                    "AT","OPEN_BRACKET",

                    "A","S","D","F","G","H","J","K","L",
                    "SEMICOLON","COLON","CLOSE_BRACKET",

                    "Z","X","C","V","B","N","M",
                    "COMMA","PERIOD","SLASH","ENTER",

                    "ALPHANUMERIC","NONCONVERT","SPACE","CONVERT", "HIRAGANA",

                    "INSERT","HOME","PAGE_UP","DELETE","END","PAGE_DOWN",
                    "UP","LEFT","DOWN","RIGHT",

                    "NUM_LOCK","DIVIDE","MULTIPLY","SUBTRACT","ADD",
                    "NUMPAD7","NUMPAD8","NAMUPAD9",
                    "NUMPAD4","NUMPAD5","NAMUPAD6",
                    "NUMPAD1","NUMPAD2","NAMUPAD3",
                    "NUMPAD0","DECIMAL",
                    "CLEAR"
             };

    Action[] action = new Action[ ks.length ];

    InputMap imap =  pane.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = pane.getActionMap();
    KeyStroke k;

    for( int i=0; i< ks.length ; i++ ){
      action[i] = new KeyCheck( ks[i] );
      k = KeyStroke.getKeyStroke( ks[i] );
      imap.put( k, action[i] );
      amap.put( action[i], action[i] );
    }
  }

  class KeyCheck extends AbstractAction {
    KeyCheck( String num ){
      putValue( Action.NAME, num );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( getValue( Action.NAME ) );
    }
  }


}
