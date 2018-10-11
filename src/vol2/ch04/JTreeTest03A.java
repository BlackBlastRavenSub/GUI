package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest03A extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest03A( "JTreeTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest03A( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    System.out.println( "\n  getNextNode" );
    DefaultMutableTreeNode node = root;
    while( true ){
      JTreeModel.printNode( tree, node );
      node = node.getNextNode();
      if( node == null ) break;
    }

    System.out.println( "\n  preorderEnumeration" );
    Enumeration en = root.preorderEnumeration();
    while( en.hasMoreElements() ){
      DefaultMutableTreeNode node2 = (DefaultMutableTreeNode)( en.nextElement() );
      JTreeModel.printNode( tree, node2 );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }

}
