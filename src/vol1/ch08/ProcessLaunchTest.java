package vol1.ch08;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;

public class ProcessLaunchTest extends JFrame {
  JButton btn1 = null;
  JButton btn2 = null;
  JButton btn3 = null;
  JButton btn4 = null;
  JButton btn5 = null;
  JButton btn6 = null;

  public static void main(String[] args) {
    ProcessLaunchTest w = new ProcessLaunchTest( "ProcessLaunchTest" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 250, 450 );
    w.setVisible( true );
  }
  public ProcessLaunchTest( String title ){
    super( title );
    JPanel pane = (JPanel)getContentPane();
    pane.setLayout( new FlowLayout() );

    Action action = new ButtonAction1();
    action.putValue( Action.NAME, "Desktop Class / browse" );
    btn1 = new JButton( action );
    action = new ButtonAction2();
    action.putValue( Action.NAME, "Desktop Class / mail" );
    btn2 = new JButton( action );
    action = new ButtonAction3();
    action.putValue( Action.NAME, "Desktop Class / edit" );
    btn3 = new JButton( action );
    action = new ButtonAction4();
    action.putValue( Action.NAME, "Desktop Class / print" );
    btn4 = new JButton( action );
    action = new ButtonAction5();
    action.putValue( Action.NAME, "Process Builder Class / Run" );
    btn5 = new JButton( action );
    action = new ButtonAction6();
    action.putValue( Action.NAME, "Process Builder Class / Std Output" );
    btn6 = new JButton( action );
    pane.add(btn1);
    pane.add(btn2);
    pane.add(btn3);
    pane.add(btn4);
    pane.add(btn5);
    pane.add(btn6);
  }
  class ButtonAction1 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
    Desktop desktop = Desktop.getDesktop();
      try {
        desktop.browse( new URI("http://www.yahoo.co.jp/") );
      } 
      catch (Exception e) {
      }
    }
  }
  class ButtonAction2 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
    Desktop desktop = Desktop.getDesktop();
      try {
        desktop.mail( new URI("mailto:info@example.com") );
      } 
      catch (Exception e) {
      }
    }
  }
  class ButtonAction3 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
    Desktop desktop = Desktop.getDesktop();
      try {
	      desktop.edit(new File("test.txt"));
      } 
      catch (Exception e) {
      }
    }
  }
  class ButtonAction4 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
    Desktop desktop = Desktop.getDesktop();
      try {
	      desktop.print( new File("test.txt") );
      } 
      catch (Exception e) {
      }
    }
  }
  class ButtonAction5 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
	ProcessBuilder builder = new ProcessBuilder("/Applications/iPhoto.app/Contents/MacOS/iPhoto", "");
	try {
          Process process = builder.start();
	}
	catch(Exception e) {
	}
    }
  }
  class ButtonAction6 extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
	ProcessBuilder builder = new ProcessBuilder("ls", "-l");
	InputStream stream = null;
	try {
          Process process = builder.start();
          stream = process.getInputStream();
          while ( true ) {
            int c = stream.read();
            if (c == -1) break;
            System.out.print((char)c);
          }
	}
	catch(Exception e) {
	}
	finally {
	  try {
            stream.close();
          } catch(Exception e) {}
	}
    }
  }
}
