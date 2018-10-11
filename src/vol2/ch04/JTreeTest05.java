package vol2.ch04;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class JTreeTest05 extends JTreeTest02 {
  
  public static void main(String[] args) {
    JFrame w = new JTreeTest05( "JListTest05" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 380 );
    w.setVisible( true );
  }

  public JTreeTest05( String title ) {  
    super( title );

    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "0" );
    int nodeCount = setupTreeNode( root );
    JTreeModel treeModel = new JTreeModel( root );
    JTree tree = new JTree( treeModel );
    for( int row = 0 ; row < nodeCount ; row++ ){
      tree.expandRow( row );
    }

    String prefix = "2-1";
    int row;
    int lastRow; //前回の行番号
    DefaultMutableTreeNode node;

    row = lastRow = 0; //最初の行番号をセット
    System.out.println( "\n"+ prefix + " で始まるノードの一覧（正順）" );
    while( true ) {
      TreePath path = tree.getNextMatch( prefix, row, Position.Bias.Forward );
      if( path == null ) break;
      row = tree.getRowForPath( path );
      if( lastRow > row ) break;

      JTreeModel.printNode( tree, path );
      lastRow = row;  row++;
    }

    int rowCount = tree.getRowCount();
    row = lastRow = rowCount-1; //最後の行番号をセット
    System.out.println( "\n"+ prefix + " で始まるノードの一覧（逆順）" );
    while( true ) {
      TreePath path = tree.getNextMatch( prefix, row, Position.Bias.Backward );
      if( path == null ) break;
      row = tree.getRowForPath( path );
      if( lastRow < row ) break;

      JTreeModel.printNode( tree, path );
      lastRow = row;  
      row--;
    }

    JScrollPane sc = new JScrollPane( tree );
    getContentPane().add( sc );
  }
}
