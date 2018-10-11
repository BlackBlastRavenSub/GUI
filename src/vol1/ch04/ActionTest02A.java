package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02A extends JFrame {

  public static void main(String[] args) {
    ActionTest02A w = new ActionTest02A( "ActionTest02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }
  public ActionTest02A( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    ButtonGroup buttonGroup = new ButtonGroup();

    for( int i=0 ; i<4 ; i++ ){
      JRadioButton bt = new JRadioButton( new RadioAction( i ) );
      pane.add( bt );
      buttonGroup.add( bt );
    }
  }
  class RadioAction extends AbstractAction{
    RadioAction( int index ){
      putValue( Action.NAME, "ラジオボタン"+ index );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( (String)getValue( Action.NAME ) +" が 選択されました" );
    }
  }
}
