package vol2.ch02;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JComboTest06A extends JFrame {
  JPanel pane;

  public static void main(String[] args) {
    JComboTest06A w = new JComboTest06A( "JComboTest06A" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 300 );
    w.setVisible( true );
  }
  public JComboTest06A( String title ) {  
    super( title );
    pane = (JPanel)getContentPane();

    String[] choice = { "0000", "1111", "2222", "3333", "4444", "5555" };

    JComboBox combo = new JComboBox( choice );
    combo.addActionListener( new ModifyAction() );

    pane.add( combo, BorderLayout.NORTH );

  }

  class ModifyAction implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ){

      JComboBox combo = (JComboBox)e.getSource();

      int index =  combo.getSelectedIndex();
      if( index < 0 ) return;

      DefaultComboBoxModel model = (DefaultComboBoxModel)combo.getModel();
      String select = (String)model.getElementAt( index );
      JTextField tx = new JTextField( select );

      Object[]  obj = { tx };
      Object[] option = { "前に挿入", "次に挿入", "削除", "取消" };
      int ans = JOptionPane.showOptionDialog( pane, obj, "リスト内容の変更",
                                JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.INFORMATION_MESSAGE, null,
                                option, option[0] );

      String updated = tx.getText();

      //変更メソッドは、DefaultComboBoxModel にはない
      // if( ans==0 ){ //変更
      //  model.set( index, updated );
      //}
      if( ans==0 ){ //前に挿入
        model.insertElementAt( updated, index );
      }
      if( ans==1 ){ //次に挿入
        model.insertElementAt( updated, index+1 );
      }
      if( ans==2 ){ //削除
        model.removeElementAt( index );
      }
    }
  }
}
