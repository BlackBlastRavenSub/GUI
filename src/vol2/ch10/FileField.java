package vol2.ch10;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class FileField extends JPanel implements ActionListener {
  private JTextField field = new JTextField( 200 );
  private JButton button = new JButton( "参照" );
  private JFileChooser chooser;
  private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

  public FileField( String wildcard, String descrption ){
    WildcardFileFilter fileFilter = new WildcardFileFilter( wildcard, descrption );
    chooser = new JFileChooser();
    chooser.setFileFilter( fileFilter );

    setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
    add( field );
    add( button );
    button.addActionListener( this );
  }

  public void setSelectedFileName( String selectedFileName ){
    if( selectedFileName == null ){
      chooser.setCurrentDirectory( new File( "." ) );
      return;
    }
    field.setText( selectedFileName );
    chooser.setSelectedFile( new File( selectedFileName ) );
  }
  public String getSelectedFileName(){
    return( field.getText() );
  }
  
  public void addActionListener( ActionListener listener ){
    listeners.add( listener );
  }
  @Override
  public void actionPerformed( ActionEvent e ){
    int ret = chooser.showOpenDialog( this );
    if( ret == JFileChooser.APPROVE_OPTION ){
      File selectedFile = chooser.getSelectedFile();
      String selectedFileName = selectedFile.getAbsolutePath();
      field.setText( selectedFileName );
      ActionEvent event = new ActionEvent( 
        this, ActionEvent.ACTION_PERFORMED, selectedFileName );
      for(ActionListener ac : listeners ) {
        ac.actionPerformed( event );
      }
    }
  }
}
