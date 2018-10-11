package vol2.ch09;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

class TableCellEditorTest04A extends JTable {

  Properties syohinMaster = new Properties();

  TableCellEditorTest04A() {
    super( 8, 2 );

    try{
      FileInputStream syohinMasterFile = new FileInputStream( "syohin.dat" );
      syohinMaster.load( syohinMasterFile );
    }catch( IOException e ){
      System.out.println( e );
    }

    JComboBox comboBox = new JComboBox();
    comboBox.setEditable( true ); //**

    Enumeration en = syohinMaster.elements();
    while( en.hasMoreElements() ){
      String syohin = (String)en.nextElement();
      comboBox.addItem( syohin );
    }
    TableCellEditor editorSyohin = new DefaultCellEditor( comboBox );

    DefaultTableColumnModel cmodel = (DefaultTableColumnModel)getColumnModel();
    TableColumn column0 = cmodel.getColumn( 0 );

    column0.setCellEditor( editorSyohin );
    column0.setHeaderValue( "商品名" );

    TableColumn column1 = cmodel.getColumn( 1 );
    column1.setHeaderValue( "単価" );

    setRowHeight( 20 );
    setRowSelectionAllowed( false );
  } 

  public static void main(String[] args) {
    JFrame frame = new JFrame( "TableCellEditorTest04A" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    JTable table = new TableCellEditorTest04A();
    JScrollPane scroll = new JScrollPane( table );
    frame.getContentPane().add( scroll );
    frame.setSize( 240, 240 );
    frame.setVisible( true );
  }
}

