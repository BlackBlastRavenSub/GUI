package vol2.ch10;
import java.awt.*;

public class FontFamilyNames {
  public static void main( String[] arg ){
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fontFamilyName = ge.getAvailableFontFamilyNames();
    for( String s :  ge.getAvailableFontFamilyNames() ){
      System.out.println( s );
    }
  }
}
