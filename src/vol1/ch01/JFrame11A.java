package vol1.ch01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrame11A extends JFrame {
  JPanel contentPane;
  public static void main(String[] args) {
    new JFrame11A( "JFrame11A" );
  }
  public JFrame11A( String title ){
    super( title );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );
    JMenu file = new JMenu( "File" );
    JMenu edit = new JMenu( "Edit" );
    JMenu help = new JMenu( "Help" );
    menuBar.add( file );
    menuBar.add( edit );
    menuBar.add( help );

    contentPane = (JPanel)getContentPane();
    contentPane.setToolTipText( "ContentPane は Swing コンポーネントです" );

    menuBar.setToolTipText( "ここはメニューバーです" );

    setSize(400, 300);
    setVisible(true);
  }
}
