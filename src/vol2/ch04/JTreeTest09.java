package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest09 extends JTreeTest02 {
  JPanel pane;

  public static void main(String[] args) {
    JFrame w = new JTreeTest09( "JTreeTest09" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  public JTreeTest09( String title ) {  
    super( title );

    pane = (JPanel)getContentPane();

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    tree.addTreeWillExpandListener( new TreeWillExpand() );

    JScrollPane sc = new JScrollPane( tree );
    pane.add( sc );

  }

  class TreeWillExpand implements TreeWillExpandListener {

    @Override
    public void treeWillExpand( TreeExpansionEvent e ) throws ExpandVetoException {
      TreePath path = e.getPath();
      DefaultMutableTreeNode node = 
        (DefaultMutableTreeNode)path.getLastPathComponent();

      String msg = "ノード [" + node + "] を展開しますか";
      int ans = JOptionPane.showConfirmDialog( pane, msg );
      if( ans != 0 ){
        ExpandVetoException eve = new ExpandVetoException( e );
        throw eve;
      }
    }

    @Override
    public void treeWillCollapse( TreeExpansionEvent e )  throws ExpandVetoException {
      TreePath path = e.getPath();
      DefaultMutableTreeNode node = 
        (DefaultMutableTreeNode)path.getLastPathComponent();

      String msg = "ノード [" + node + "] を縮退しますか";
      int ans = JOptionPane.showConfirmDialog( pane, msg );
      if( ans != 0 ){
        ExpandVetoException eve = new ExpandVetoException( e );
        throw eve;
      }
    }
  }
}
