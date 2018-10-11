package vol2.ch03;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class MDI07 extends JFrame {
  JInternalFrame frame1;

  MDI07(){
    super( "Internal frame" );
    JDesktopPane desktop = new JDesktopPane();
    getContentPane().add( desktop, BorderLayout.CENTER );

    frame1 = new JInternalFrame( "drawing frame", true, true, true, true );
    frame1.setBounds( 10, 10, 400, 300 );
    frame1.setVisible(true);
    frame1.setFrameIcon( new ImageIcon( "pen.gif" ) );
    desktop.add( frame1 );

    MyMouseCheck mouseCheck = new MyMouseCheck();
    frame1.addMouseListener( mouseCheck );
    frame1.addMouseMotionListener( mouseCheck );

    JMenuBar menuBar = new JMenuBar();
    frame1.setJMenuBar( menuBar );
    JMenu edit = new JMenu( "Edit" );
    menuBar.add( edit );
    JMenuItem clear = new JMenuItem( "clear" );
    clear.addActionListener( new ClearAction() );
    edit.add( clear );
  }

  public static void main( String[] args ){
    JFrame frame = new MDI07();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }

  class MyMouseCheck extends MouseInputAdapter {
    int x0 = 0;
    int y0 = 0;
    @Override
    public void mousePressed( MouseEvent e ){
      x0 = e.getX();
      y0 = e.getY();
    }
    @Override
    public void mouseDragged( MouseEvent e ){
       int x = e.getX();
       int y = e.getY();
       JInternalFrame f = (JInternalFrame)e.getSource();
       // 単純に getGraphics() ではダメ
       Graphics g = f.getGraphics();
       g.drawLine( x0, y0, x, y );
       x0 = x;
       y0 = y;
    }
  }
  class ClearAction implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ){
      Component pane = frame1.getContentPane();
      Dimension dim = pane.getSize();
      pane.getGraphics().clearRect( 0, 0, dim.width, dim.height );
    }
  }
}
