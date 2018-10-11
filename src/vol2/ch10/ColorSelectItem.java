package vol2.ch10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorSelectItem extends JPanel implements ActionListener, MouseListener {

  JTextField field = new JTextField( 250 );
  JButton button = new JButton( "選択" );
  ColorTable table = new ColorTable();
  Color color;
  JDialog dialog;

  public ColorSelectItem( Color initialColor ){
    color = initialColor;
    field.setBackground( color );
    field.setEditable( false );
    
    setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
    add( field );
    add( button );
    button.addActionListener( this );
    table.addMouseListener( this );
  }
  public Color getColor(){
    return( color );
  }
  @Override
  public void actionPerformed( ActionEvent e ){
    dialog = new JDialog( (Frame)null, true );
    dialog.getContentPane().add( table );
    dialog.setUndecorated( true );
    Point p1 = button.getLocationOnScreen();
    dialog.setBounds( p1.x, p1.y, 16*8, 16*3 );
    dialog.setVisible( true );
  }
  @Override
  public void mousePressed( MouseEvent e ){
    color = table.getColor();
    field.setBackground( color );
    dialog.dispose();
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
