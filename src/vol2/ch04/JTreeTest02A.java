package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest02A extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest02A( "JTreeTest02A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  JTreeTest02A( String title ) {
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTree tree = new JTree( root );

    int childCount = root.getChildCount();
    System.out.println( "ルートの直接の子の数 " + childCount );
    int rowCount = tree.getRowCount();
    System.out.println( "展開前の行数 " + rowCount );

    int leafCount = root.getLeafCount();
    System.out.println( "ルートの葉ノードの総数 " + leafCount );
    int depth = root.getDepth();
    System.out.println( "ツリーの最深部の階層 " + depth );

    for( int row=0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }
    System.out.println( "ノードの数 " + nodeCount );
    System.out.println( "展開後の行数 " + tree.getRowCount() );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
