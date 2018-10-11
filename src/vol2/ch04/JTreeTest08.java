package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;

public class JTreeTest08 extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest08( "JListTest08" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  public JTreeTest08( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    tree.addTreeExpansionListener( new TreeExpand() );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );

  }

  class TreeExpand implements TreeExpansionListener {
    @Override
    public void treeExpanded( TreeExpansionEvent e ) {
      TreePath path = e.getPath();
      DefaultMutableTreeNode node = 
        (DefaultMutableTreeNode)path.getLastPathComponent();
      System.out.println( node + " が展開されました" );

      Enumeration en = node.preorderEnumeration();
      while( en.hasMoreElements() ){
        node = (DefaultMutableTreeNode)( en.nextElement() );
        System.out.print( node + "  " );
      }
      System.out.println( " が出現しました" );
    }
    @Override
    public void treeCollapsed( TreeExpansionEvent e ) {
      TreePath path = e.getPath();
      DefaultMutableTreeNode node = 
        (DefaultMutableTreeNode)path.getLastPathComponent();
      System.out.println( node + " が縮退されました" );

      Enumeration en = node.preorderEnumeration();
      while( en.hasMoreElements() ){
        node = (DefaultMutableTreeNode)( en.nextElement() );
        System.out.print( node + "  " );
      }
      System.out.println( " が隠されました" );
    }
  }
}
