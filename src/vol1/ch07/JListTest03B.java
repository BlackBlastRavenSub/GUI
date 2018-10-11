package vol1.ch07;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class JListTest03B extends JFrame {
  JTextArea ta;

  public static void main(String[] args) {
    JListTest03B w = new JListTest03B( "JListTest03B" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 280 );
    w.setVisible( true );
  }
  public JListTest03B( String title ) {  
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new BorderLayout() );

    ta = new JTextArea();
    JScrollPane scr = new JScrollPane( ta );

    String[] choice = { "1111", "2222", "3333", "4444", "5555", "6666", "7777" };
    JList list = new JList( choice );
    list.addListSelectionListener( new MyListSelect() );
    list.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );

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
        Object[] selectGroup1 = li.getSelectedValues();
        int[]    selectGroup2 = li.getSelectedIndices();

        int n = li.getSelectedIndices().length;
        System.out.println( "選択されている項目の数は "+ n );

        ta.setText( "" );
        for( int i=0 ; i< selectGroup1.length ; i++ ){
          String select1 = (String)selectGroup1[i];
          String select2 = (String)model.getElementAt( selectGroup2[i] );
          ta.append( select1 +" "+ select2 +"\n" );
        }
      }
    }
  }
}
