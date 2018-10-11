package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest03D extends JTreeTest02 {
  
  public static void main(String[] args) {
    JFrame w = new JTreeTest03D( "JTreeTest03D" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest03D( String title ) {
    super( title );
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    System.out.println( "\n depthFirstEnumeration" );
    Enumeration enum1 = root.depthFirstEnumeration();
    while( enum1.hasMoreElements() ){
      DefaultMutableTreeNode node1 = (DefaultMutableTreeNode)( enum1.nextElement() );
      JTreeModel.printNode( tree, node1 );
    }

    System.out.println( "\n postorderEnumeration" );
    Enumeration enum2 = root.postorderEnumeration();
    while( enum2.hasMoreElements() ){
      DefaultMutableTreeNode node2 = (DefaultMutableTreeNode)( enum2.nextElement() );
      JTreeModel.printNode( tree, node2 );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
