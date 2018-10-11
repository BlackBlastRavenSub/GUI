package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest04B extends JTreeTest02 {
  
  public static void main(String[] args) {
    JFrame w = new JTreeTest04B( "JTreeTest04B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest04B( String title ) {
    super( title );
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );

    DefaultTreeSelectionModel selectionModel = 
      (DefaultTreeSelectionModel)tree.getSelectionModel();
    selectionModel.setSelectionMode( TreeSelectionModel.CONTIGUOUS_TREE_SELECTION );

    TreePath path1 = treeModel.getTreePathFromName( "1-1#" );
    tree.addSelectionPath( path1 );
    TreePath path2 = treeModel.getTreePathFromName( "1-2#" );
    tree.addSelectionPath( path2 );
    TreePath path3 = treeModel.getTreePathFromName( "1-3#" );
    tree.addSelectionPath( path3 );

    int selectionCount = tree.getSelectionCount();
    System.out.println( "選択されているノードの総数 " + selectionCount );

    int row1 = tree.getMinSelectionRow();
    int row2 = tree.getMaxSelectionRow();
    int row3 = tree.getLeadSelectionRow();
    System.out.println( "選択範囲の最初の行は " + row1 );
    System.out.println( "選択範囲の最後の行は " + row2 );
    System.out.println( "現在の選択ポイントの行は " + row3 );

    int[] rows = tree.getSelectionRows();
    System.out.println( "  選択されている行は：" );
    for( int i = 0 ; i < rows.length ; i++ ){
      System.out.print( rows[i] + " " );
    }

    System.out.println( "\n\n getSelectionPath() の結果" );
    TreePath path = tree.getSelectionPath();
    JTreeModel.printNode( tree, path );

    System.out.println( " getLastSelectedPathComponent() の結果" );
    DefaultMutableTreeNode node = 
      (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    JTreeModel.printNode( tree, node );

    System.out.println( "\n  選択されているノードは：" );

    TreePath[] selectionPaths = tree.getSelectionPaths();
    for( int i = 0 ; i < selectionPaths.length ; i++ ){
      JTreeModel.printNode( tree, selectionPaths[i] );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
