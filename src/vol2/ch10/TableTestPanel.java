package vol2.ch10;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TableTestPanel extends JPanel
{
  JPanel panel1 = new JPanel();
  ButtonGroup bg = new ButtonGroup();
  JRadioButton radio1 = new JRadioButton( "radio 1" );
  JRadioButton radio2 = new JRadioButton( "radio 2" );
  JRadioButton radio3 = new JRadioButton( "radio 3" );
  JCheckBox check1 = new JCheckBox( "check 1" );
  JCheckBox check2 = new JCheckBox( "check 2" );
  JCheckBox check3 = new JCheckBox( "check 3" );
  JButton button1 = new JButton();
  JButton button2 = new JButton( new ImageIcon( "new.gif" ) );

  public TableTestPanel( JTable table ){
    bg.add( radio1 );
    bg.add( radio2 );
    bg.add( radio3 );
    table.setValueAt( radio1, 0, 0 );
    table.setValueAt( radio2, 1, 0 );
    table.setValueAt( radio3, 2, 0 );

    table.setValueAt( check1, 0, 1 );
    table.setValueAt( check2, 1, 1 );
    table.setValueAt( check3, 2, 1 );

    button1.setIcon( new ImageIcon( "bold.gif" ) );
    button1.setRolloverIcon( new ImageIcon( "strike.gif" ) );

    button1.setToolTipText( "ツールチップ" );

    table.setValueAt( button1, 3, 0 );
    table.setValueAt( button2, 3, 1 );

    JScrollPane sp = new JScrollPane( table );
    sp.setPreferredSize( new Dimension( 305, 285 ) );
    add( sp );

    JPopupMenu popup = new JPopupMenu();
    JMenuItem open = new JMenuItem( "Open" );
    popup.add( open );
    JMenuItem save = new JMenuItem( "Save" );
    popup.add( save );
    button1.setComponentPopupMenu( popup );

    JPopupMenu popup2 = new JPopupMenu();
    JMenuItem cut = new JMenuItem( "Cut" );
    popup2.add( cut );
    JMenuItem copy = new JMenuItem( "Copy" );
    popup2.add( copy );
    button2.setComponentPopupMenu( popup2 );
  }
}
