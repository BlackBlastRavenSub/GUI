package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest03 extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest03( "JTreeTest03" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest03( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );
    for( int row=0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    DefaultMutableTreeNode node1 = (DefaultMutableTreeNode)root.getChildAt( 1 );

    System.out.println( "getParent      " + node1.getParent() );
    System.out.println( "" );

    System.out.println( "getPreviousNode    " + node1.getPreviousNode() );
    System.out.println( "getPreviousSibling " + node1.getPreviousSibling() );
    System.out.println( "getPreviousLeaf    " + node1.getPreviousLeaf() );

    System.out.println( "" );
    System.out.println( "currentNode    " + node1 );
    System.out.println( "" );

    System.out.println( "getFirstChild  " + node1.getFirstChild() );
    System.out.println( "getFirstLeaf   " + node1.getFirstLeaf() );

    System.out.println( "" );

    System.out.println( "getLastChild   " + node1.getLastChild() );
    System.out.println( "getLastLeaf    " + node1.getLastLeaf() );

    System.out.println( "" );

    System.out.println( "getNextNode    " + node1.getNextNode() );
    System.out.println( "getNextSibling " + node1.getNextSibling() );
    System.out.println( "getNextLeaf    " + node1.getNextLeaf() );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
