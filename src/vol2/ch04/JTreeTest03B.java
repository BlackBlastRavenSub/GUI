package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest03B extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest03B( "JTreeTest03B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest03B( String title ) {
    super( title );
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    DefaultMutableTreeNode node = (DefaultMutableTreeNode)root.getLastLeaf();
    while( true ){
      JTreeModel.printNode( tree, node );
      node = node.getPreviousNode();
      if( node == null ) break;
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
