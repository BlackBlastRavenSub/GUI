package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02B extends JFrame {

  public static void main(String[] args) {
    ActionTest02B w = new ActionTest02B( "ActionTest02B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 150 );
    w.setVisible( true );
  }
  public ActionTest02B( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    for( int i=0 ; i<4 ; i++ ){
      pane.add( new JCheckBox( new CheckAction( i ) ) );
    }
  }
  class CheckAction extends AbstractAction{
    CheckAction( int index ){
      putValue( Action.NAME, "チェックボックス"+ index );
    }
    public void actionPerformed( ActionEvent e ){
      JCheckBox cb = (JCheckBox)e.getSource();
      String msg;
      if( cb.isSelected() ) msg = "選択されました";
      else                  msg = "選択解除されました";
      System.out.println( (String)getValue( Action.NAME ) +" が " + msg );
    }
  }
}
