package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest06A extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest06A( "JListTest06A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  public JTreeTest06A( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }
    tree.addTreeSelectionListener( new TreeSelect() );

    tree.getSelectionModel().setSelectionMode( 
      TreeSelectionModel.CONTIGUOUS_TREE_SELECTION );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );

  }

  class TreeSelect implements TreeSelectionListener {
    public void valueChanged( TreeSelectionEvent e ) {
      System.out.println( "-------------" );
      JTree tree = (JTree)e.getSource();

      System.out.println( "\n＊＊今選択されたノードは " );
      TreePath path = e.getPath();
      JTreeModel.printNode( tree, path );

      System.out.println( "\n＊＊今選択された区間のノードは" );
      TreePath[] paths = e.getPaths();
      for( int i = 0 ; i < paths.length ; i++ ){
        JTreeModel.printNode( tree, paths[i] );
      }

      System.out.println( "\n old lead selection" );
      TreePath oldLeadSelectionPath = e.getOldLeadSelectionPath();
      if( oldLeadSelectionPath != null ){
        JTreeModel.printNode( tree, oldLeadSelectionPath );
      }

      System.out.println( "\n new lead selection" );
      TreePath newLeadSelectionPath = e.getNewLeadSelectionPath();
      JTreeModel.printNode( tree, newLeadSelectionPath );

      TreePath[] totalSelectionPaths = tree.getSelectionPaths();
      System.out.println( "\n＃＃選択されているノードは" );
      for( int i = 0 ; i < totalSelectionPaths.length ; i++ ){
        JTreeModel.printNode( tree, totalSelectionPaths[i] );
      }
    }
  }
}
