package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest03A extends JFrame {
  JTextField tf;

  public static void main(String[] args) {
    JComboTest03A w = new JComboTest03A( "JComboTest03A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 220 );
    w.setVisible( true );
  }
  public JComboTest03A( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();

    tf = new JTextField();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };
    JComboBox combo = new JComboBox( choice );
    combo.setAction( new MyComboAction() );
    combo.setEditable( true );

    pane.add( combo, BorderLayout.NORTH );
    pane.add( tf, BorderLayout.SOUTH );

    tf.setBorder( new TitledBorder( "選択された項目" ) );
    combo.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyComboAction extends AbstractAction {
    MyComboAction(){
      putValue( Action.NAME, "開く" ); // これは設定しても無視される
      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) ); // これは設定しても無視される
      putValue( Action.SHORT_DESCRIPTION, "ツールチップ" ); //Actionクラスでの ツールチップの設定は有効である
      //setEnabled( true ); Actionクラスでの setEnabled()による指定は有効である
      //setEnabled( false ); Actionクラスでの setEnabled()による指定は有効である
    }

    @Override
    public void actionPerformed( ActionEvent e ){
      System.out.println( e );
      JComboBox combo = (JComboBox)e.getSource();
      int selectNo = combo.getSelectedIndex();
      String select = (String)combo.getSelectedItem();
      tf.setText( selectNo +": "+ select );
    }
  }
}
