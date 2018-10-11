package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest07 extends JFrame {

  public static void main(String[] args) {
    JComboTest07 w = new JComboTest07( "JComboTest07" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest07( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();
    DefaultComboBoxModel model = new DefaultComboBoxModel();

    model.addElement( new MyAction( "New", new ImageIcon( "new.gif" ) ) );
    model.addElement( new MyAction( "Open", new ImageIcon( "open.gif" ) ) );
    model.addElement( new MyAction( "Save", new ImageIcon( "save.gif" ) ) );

    JComboBox combo = new JComboBox( model );
    combo.setRenderer( new MyCellRenderer() );

    pane.add( combo, BorderLayout.NORTH );

    combo.setBorder( new TitledBorder( "カスタムクラスのコンボボックス" ) );
  }

  class MyAction {
    public String text;
    public Icon icon;
    MyAction( String text, Icon icon ){ 
      this.text = text; 
      this.icon = icon;
    }
  }

  class MyCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
        JList list, Object value, int index, 
        boolean isSelected, boolean cellHasFocus)
    {
      System.out.println( list.getClass().getName() );

      MyAction action = (MyAction)value;
      if( isSelected ){
        setOpaque(true); // これがないと選択時の背景色がセットされない
        setBackground( list.getSelectionBackground() );
      }
      else{
        setOpaque(false); // これがないと非選択時に背景色がリセットされない
      }
      setText( action.text );
      setIcon( action.icon );
      return this;
    }
  }

}
