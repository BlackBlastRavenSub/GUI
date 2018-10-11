package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class JTreeTest01B extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTreeTest01B( "JTreeTest01B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 160, 200 );
    w.setVisible( true );
  }

  JTreeTest01B( String title ) {
    super( title );

    String[] nodes = { "1", "2", "3", "4" };

    JTree tree = new JTree( nodes );
    tree.setRootVisible(true);

    DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
    root.setUserObject( "0" );

    //------------------------------------------
    System.out.println( "\n forループを使った 子ノードの列挙" );
    int nodeCount = root.getChildCount();
    for( int i = 0 ; i < nodeCount ; i++ ){
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)root.getChildAt( i );
      
      String name = (String)node.getUserObject();
      System.out.println( "ノード名 : " + name );
    }
    //------------------------------------------
    System.out.println( "\n Enumeration を使った 子ノードの列挙" );
    printNodeNamesByEnum( root );
    //------------------------------------------
    getContentPane().add( tree );
  }
  @SuppressWarnings("unchecked")
  private void printNodeNamesByEnum(DefaultMutableTreeNode r) {
    /* Enumerationクラスでは、拡張for文は使用できない */
    for( 
      Enumeration<DefaultMutableTreeNode> node = 
        (Enumeration<DefaultMutableTreeNode>)r.children(); 
      node.hasMoreElements(); ) {
      String name = node.nextElement().toString();
      System.out.println( "ノード名 : " + name );
    }
  }
}
