package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class JComboTest04A extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest04A w = new JComboTest04A( "JComboTest04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 400 );
    w.setVisible( true );
  }
  public JComboTest04A( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] sizes = new String[8]; 
    sizes[0] = "通常";
    sizes[1] = "<html><font size=1>サイズ１</font>";
    sizes[2] = "<html><font size=2>サイズ２</font>";
    sizes[3] = "<html><font size=3>サイズ３</font>";
    sizes[4] = "<html><font size=4>サイズ４</font>";
    sizes[5] = "<html><font size=5>サイズ５</font>";
    sizes[6] = "<html><font size=6>サイズ６</font>";
    sizes[7] = "<html><font size=7>サイズ７</font>";
    JComboBox combo = new JComboBox( sizes );
    combo.addPopupMenuListener( new MyPopup() );
    combo.setEditable( true );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }

  class MyPopup implements PopupMenuListener {
    @Override
    public void popupMenuWillBecomeVisible( PopupMenuEvent e ){
	  System.out.println("A");
      JComboBox combo = (JComboBox)e.getSource();
      combo.setSelectedIndex( -1 );
      combo.setEditable( true );
      //combo.configureEditor( combo.getEditor(), "" );
      JTextField tff = (JTextField)( combo.getEditor().getEditorComponent() );
	  tff.setText( "" );
	  
    }
    @Override
    public void popupMenuWillBecomeInvisible( PopupMenuEvent e ){
	  System.out.println("B");
      JComboBox combo = (JComboBox)e.getSource();
//      combo.configureEditor( combo.getEditor(), (String)combo.getSelectedItem() );
      JTextField tff = (JTextField)( combo.getEditor().getEditorComponent() );
	  tff.setText( (String)combo.getSelectedItem() );
      combo.setEditable( false );

      int selectNo = combo.getSelectedIndex();
      String select = (String)combo.getSelectedItem();
      tf.setText( selectNo + ": " + select );
	  
    }
    @Override
    public void popupMenuCanceled( PopupMenuEvent e ){
	  System.out.println("C");
      JComboBox combo = (JComboBox)e.getSource();
      //combo.setEditable( false );
    }
  }
}
