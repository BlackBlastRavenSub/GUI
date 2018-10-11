package vol1.ch08;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class SystemTrayTest {

    public static void main(String[] args) {
        try {
            new SystemTrayTest();
        } 
	catch (Exception e) {
	}
    }

    public SystemTrayTest() throws IOException, AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        TrayIcon icon = new TrayIcon(ImageIO.read(new File("duke-icon.png")));
	icon.setToolTip( "システムトレイに入るようになりました" );
        tray.add(icon);
    }
}
