package vol2.ch10;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;

public class TableTest4 extends JPanel
{
  ButtonGroup bg = new ButtonGroup();
  JRadioButton radio1 = new JRadioButton( "radio 1" );
  JRadioButton radio2 = new JRadioButton( "radio 2" );
  JRadioButton radio3 = new JRadioButton( "radio 3" );
  JCheckBox check1 = new JCheckBox( "check 1" );
  JCheckBox check2 = new JCheckBox( "check 2" );
  JCheckBox check3 = new JCheckBox( "check 3" );

  String[] items =  { "First", "Second", "Third", "4th", "5th", "6th", "7th" };
  JList list = new JList( items );

  JSplitPane split = new JSplitPane( JSplitPane.VERTICAL_SPLIT );

  JButton button1  = new JButton( "縦マージ" );
  JButton button2  = new JButton();
  JButton button3  = new JButton( "横マージ" );
  JComboBox combo  = new JComboBox( new String[] { "First", "Second", "Third" } );
  JSpinner spiner1 = new JSpinner();
  JSpinner spiner2 = new JSpinner();

  JTree tree = new JTree();
  JTabbedPane tab = new JTabbedPane();
  JSlider slider = new JSlider( JSlider.VERTICAL, 0, 100, 75 );

  JScrollBar scroll = new JScrollBar( JScrollBar.VERTICAL, 25, 5, 0, 100 );
  JProgressBar progress = new JProgressBar( JProgressBar.VERTICAL, 0, 100 );

  public static void main(String[] args){
    JFrame f = new JFrame( "Table Test 4" );

    JTable4 table = new JTable4( 8, 5 );
    f.getContentPane().add( new TableTest4( table ) );

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 450, 580 );
    f.setVisible( true );
  }

  public TableTest4( JTable4 table ){

    ButtonGroup bg = new ButtonGroup();
    bg.add( radio1 );
    bg.add( radio2 );
    bg.add( radio3 );

    radio1.setSelected( true );
    check2.setSelected( true );

    combo.setEditable( true );
    spiner2.setModel( new SpinnerDateModel() );

    list.setSelectedIndex(2);

    split.setTopComponent( new JButton( "上" ) );
    split.setBottomComponent( new JButton( "下" ) );

    button2.setIcon( new ImageIcon( "new.gif" ) );
    button2.setRolloverIcon( new ImageIcon( "save.gif" ) );

    table.setRowHeightFix(0);
    table.setRowHeightFix(1);
    table.setRowHeightFix(2);
    table.setRowHeightFix(3);
    table.setRowHeightFix(4);
    table.setRowHeightFix(5);

    table.setRowHeight( 3, 25 );
    table.setRowHeight( 4, 25 );
    table.setRowHeight( 5, 25 );

    table.setValueAt( radio1,  0, 0 );
    table.setValueAt( radio2,  1, 0 );
    table.setValueAt( radio3,  2, 0 );

    table.setValueAt( check1,  0, 1 );
    table.setValueAt( check2,  1, 1 );
    table.setValueAt( check3,  2, 1 );

    table.setValueAt( list,    0, 2, 6, 1 );
    table.setValueAt( split,   0, 3, 6, 2 );

    table.setValueAt( combo,   3, 1 );
    table.setValueAt( spiner1, 4, 1 );
    table.setValueAt( spiner2, 5, 1 );

    table.setValueAt( button1, 3, 0, 4, 1 );
    table.setValueAt( button2, 6, 1 );
    table.setValueAt( button3, 6, 2, 1, 3 );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "root" );
    DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
    for( int i = 0 ; i < 4 ; i++  ){
       String ii = Integer.toString(i);
       node[i] = new DefaultMutableTreeNode( ii );
       root.add( node[i] );
       for( int j = 0 ; j < 3 ; j++ ){
          node[i].add( new DefaultMutableTreeNode( ii + "-" + j ) );
       }
    }
    DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
    treeModel.setRoot( root );
    for( int i = 0 ; i < tree.getRowCount() ; i++ ){
      tree.expandRow(i);
    }
    tree.putClientProperty("JTree.lineStyle", "Horizontal");
    tree.setPreferredSize( new Dimension( 80, 340 ) );
    tree.setSelectionRow(2);
    table.setValueAt( tree, 7, 0 );

    for( int i = 0 ; i < 16 ; i++ ){
       tab.addTab( Integer.toString(i), new JPanel() );
    }
    tab.setTabPlacement( SwingConstants.LEFT );
    tab.setSelectedIndex(4);
    table.setValueAt( tab, 7, 1 );

    slider.setPaintLabels( true );
    slider.setPaintTicks( true );
    slider.setMajorTickSpacing( 10 );
    slider.setMinorTickSpacing(1);
    table.setValueAt( slider, 7, 2 );

    scroll.setPreferredSize( new Dimension( 20, 340 ) );
    table.setValueAt( scroll, 7, 3 );

    progress.setValue( 75 );
    progress.setStringPainted( true );
    progress.setBorderPainted( true );
    progress.setPreferredSize( new Dimension( 20, 340 ) );
    table.setValueAt( progress, 7, 4 );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)table.getColumnModel();
    TableColumn col3 = cmodel.getColumn(3);
    TableColumn col4 = cmodel.getColumn(4);
    col3.setMaxWidth( 30 );
    col4.setMaxWidth( 30 );

    table.setPreferredSize( new Dimension( 400, 540 ) );
    JScrollPane sp = new JScrollPane( table );
    sp.setPreferredSize( new Dimension( 405, 545 ) );
    add( sp );
  }
}
