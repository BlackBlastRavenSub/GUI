package vol1.ch01;

import javax.swing.*;
import java.awt.*;

public class Layout03B extends JFrame {
    public static void main(String[] args) {
        Layout03B w = new Layout03B( "Layout03" );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        w.setSize( 250, 300 );
        w.setVisible( true );
    }
    public Layout03B( String title ){
        super( title );
        JPanel pane = (JPanel)getContentPane();
        pane.setLayout( new GridLayout( 10, 5 ) );

        for( int i=0 ; i<50 ; i++ ){
            pane.add( new JButton( Integer.toString(i) ) );
        }
    }
}
