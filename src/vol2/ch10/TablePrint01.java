package vol2.ch10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class TablePrint01 extends JFrame implements ActionListener {
  JTable4 table;

  public static void main(String[] args){
    JFrame f = new TablePrint01("Table Print 01");
    f.setDefaultCloseOperation(3);
    f.setSize( 450, 600 );
    f.setVisible( true );
  }

  public TablePrint01( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    JButton printButton = new JButton( "印刷" );
    printButton.addActionListener( this );
    pane.add( printButton, BorderLayout.NORTH );

    table = new JTable4( 8, 5 );
    JPanel tablePanel = new TableTest4( table );
    pane.add( tablePanel, BorderLayout.CENTER );
  }
  @Override
  public void actionPerformed( ActionEvent e ){
    try{
      table.print();
    }
    catch( PrinterException exc ){
      exc.printStackTrace();
    }
  }
}
