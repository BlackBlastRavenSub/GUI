package vol2.ch04;
import javax.swing.*;

class JTreeTest01 extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTreeTest01( "JTreeTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 160, 200 );
    w.setVisible( true );
  }
  
  JTreeTest01( String title ) {
    super( title );

    String[] nodes = { "1", "2", "3", "4" };

    JTree tree = new JTree( nodes );
    tree.setRootVisible(true);
    
    getContentPane().add( tree );
  }
}
