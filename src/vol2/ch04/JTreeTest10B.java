package vol2.ch04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class JTreeTest10B extends JFrame {
  
  public static void main(String[] args) {
    JFrame w = new JTreeTest10B( "JListTest10B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 200, 240 );
    w.setVisible( true );
  }
  public JTreeTest10B( String title ) {  
    super( title );
    
    MyAction a1 = new MyAction( "New", new ImageIcon( "new.gif" ) );
    MyAction a2 = new MyAction( "Open", new ImageIcon( "open.gif" ) );
    MyAction a3 = new MyAction( "Save", new ImageIcon( "save.gif" ) );
    MyAction a4 = new MyAction( "Exit", new ImageIcon( "exit.gif" ) );
    
    DefaultMutableTreeNode root = new DefaultMutableTreeNode( "コマンド" );
    DefaultMutableTreeNode n1 = new DefaultMutableTreeNode( a1 );
    DefaultMutableTreeNode n2 = new DefaultMutableTreeNode( a2 );
    DefaultMutableTreeNode n3 = new DefaultMutableTreeNode( a3 );
    DefaultMutableTreeNode n4 = new DefaultMutableTreeNode( a4 );
    root.add( n1 );
    root.add( n2 );
    root.add( n3 );
    root.add( n4 );
    
    JTree tree = new JTree( root );
    
    tree.setCellRenderer( new MyCellRenderer() );
    getContentPane().add( tree );
  }
  //-----------------
  class MyCellRenderer extends DefaultTreeCellRenderer{
    @Override
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean isSelected, boolean expanded, 
        boolean leaf, int row, boolean hasFocus )
    {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
      Object obj = node.getUserObject();
      if( obj instanceof MyAction ){
        MyAction action = (MyAction)obj;

        setText( (String)action.getValue( Action.NAME ) );
        setIcon( (Icon)action.getValue( Action.SMALL_ICON ) );

        setOpaque( true ); // これがないと背景色がセットされない
        if( isSelected ){
          setForeground( Color.red );
          setBackground( Color.cyan );
        }
        else{
          setForeground( Color.black );
          setBackground( Color.white );
        }

        return( this );
      }
      Component comp = 
        super.getTreeCellRendererComponent( tree, value, selected, expanded, 
                                            leaf, row, hasFocus );
      return comp;
    }
  }

  class MyAction extends AbstractAction {
    MyAction( String text, Icon icon ){ super( text, icon ); }
    @Override
    public void actionPerformed( ActionEvent e ){}
  }

}
