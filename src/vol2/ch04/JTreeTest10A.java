package vol2.ch04;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest10A extends JTreeTest02 {

  public static void main(String[] args) {
    JFrame w = new JTreeTest10A( "JListTest10A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 240, 320 );
    w.setVisible( true );
  }
  public JTreeTest10A( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    tree.setCellRenderer( new MyCellRenderer() );

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );

  }
  //-----------------
  class MyCellRenderer extends DefaultTreeCellRenderer{
    @Override
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, 
        boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus )
    {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
      System.out.println( row + " "+ node + "/ selected=" + selected + 
                          "/ expanded=" + expanded + "/ leaf=" + leaf + 
                          "/ row=" + row + "/ hasFocus="+ hasFocus );
      Component comp = 
        super.getTreeCellRendererComponent( tree, value, selected, expanded, 
                                            leaf, row, hasFocus );
      return comp;
    }
  }
}
