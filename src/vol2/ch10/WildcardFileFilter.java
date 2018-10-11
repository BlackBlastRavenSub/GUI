package vol2.ch10;
import javax.swing.*;
import java.io.*;

public class WildcardFileFilter extends javax.swing.filechooser.FileFilter {
  String wildcard;
  String description;

  public WildcardFileFilter( String wildcard, String description ){
    
    this.wildcard = wildcardConvert( wildcard );
    this.description = description;
  }
  
  String wildcardConvert( String wildcard ){
    wildcard = wildcard.replace( ';', '|' );
    wildcard = wildcard.replace( '*', '/' );
    wildcard = wildcard.replaceAll( "\\.", "\\\\." );
    wildcard = wildcard.replaceAll( "/", ".*" );
    wildcard = wildcard.replace( '?', '.' );
    return( wildcard );
  }
  @Override    
  public boolean accept( File f ) {
    if( f.isDirectory() )  return true; // これを行わないと他のディレクトリーに移れない
    String name = f.getName().toLowerCase();
    
    boolean matche =name.matches( wildcard );
    if( matche ) return true;
    else         return false;
  }

  public String getDescription() {
    return description;
  }
}
