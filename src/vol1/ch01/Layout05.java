package vol1.ch01;
import javax.swing.*;
import java.awt.*;
/* 定数をスタティックインポートして記述を簡素にした */
import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.WEST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;

public class Layout05 extends JFrame{

  public static void main( String[] args ){
    Layout05 w = new Layout05();
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setTitle( "Layout05" );
    w.setVisible( true );
  }

  Layout05() {
    SpringLayout layout = new SpringLayout();
    Container c =  getContentPane();
    c.setLayout( layout );
    JLabel label1 = new JLabel( "<html><h1>Java</h1>" );
    JLabel label2 = new JLabel( "Swing" );
    JLabel label3 = new JLabel( "JDK" );
    c.add( label1 );
    c.add( label2 ); 
    c.add( label3 );

    layout.putConstraint( NORTH, label1, 50, NORTH, c );
    layout.putConstraint( WEST, label1, 80, WEST, c );
    layout.putConstraint( NORTH, label2, 20, NORTH, c );
    layout.putConstraint( WEST, label2, 30, EAST, label1 );
    layout.putConstraint( NORTH, label3, 70, SOUTH, label2 );
    layout.putConstraint( WEST, label3, 0, WEST, label2 );

  }
}