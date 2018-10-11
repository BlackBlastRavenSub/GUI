package vol2.ch05;
import javax.swing.*;
import java.awt.*;

class JTableTest02B extends JFrame {

  public static void main(String[] args) {
    JFrame w = new JTableTest02B( "JTableTest02B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 180 );
    w.setVisible( true );
  }
  
  JTableTest02B( String title ) {
    super( title );
    JTable table = new JTable02B( 10, 60 );
    JScrollPane scr = new JScrollPane( table );
    getContentPane().add( scr );
  }
  
  class JTable02B extends JTable{
    JTable02B( int row, int column ){
      super( row, column );
    }
   @Override
    public boolean getScrollableTracksViewportWidth() {
      Container c = getParent();
      if( c instanceof JViewport ) {
        int viewportWidth = c.getWidth();
        int tableWidth = getPreferredSize().width;
        System.out.println( tableWidth );
        if( viewportWidth < tableWidth ){
          return( false );// 水平スクロールバーが付く
        }
      }
      return( true ); 
    }
  }
}
