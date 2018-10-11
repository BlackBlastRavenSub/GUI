package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeModel extends DefaultTreeModel {
  DefaultMutableTreeNode root;

  public JTreeModel( TreeNode root ){
    super( root );
    this.root = (DefaultMutableTreeNode)root;
  }

  public static void printNode( JTree tree, DefaultMutableTreeNode node ){
    TreeNode[] nodes = node.getPath();
    TreePath path = new TreePath( nodes );
    int row = tree.getRowForPath( path );
    System.out.println( "Row:"+ row + "  ノード名 : " + node );
  }

  public static void printNode( JTree tree, TreePath path ){
    DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
    int row = tree.getRowForPath( path );
    System.out.println( "Row:" + row + "  ノード名 : " + node );
  }

  public DefaultMutableTreeNode getNodeFromName( String searchName ){
    DefaultMutableTreeNode findNode = null;
    DefaultMutableTreeNode currentNode = root;
    while( true ){
      String currentNodeName = currentNode.toString();
      if( currentNodeName.equals( searchName ) ){
        findNode = currentNode;
        break;
      }
      currentNode = currentNode.getNextNode();
      if( currentNode==null ) break;
    }
    return( findNode );
  }

  public TreePath getTreePathFromName( String nodeName ){
    TreePath treePath = null;
    
    DefaultMutableTreeNode node = getNodeFromName( nodeName );
    if( node != null ){
      TreeNode[] nodesForPath = node.getPath();
      treePath = new TreePath( nodesForPath );
    }
    return( treePath );
  }
}
