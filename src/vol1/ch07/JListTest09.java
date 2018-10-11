package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class JListTest09 extends JFrame {
  JTextArea ta;

  public static void main(String[] args) {
    JListTest09 w = new JListTest09( "JListTest09" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 280 );
    w.setVisible( true );
  }
  public JListTest09( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BorderLayout() );

    ta = new JTextArea();
    JScrollPane scr = new JScrollPane( ta );

    String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777" };
    JList list = new JList( choice );
    list.addListSelectionListener( new MyListSelect() );
    list.setSelectionModel( new MyListSelectionModel() );

    pane.add( list, BorderLayout.NORTH );
    pane.add( scr, BorderLayout.CENTER );

    ta.setBorder( new TitledBorder( "選択された項目" ) );
    list.setBorder( new LineBorder( Color.black, 2 ) );
  }
  class MyListSelect implements ListSelectionListener {
    public void valueChanged( ListSelectionEvent e ){

      JList li = (JList)e.getSource();
      ListModel model = li.getModel();

      if( e.getValueIsAdjusting()==false ){ 
        int[] selects = li.getSelectedIndices();

        int n = li.getSelectedIndices().length;
        ta.setText( "" );
        for( int i=0 ; i< n ; i++ ){
          String select1 = (String)model.getElementAt( selects[i] );
          ta.append( select1 +"\n" );
        }
      }
    }
  }
  class MyListSelectionModel extends DefaultListSelectionModel{

    public void setSelectionInterval( int index0, int index1 ) {
      if( isSelectedIndex( index0 ) ){
        removeSelectionInterval( index0, index1 );
      }
      else {
        addSelectionInterval( index0, index1 );
      }
    }
    
  }
}
