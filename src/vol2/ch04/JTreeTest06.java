package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest06 extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest06( "JListTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  public JTreeTest06( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row=0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }
    tree.addTreeSelectionListener( new TreeSelect() );

    tree.getSelectionModel().setSelectionMode( 
      TreeSelectionModel.SINGLE_TREE_SELECTION );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );

  }

  class TreeSelect implements TreeSelectionListener {
    public void valueChanged( TreeSelectionEvent e ) {
      JTree tree = (JTree)e.getSource();
      TreePath path = e.getPath();
      JTreeModel.printNode( tree, path );
    }
  }

}
