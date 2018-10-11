package vol1.ch08;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.net.URI; 
import java.net.URL;
import javax.swing.*; 

public class SplashWindowTest extends JFrame
{
  public static void main(String[] arguments)
  {
    new SplashWindowTest();
  }

  public SplashWindowTest()
  {
    SplashScreen splashScreen = SplashScreen.getSplashScreen();
    if(splashScreen == null) return;
    try{
      URL url = new File("splash.png").toURI().toURL();
      splashScreen.setImageURL(url);
    }
    catch(Exception e) {
    }
    Dimension  size     = splashScreen.getSize();
    Graphics graphics = splashScreen.createGraphics();
    graphics.setColor(Color.RED);

    int width = 0;
    int height = 0;
    BufferedImage b = null;
    try
    {
      b = ImageIO.read(getClass().getResource("bar.png"));
      width = b.getWidth();
      height = b.getHeight();
    }
    catch(Exception e) {
    }

    int offset_y = size.height - height - 8 ;
    for(int offset_x = 0; offset_x < size.width; offset_x += width) {
      for(int i = 0; i < width; i++) {
        for(int j = 0; j < height; j++) {
          int c = b.getRGB(i,j);
          if ( c == 0xFFFFFF ) continue;
          graphics.setColor(new Color(c));
          graphics.drawLine(
              offset_x + i,offset_y + j, offset_x + i, offset_y + j);
        }
        splashScreen.update();
      }
      try {
        Thread.sleep(5); 
      }
      catch(InterruptedException e) {
      }
    }
    graphics.dispose();
  }
}