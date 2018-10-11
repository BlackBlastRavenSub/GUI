package vol1.ch04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionTest02 extends JFrame {

  public static void main(String[] args) {
    ActionTest02 w = new ActionTest02( "ActionTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  public ActionTest02( String title ){
    super( title );
    JButton button = new JButton( new Action02() );
    getContentPane().add( button, BorderLayout.NORTH );
  }
  class Action02 extends AbstractAction{
    Action02(){
      putValue( Action.NAME, "開く" );
      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
      putValue( Action.SHORT_DESCRIPTION, "ツールチップ" );
    }
    public void actionPerformed( ActionEvent e ){
      System.out.println( "Action02 が処理されました" );
    }
  }
}
