package vol2.ch09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTable2Test 
  implements ActionListener, ListSelectionListener, ChangeListener
{
  JButton button = new JButton("Button");
  JRadioButton radio1 = new JRadioButton( "radio1" );
  JCheckBox check1 = new JCheckBox( "check1" );
  JComboBox combo = new JComboBox( new String[] { "First", "Second", "Third" } );
  JList list = new JList( new String[] { "First", "Second", "Third", "4th" } );
  JTabbedPane tab = new JTabbedPane();

  public static void main(String[] args){
    JFrame f = new JFrame("JTable2 test");
    new JTable2Test( f );
    f.setDefaultCloseOperation(3);
    f.setSize( 480, 500 );
    f.setVisible(true);
  }

  public JTable2Test( JFrame f ){

    JTable2 table = new JTable2( 3, 4 );

    table.setValueAt( button, 0, 0 );
    button.addActionListener( this );

    table.setValueAt( combo, 0, 1 );
    combo.addActionListener( this );

    table.setValueAt( list, 0, 2 );
    list.addListSelectionListener( this );

    table.setValueAt( radio1, 1, 0 );
    radio1.addActionListener( this );

    table.setValueAt( check1, 1, 1 );
    check1.addActionListener( this );

    JLabel label = new JLabel( "Label", new ImageIcon( "new.gif" ), JLabel.LEFT );
    table.setValueAt( label, 1, 2 );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "root" );
    DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
    for( int i=0 ; i < 4 ; i++  ){
       String ii = Integer.toString(i);
       node[i] = new DefaultMutableTreeNode( ii );
       root.add( node[i] );
       for( int j=0 ; j < 3 ; j++ ){
          node[i].add( new DefaultMutableTreeNode( ii + "-" + Integer.toString(j) ) );
       }
    }

    JTree tree = new JTree( root );
    tree.putClientProperty("JTree.lineStyle", "Angled");

    JScrollPane scr1 = new JScrollPane( tree );
    table.setValueAt( scr1, 2, 0 );

    JScrollPane scr2 = new JScrollPane( new JTextArea( 5, 30 ) );
    table.setValueAt( scr2, 2, 1 );

    for( int i = 0 ; i < 16 ; i++ ){
       tab.addTab( Integer.toString(i), new JPanel() );
    }
    tab.setTabPlacement( SwingConstants.LEFT );
    tab.addChangeListener( this );
    JScrollPane scr3 = new JScrollPane( tab );
    table.setValueAt( scr3, 2, 2 );

    JScrollPane sp = new JScrollPane(table);
    f.getContentPane().add( sp );
  }
  @Override
  public void actionPerformed( ActionEvent e ){
    if( e.getSource() == button ){
      System.out.println( "ボタンが押されました" );
    }
    if( e.getSource() == radio1 ){
      String on = radio1.isSelected() ? "オン" : "オフ";
      System.out.println( "ラジオボタンは " + on + " です" );
    }
    if( e.getSource() == check1 ){
      String on = check1.isSelected() ? "オン" : "オフ";
      System.out.println( "チェックボックスは " + on + " です" );
    }
    if( e.getSource() == combo ){
      System.out.println( "コンボボックスで " + combo.getSelectedItem() + 
                          " が選ばれました" );
    }
  }
  @Override
  public void valueChanged( ListSelectionEvent e ){
    if( e.getValueIsAdjusting() == false ){
      System.out.println( "リストで " + list.getSelectedValue() + 
                          " が選ばれました" );
    }
  }
  @Override
  public void stateChanged( ChangeEvent e ){
    int index = tab.getSelectedIndex();
    System.out.println( "タブペインで " + index + " 番が選ばれました" );
  }
}
