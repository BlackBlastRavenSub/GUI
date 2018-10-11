package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest04C extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest04C( "JTreeTest04C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest04C( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );

    DefaultTreeSelectionModel selectionModel = 
      (DefaultTreeSelectionModel)tree.getSelectionModel();
    selectionModel.setSelectionMode( TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION );

    TreePath[] paths11 = new TreePath[3];
    paths11[0] = treeModel.getTreePathFromName( "2-1-1-1#" );
    paths11[1] = treeModel.getTreePathFromName( "2-2-2#" );
    paths11[2] = treeModel.getTreePathFromName( "2-3" );
    tree.setSelectionPaths( paths11 );

    TreePath[] paths22 = new TreePath[2];
    paths22[0] = treeModel.getTreePathFromName( "1" );
    paths22[1] = treeModel.getTreePathFromName( "3-1#" );
    tree.addSelectionPaths( paths22 );

    System.out.println( "\n getSelectionPath() の結果" );
    TreePath path = tree.getSelectionPath();
    JTreeModel.printNode( tree, path );

    System.out.println( " getLastSelectedPathComponent() の結果" );
    DefaultMutableTreeNode node = 
      (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    JTreeModel.printNode( tree, node );

    System.out.println( "\n 選択されているノードは：" );

    TreePath[] selectionPaths = tree.getSelectionPaths();
    for( int i = 0 ; i < selectionPaths.length ; i++ ){
      JTreeModel.printNode( tree, selectionPaths[i] );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
