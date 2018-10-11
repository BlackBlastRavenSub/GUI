package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest04A extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest04A( "JTreeTest04A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest04A( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );

    TreePath path0 = treeModel.getTreePathFromName( "2-1-1-1#" );
    tree.setSelectionPath( path0 );
    
    System.out.println( "\n getSelectionPath() の結果" );
    TreePath path = tree.getSelectionPath();
    JTreeModel.printNode( tree, path );

    System.out.println( "\n getLastSelectedPathComponent() の結果" );
    DefaultMutableTreeNode node = 
      (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    JTreeModel.printNode( tree, node );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
