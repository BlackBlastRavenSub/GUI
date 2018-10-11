package vol2.ch01;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MemoPad extends JFrame {
  JPopupMenu pmenu = new JPopupMenu();
  JTextArea ta;
  MemoPad frame;

  public static void main(String[] args) {
    JFrame frame = new MemoPad( "MemoPad" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 500, 400 );
    frame.setVisible( true );
  }
  MemoPad( String title ){
    super( title );
    frame = this;
    JPanel pane = (JPanel)getContentPane();

    ta = new JTextArea();
    JScrollPane scr = new JScrollPane( ta );
    pane.add( scr );

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar( menuBar );

    JMenu file = new JMenu( "ファイル" );
    menuBar.add( file );
    JMenu edit = new JMenu( "編集" );
    menuBar.add( edit );

    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );

    ta.addMouseListener( new CheckPopup() );

    Action newAction  = new NewAction( 
                  "<html>ファイルを<p><img src=file:./image/new.gif<p>新規作成します" );

    Action loadAction = new LoadAction(
                  "<html>ファイルを<p><img src=file:./image/open.gif<p>開きます" );
    Action saveAction = new SaveAction(
                  "<html>ファイルを<p><img src=file:./image/save.gif<p>保管します" );

    file.add( newAction );
    pmenu.add( newAction );
    tool.add( newAction );

    file.addSeparator();
    pmenu.addSeparator();
    tool.addSeparator();

    file.add( loadAction );
    pmenu.add( loadAction );
    tool.add( loadAction );

    file.addSeparator();
    pmenu.addSeparator();
    tool.addSeparator();

    file.add( saveAction );
    pmenu.add( saveAction );
    tool.add( saveAction );

    //------------------------------ 編集メニュー
    Action cutAction   = new CutAction( "切り取り" );
    Action copyAction  = new CopyAction( "コピー" );
    Action pasteAction = new PasteAction( "貼り付け" );

    edit.add( cutAction );
    edit.add( copyAction );
    edit.add( pasteAction );

    InputMap  inputMap  = pane.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap actionMap = pane.getActionMap();

    KeyStroke cutKey   = KeyStroke.getKeyStroke( "shift DELETE" );
    inputMap.put( cutKey, cutAction );
    actionMap.put( cutAction, cutAction );

    KeyStroke copyKey  = KeyStroke.getKeyStroke( "ctrl  INSERT" );
    inputMap.put( copyKey, copyAction );
    actionMap.put( copyAction, copyAction );

    KeyStroke pasteKey = KeyStroke.getKeyStroke( "shift INSERT" );
    inputMap.put( pasteKey, pasteAction );
    actionMap.put( pasteAction, pasteAction );


  }
  //--------------------------------- サブクラス
  class NewAction extends AbstractAction{
    NewAction( String text ){ super(text); }
    public void actionPerformed( ActionEvent e ){
      ta.setText( "" );
    }
  }
  class LoadAction extends AbstractAction{
    LoadAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      JFileChooser fileChooser = new JFileChooser( "." );
      int ret = fileChooser.showOpenDialog( frame );
      File file = fileChooser.getSelectedFile();      
      if( ret != JFileChooser.APPROVE_OPTION || file==null ) return; 
      frame.setTitle( file.getName() ); //**
      try {
        FileReader reader = new FileReader( file );
        ta.read( reader, new PlainDocument() );
      }
      catch ( FileNotFoundException ex ) {
      }
      catch ( IOException ex ) {
      }
    }
  }
  class SaveAction extends AbstractAction{
    SaveAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      JFileChooser fileChooser = new JFileChooser( "." );
      int ret = fileChooser.showSaveDialog( frame );
      File file = fileChooser.getSelectedFile();      
      if( ret != JFileChooser.APPROVE_OPTION || file==null ) return; 
      frame.setTitle( file.getName() ); //**
      try {
        FileWriter writer = new FileWriter( file );
        ta.write( writer );
        writer.close(); //** This statement is NEEDED!
      }
      catch ( FileNotFoundException ex ) {
      }
      catch ( IOException ex ) {
      }
    }
  }

  class CutAction extends AbstractAction{
    CutAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      ta.cut();
    }
  }
  class CopyAction extends AbstractAction{
    CopyAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      ta.copy();
    }
  }
  class PasteAction extends AbstractAction{
    PasteAction( String text ){ super(text); }
    @Override
    public void actionPerformed( ActionEvent e ){
      ta.paste();
    }
  }

  class CheckPopup extends MouseAdapter {
    @Override
    public void mousePressed( MouseEvent e ){
      if( SwingUtilities.isRightMouseButton( e ) ){
        pmenu.show( e.getComponent(), e.getX(), e.getY() );
      }
    }
  }
}

