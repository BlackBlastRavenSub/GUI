package vol1.ch01;

import javax.swing.*;
import java.awt.*;

public class Layout02B extends JFrame{
    public static void main(String[] args) {
        Layout02 w = new Layout02( "Layout02" );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        w.setSize( 250, 300 );
        w.setVisible( true );
    }
    public Layout02B( String title ){
        super( title );
        JPanel pane = (JPanel)getContentPane();
        pane.setLayout( new FlowLayout() );

        for( int i=0 ; i<50 ; i++ ){
            pane.add( new JButton( Integer.toString(i) ) );
        }
    }
}
