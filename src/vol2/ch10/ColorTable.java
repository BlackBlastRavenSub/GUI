package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ColorTable extends JTable implements MouseListener {
  Color selectedColor;
  JDialog dialog;

  Color[][] color = 
  { {
      new Color(255,0,0), new Color(255,255,0), 
      new Color(0,255,0), new Color(0,255,255),
      new Color(0,0,255), new Color(255,0,255), 
      new Color(255,255,255), new Color(0,0,0)
    },{
      new Color(192,0,0), new Color(192,192,0), 
      new Color(0,192,0), new Color(0,192,192),
      new Color(0,0,192), new Color(192,0,192), 
      new Color(192,192,192), new Color(64,64,64)
  },{
      new Color(127,0,0), new Color(127,127,0), 
      new Color(0,127,0), new Color(0,127,127),
      new Color(0,0,127), new Color(127,0,127), 
      new Color(127,127,127), new Color(127,127,127)
  } };

  public ColorTable(){
    super( 3, 8 );

    ColorTableRenderer renderer = new ColorTableRenderer();
    for( int i = 0 ; i< getColumnCount() ; i++ ){
      TableColumn column = getColumnModel().getColumn(i);
      column.setCellRenderer( renderer );
      column.setMinWidth( 16 );
    }
    addMouseListener( this );
  }

  class ColorTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent( 
      JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column ){
      setBackground( color[row][column] );
      return( this );
    }
  }

  public Color getColor(){
    return( selectedColor );
  }
  @Override
  public void mousePressed( MouseEvent e ){
    int row = getSelectedRow();
    int column = getSelectedColumn();
    selectedColor = color[row][column];
  }
  @Override
  public void mouseReleased( MouseEvent e ){}
  @Override
  public void mouseClicked( MouseEvent e ){}
  @Override
  public void mouseEntered( MouseEvent e ){}
  @Override
  public void mouseExited( MouseEvent e ){}

}
