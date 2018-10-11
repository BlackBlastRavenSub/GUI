package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest06 extends JFrame {
  JPanel pane;

  public static void main(String[] args) {
    JListTest06 w = new JListTest06( "JListTest06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 240, 300 );
    w.setVisible( true );
  }
  public JListTest06( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "Java", "C", "C++", "SmallTalk", "Lisp", "Prolog", "Pascal" };
    DefaultListModel listModel = new DefaultListModel();
    for( int i=0 ; i< choice.length ; i++ ){
      listModel.addElement( choice[i] );
    }

    JList list = new JList( listModel );
    list.addListSelectionListener( new MyListSelect() );

    pane.add( list, BorderLayout.CENTER );
    list.setBorder( new TitledBorder( "選択リスト" ) );
  }
  class MyListSelect implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){

      JList list = (JList)e.getSource();
      if( e.getValueIsAdjusting()==false ){ 
        System.out.println( list.getModel() );

        DefaultListModel model = (DefaultListModel)list.getModel(); //***

        int index =  list.getSelectedIndex();
        String select = (String)model.get(index);
        JTextField tx = new JTextField( select );
        Object[]  obj = { tx };
        int ans = JOptionPane.showConfirmDialog( pane, obj, "リスト内容の変更",
                                     JOptionPane.OK_CANCEL_OPTION );
        if( ans==0 ){ //OK
          String updated = tx.getText();
          model.set( index, updated );
        }
      }
    }
  }
}
