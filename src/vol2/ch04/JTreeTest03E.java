package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest03E extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest03E( "JTreeTest03E" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest03E( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }
    
    System.out.println( "\n getNextLeaf" );
    DefaultMutableTreeNode node1 = root.getFirstLeaf();
    while( true ){
      JTreeModel.printNode( tree, node1 );
      node1 = node1.getNextLeaf();
      if( node1 == null ) break;
    }

    System.out.println( "\n getPreviousLeaf" );
    DefaultMutableTreeNode node2 = root.getLastLeaf();
    while( true ){
      JTreeModel.printNode( tree, node2 );
      node2 = node2.getPreviousLeaf();
      if( node2 == null ) break;
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
