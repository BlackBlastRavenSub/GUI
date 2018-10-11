package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;

class JTreeTest02 extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTreeTest02( "JTreeTest02" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }
  
  JTreeTest02( String title ) {
    super( title );
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    setupTreeNode( root );
    JTree tree = new JTree( root );
    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }

  int setupTreeNode( DefaultMutableTreeNode root ){
    int i = 1;

    DefaultMutableTreeNode n1 = new DefaultMutableTreeNode( "1" ); i++;
    root.add( n1 );

    n1.add(new DefaultMutableTreeNode( "1-1#" )); i++;
    n1.add(new DefaultMutableTreeNode( "1-2#" )); i++;
    n1.add(new DefaultMutableTreeNode( "1-3#" )); i++;

    DefaultMutableTreeNode n2 = new DefaultMutableTreeNode( "2" ); i++;
    root.add(n2);

    DefaultMutableTreeNode n21 = new DefaultMutableTreeNode( "2-1" ); i++;
    n2.add( n21 );

    DefaultMutableTreeNode n211 = new DefaultMutableTreeNode( "2-1-1" ); i++;
    n21.add( n211 );
    n211.add( new DefaultMutableTreeNode( "2-1-1-1#" ) ); i++;

    n21.add( new DefaultMutableTreeNode( "2-1-2#" ) ); i++;
    n21.add( new DefaultMutableTreeNode( "2-1-3#" ) ); i++;

    DefaultMutableTreeNode n22 = new DefaultMutableTreeNode( "2-2" ); i++;
    n2.add( n22 );
    n22.add( new DefaultMutableTreeNode( "2-2-1#" ) ); i++;
    n22.add( new DefaultMutableTreeNode( "2-2-2#" ) ); i++;

    DefaultMutableTreeNode n23 = new DefaultMutableTreeNode( "2-3" ); i++;
    n2.add( n23 );
    n23.add( new DefaultMutableTreeNode( "2-3-1#" ) ); i++;

    DefaultMutableTreeNode n3 = new DefaultMutableTreeNode( "3" ); i++;
    root.add( n3 );

    DefaultMutableTreeNode n31 = new DefaultMutableTreeNode( "3-1#" ); i++;
    n3.add( n31 );

    return(i);
  }
}
