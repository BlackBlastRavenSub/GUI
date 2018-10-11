package vol1.ch01;
import javax.swing.*;

class UITest0 {
   public static void main( String[] args ){
      System.out.println( "System Look & Feel        = "+ UIManager.getSystemLookAndFeelClassName() );
      System.out.println( "CrossPlatform Look & Feel = "+ UIManager.getCrossPlatformLookAndFeelClassName() );
      UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
      System.out.println( lafs.length );
      for( int i=0 ; i< lafs.length ; i++ ){
         System.out.println( lafs[i].getName() +"\t"+ lafs[i].getClassName() );
      }
   }
}

