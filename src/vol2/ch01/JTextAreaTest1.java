package vol2.ch01;
import javax.swing.*;
import javax.swing.border.*;

public class JTextAreaTest1 extends JFrame {

  public static void main( String[] args ){
    JFrame w = new JTextAreaTest1( "JTextAreaTest1" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 600 );
    w.setVisible( true );
  }

  public JTextAreaTest1( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );
    
    JTextArea ta1 = new JTextArea();
    ta1.setBorder( new TitledBorder( "初期値なし" ) );
    pane.add( ta1 );

    JTextArea ta2 = new JTextArea( 7, 40 );
    ta2.setBorder( new TitledBorder( "初期値７行分" ) );
    pane.add( ta2 );

    JTextArea ta3 = new JTextArea( "\n\n\n\n\n\n\n" );
    ta3.setBorder( new TitledBorder( "初期値７行分" ) );
    pane.add( ta3 );

    JTextArea ta4 = new JTextArea( 7, 40 );
    JScrollPane scr = new JScrollPane( ta4 );
    scr.setBorder( new TitledBorder( "スクロールあり" ) );
    pane.add( scr );

  }
}
