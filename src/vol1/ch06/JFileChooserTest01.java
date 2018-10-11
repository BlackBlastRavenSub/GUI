package vol1.ch06;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JFileChooserTest01 extends JFrame {

  ImageIcon icon = null;
  JLabel label = new JLabel();

  public static void main(String[] args) {
    JFileChooserTest01 w = new JFileChooserTest01( "JFileChooserTest01" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 350, 300 );
    w.setVisible( true );
  }
  JFileChooserTest01( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();

    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new LoadImageFile( "画像ファイルをオープン" ) );

    pane.add( label, BorderLayout.CENTER );
  }
  class LoadImageFile extends AbstractAction {
    LoadImageFile( String text ){ super(text); }
    public void actionPerformed( ActionEvent e ){
      JFileChooser fileChooser = new JFileChooser( "." );
      fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
      fileChooser.setDialogTitle( "画像選択" );

      int ret = fileChooser.showOpenDialog( label );

      if( ret != JFileChooser.APPROVE_OPTION ) return;

      String fileName = fileChooser.getSelectedFile().getAbsolutePath();
      icon = new ImageIcon( fileName );
      label.setIcon( icon );
    }
  }
}
