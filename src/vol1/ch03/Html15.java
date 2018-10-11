package vol1.ch03;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

class Html15 extends JFrame {
  JLabel color = new JLabel();

  public static void main(String[] args) {
    Html15 frame = new Html15( "Html15" );
    frame.setDefaultCloseOperation(3); // EXIT_ON_CLOSE
    frame.setSize( 300, 420 );
    frame.setVisible( true );
  }
  Html15( String title ){
    super( title );
    Container pane = getContentPane();
    pane.setLayout( new BoxLayout( pane, BoxLayout.Y_AXIS ) );

    String[] colors = new String[13];
    colors[0] = "Color";
    colors[1] = "<html><font color=#00FF00>■■<p></font>Green";
    colors[2] = "<html><font color=#9ACD32>■■</font>YellowGreen";
    colors[3] = "<html><font color=#006400>■■</font>DarkGreen";
    colors[4] = "<html><font color=#FFFF00>■■<p></font>Yellow";
    colors[5] = "<html><font color=#FFD700>■■</font>Gold";
    colors[6] = "<html><font color=#FFA500>■■</font>Orange";
    colors[7] = "<html><font color=#FF0000>■■<p></font>Red";
    colors[8] = "<html><font color=#FF4500>■■</font>OrangeRed";
    colors[9] = "<html><font color=#800000>■■</font>Maroon";
    colors[10] = "<html><font color=#0000FF>■■<p></font>Blue";
    colors[11] = "<html><font color=#87CEEB>■■</font>SkyBlue";
    colors[12] = "<html><font color=#00008B>■■</font>DarkBlue";
    DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[13];
    for( int i=0 ; i<13 ; i++ ){
      nodes[i] = new DefaultMutableTreeNode( colors[i] );
    }
    nodes[0].add( nodes[1] );
    nodes[0].add( nodes[4] );
    nodes[0].add( nodes[7] );
    nodes[0].add( nodes[10] );
    nodes[1].add( nodes[2] ); 
    nodes[1].add( nodes[3] ); 
    nodes[4].add( nodes[5] ); 
    nodes[4].add( nodes[6] ); 
    nodes[7].add( nodes[8] ); 
    nodes[7].add( nodes[9] ); 
    nodes[10].add( nodes[11] ); 
    nodes[10].add( nodes[12] ); 
    JTree  tree = new JTree( nodes[0] );
    JScrollPane scroll = new JScrollPane( tree );
    tree.addTreeSelectionListener( new CheckColor() );
    pane.add( scroll );
    pane.add( color );
  }
  class CheckColor implements TreeSelectionListener {
    public void valueChanged( TreeSelectionEvent e ){
      TreePath path = e.getPath();
      String text = path.getLastPathComponent().toString();
      text += " ]が選ばれました。";
      color.setText( text );
    }
  } 
}

