package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class JListTest07 extends JFrame {
  JPanel pane;

  public static void main(String[] args) {
    JListTest07 w = new JListTest07( "JListTest07" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 400, 300 );
    w.setVisible( true );
  }
  public JListTest07( String title ) {  
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

        int index =  list.getSelectedIndex();
        if( index < 0 ) return;

        DefaultListModel model = (DefaultListModel)list.getModel();
        String select = (String)model.get( index );
        JTextField tx = new JTextField( select );

        Object[]  obj = { tx };
        Object[] option = { "変更", "前に挿入", "次に挿入", "削除", "取消" };
        int ans = JOptionPane.showOptionDialog( pane, obj, "リスト内容の変更",
                                  JOptionPane.DEFAULT_OPTION,
                                   JOptionPane.INFORMATION_MESSAGE, null,
                                  option, option[0] );

        list.clearSelection();

        String updated = tx.getText();
        if( ans==0 ){ //変更
          model.set( index, updated );
        }
        if( ans==1 ){ //前に挿入
          model.insertElementAt( updated, index );
        }
        if( ans==2 ){ //次に挿入
          model.insertElementAt( updated, index+1 );
        }
        if( ans==3 ){ //削除
          model.remove( index );
        }
      }
    }
  }
}
