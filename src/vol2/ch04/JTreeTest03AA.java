package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest03AA extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest03AA( "JTreeTest03AA" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest03AA( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    System.out.println( "\n  getNextNode" );
    DefaultMutableTreeNode node = treeModel.getNodeFromName( "2-1" );
    while( true ){
      JTreeModel.printNode( tree, node );
      node = node.getNextNode();
      if( node == null ) break;
    }

    System.out.println( "\n  preorderEnumeration" );
    DefaultMutableTreeNode node2 = treeModel.getNodeFromName( "2-1" );
    Enumeration en = node2.preorderEnumeration();
    while( en.hasMoreElements() ){
      node2 = (DefaultMutableTreeNode)( en.nextElement() );
      JTreeModel.printNode( tree, node2 );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
