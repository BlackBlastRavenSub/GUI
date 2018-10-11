package vol2.ch04;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest10 extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest10( "JListTest10" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 500 );
    w.setVisible( true );
  }
  public JTreeTest10( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row=0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    DefaultTreeCellRenderer myCellRenderer = new DefaultTreeCellRenderer();

    myCellRenderer.setLeafIcon( new ImageIcon( "file.gif" ) );
    myCellRenderer.setOpenIcon( new ImageIcon( "openfolder.gif" ) );
    myCellRenderer.setClosedIcon( new ImageIcon( "folder.gif" ) );

    myCellRenderer.setBackgroundNonSelectionColor( Color.lightGray );
    myCellRenderer.setBackgroundSelectionColor( Color.green );
    myCellRenderer.setBorderSelectionColor( Color.black );

    myCellRenderer.setTextNonSelectionColor( Color.blue );
    myCellRenderer.setTextSelectionColor( Color.red );

    tree.setCellRenderer( myCellRenderer );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
