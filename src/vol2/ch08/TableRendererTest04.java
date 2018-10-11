package vol2.ch08;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class TableRendererTest04 extends JTableTestBase {
  TableRendererTest04(){
    DefaultTableCellRenderer renderer = new Renderer04();

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    for( int i=0 ; i< getColumnCount() ; i++ ){
      if( i != 1 ){ //画像のカラムはスキップする
        cmodel.getColumn(i).setCellRenderer( renderer );
      }
    }
  }

  class Renderer04 extends DefaultTableCellRenderer {
    Font baseFont;
    Font[] fonts = new Font[6];
    Color[] colors = new Color[6];
    Color[] backcolors = new Color[6];
   
    Renderer04(){
      baseFont = getFont();
      fonts[0] = baseFont.deriveFont( 28.0f );
      fonts[1] = baseFont.deriveFont( 24.0f );
      fonts[2] = baseFont.deriveFont( Font.ITALIC, 20.0f );
      fonts[3] = baseFont.deriveFont( Font.ITALIC, 18.0f );
      fonts[4] = baseFont.deriveFont( Font.PLAIN, 16.0f );
      fonts[5] = baseFont.deriveFont( Font.PLAIN, 14.0f );
      colors[0] = Color.yellow;
      colors[1] = Color.orange;
      colors[2] = Color.red;
      colors[3] = Color.green;
      colors[4] = Color.cyan;
      colors[5] = Color.blue;
      backcolors[0] = new Color( 0xffffcc );
      backcolors[1] = new Color( 0xffcc99 );
      backcolors[2] = new Color( 0xffcccc );
      backcolors[3] = new Color( 0xccffcc );
      backcolors[4] = new Color( 0xccffff );
      backcolors[5] = new Color( 0xccccff );
    }
    @Override
    public Component getTableCellRendererComponent( JTable table, Object value,
                                               boolean isSelected, boolean hasFocus,
                                               int row, int column ) {
      setText( (String)value );
      setHorizontalAlignment( SwingConstants.CENTER );
      setFont( fonts[row] );
      setForeground( colors[row] );
      setBackground( backcolors[row] );
      return( this );
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JTable table = new TableRendererTest04();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 600, 450 );
    frame.setVisible( true );
  }
}
