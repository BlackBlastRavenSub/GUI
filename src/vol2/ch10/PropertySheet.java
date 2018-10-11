package vol2.ch10;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class PropertySheet extends JFrame {

  public static void main( String[] arg ){
    JFrame f = new PropertySheet( "PropertySheet" );
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 300, 150 );
    f.setVisible( true );
  }

  public PropertySheet( String title ){
    super( title );

    JPanel panel = (JPanel)getContentPane();
    JTable2 table = new JTable2( 4, 2 );
    panel.add( table );

    TableColumn column0 = table.getColumnModel().getColumn(0);
    column0.setMaxWidth( 100 );
    
    table.setValueAt( "ファイル名", 0, 0 );

    JLabel label1 = new JLabel( "背景色" );
    label1.setFont( Font.decode( "dialog-italic-24" ) );
    JLabel label2 = new JLabel( "上限値" );
    label2.setFont( Font.decode( "MS UI Gothic-bold-20" ) );
    JLabel label3 = new JLabel( "モード" );
    label3.setFont( Font.decode( "ＭＳ 明朝-bolditalic-18" ) );
    table.setValueAt( label1, 1, 0 );
    table.setValueAt( label2, 2, 0 );
    table.setValueAt( label3, 3, 0 );

    FileField fileField = new FileField( "*.gif;*.jpg", "画像ファイル" );
    ColorSelectItem colorItem = new ColorSelectItem( Color.green );
    JSpinner spinner = new JSpinner();
    JRadioButton radio = new JRadioButton( "透過モード" );
    table.setValueAt( fileField, 0, 1 );
    table.setValueAt( colorItem, 1, 1 );
    table.setValueAt( spinner,   2, 1 );
    table.setValueAt( radio,     3, 1 );
  }
}
