package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest02B extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest02B( "JTreeTest02B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest02B( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );

    for( int row=0 ; row < nodeCount ; row++ ){
      TreePath path = tree.getPathForRow( row );

      DefaultMutableTreeNode thisNode = 
        (DefaultMutableTreeNode) path.getLastPathComponent() ;
      JTreeModel.printNode( tree, thisNode );

      int depth = path.getPathCount();
      System.out.print( depth + "階層目  " );

      int pathCount = path.getPathCount();
      if( 1 < pathCount ){
        System.out.print( "このノードに至る経路:  " );
        for( int i=0 ; i < (pathCount-1) ; i++ ){
          DefaultMutableTreeNode node = 
            (DefaultMutableTreeNode) path.getPathComponent(i);
          System.out.print( node + "  " );
        }
      }

      boolean isLeaf = thisNode.isLeaf();
      if( !isLeaf ){
        tree.expandPath( path ); //末端ノードでなければ展開する
      }
      System.out.println( "" );
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
