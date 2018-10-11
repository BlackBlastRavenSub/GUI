package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;

public class JTreeTest07 extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest07( "JListTest07" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  public JTreeTest07( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }
    tree.addMouseListener( new MouseCheck() );

    tree.getSelectionModel().setSelectionMode( 
      TreeSelectionModel.SINGLE_TREE_SELECTION  );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }

  class MouseCheck extends MouseAdapter {
    public void mousePressed( MouseEvent e) {
      JTree tree = (JTree)e.getSource();

      System.out.println( "マウス座標は X=" + e.getX() + "  Y=" + e.getY() );

      TreePath path = tree.getPathForLocation( e.getX(), e.getY() );
      if( path != null ){
        DefaultMutableTreeNode node = 
          (DefaultMutableTreeNode)path.getLastPathComponent();
        System.out.println( "今選択されたノードは " + node );
      }

      int row = tree.getRowForLocation( e.getX(), e.getY() );
      System.out.println( "今選択されたノードの行は " + row );
    }
  }
}
