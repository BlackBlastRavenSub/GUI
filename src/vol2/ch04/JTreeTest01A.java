package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest01A extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTreeTest01A( "JTreeTest01A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 160, 200 );
    w.setVisible( true );
  }

  JTreeTest01A( String title ) {
    super( title );

    String[] nodes = { "1", "2", "3", "4" };

    JTree tree = new JTree( nodes );
    tree.setRootVisible(true);

    DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
    root.setUserObject( "0" ); // ルートノードの名前を変える

    getContentPane().add( tree );
  }
}
