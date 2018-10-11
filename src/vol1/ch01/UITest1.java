package vol1.ch01;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import com.sun.java.swing.plaf.motif.*;
import com.sun.java.swing.plaf.windows.*;

class UITest1 extends JFrame implements ActionListener {

  UIManager.LookAndFeelInfo[] laf; 

  public static void main(String[] args) {
    UITest1 w = new UITest1( "UI Test 1" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
  }
  UITest1( String title ){
    super( title );
    JToolBar toolBar = new JToolBar(); 
    getContentPane().add( toolBar, BorderLayout.NORTH ); 
    JSlider slider = new JSlider();
    getContentPane().add( slider, BorderLayout.SOUTH );

    laf = UIManager.getInstalledLookAndFeels();

    JButton[] b = new JButton[ laf.length ];
    for( int i=0 ; i< laf.length ; i++ ){
       String text = i +" "+ laf[i].getName();
       b[i] = new JButton( text ); 
       toolBar.add( b[i] ); 
       b[i].addActionListener( this );
    }
  }

  public void actionPerformed( ActionEvent ev ){
    JButton b = (JButton)ev.getSource();
    String text = b.getText();
    int index = (int)(text.charAt(0)) - '0'; 
    try{ 
      UIManager.setLookAndFeel( laf[index].getClassName() ); 
      SwingUtilities.updateComponentTreeUI( this ); 
    }catch ( UnsupportedLookAndFeelException ex ) { 
      System.out.println( ex ); 
    }
    catch ( ClassNotFoundException ex ) { 
      System.out.println( ex ); 
    }
    catch ( InstantiationException ex ) { 
      System.out.println( ex ); 
    }
    catch ( IllegalAccessException ex ) { 
      System.out.println( ex ); 
    }
  }
}
