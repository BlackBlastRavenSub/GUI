package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest03C extends JTreeTest02 {
  
  public static void main(String[] args) {
    JFrame w = new JTreeTest03C( "JTreeTest03C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest03C( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    System.out.println( " ルートノード から辿る" );
    Enumeration enum1 = root.breadthFirstEnumeration();
    while( enum1.hasMoreElements() ){
      DefaultMutableTreeNode node1 = (DefaultMutableTreeNode)( enum1.nextElement() );
      JTreeModel.printNode( tree, node1 );
    }

    System.out.println( "\n ノード 2-1 から辿る" );
    DefaultMutableTreeNode node2 = treeModel.getNodeFromName( "2-1" );
    Enumeration enum2 = node2.breadthFirstEnumeration();
    while( enum2.hasMoreElements() ){
      node2 = (DefaultMutableTreeNode)( enum2.nextElement() );
      JTreeModel.printNode( tree, node2 );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
