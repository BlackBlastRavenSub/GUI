package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest01C extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTreeTest01C( "JTreeTest01C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 160, 200 );
    w.setVisible( true );
  }

  JTreeTest01C( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );

    DefaultMutableTreeNode node1 = new DefaultMutableTreeNode( "1" );
    root.add( node1 );

    DefaultMutableTreeNode node2 = new DefaultMutableTreeNode( "2" );
    root.add( node2 );

    DefaultMutableTreeNode node4 = new DefaultMutableTreeNode( "4" );
    root.add( node4 );

    DefaultMutableTreeNode node3 = new DefaultMutableTreeNode( "3" );
    root.insert( node3, 2 );

    DefaultMutableTreeNode node5 = new DefaultMutableTreeNode( "5" );
    root.add( node5 );
    root.remove( 4 );

    DefaultMutableTreeNode node6 = new DefaultMutableTreeNode( "6" );
    root.add( node6 );
    root.remove( node6 );


    JTree tree = new JTree( root );
    getContentPane().add( tree );
  }
}
