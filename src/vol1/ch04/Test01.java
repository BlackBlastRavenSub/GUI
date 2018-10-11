package vol1.ch04;
import javax.swing.*;
import java.awt.event.*;

public class Test01 {

  public static void main(String[] args) {
    new Test01();
    try{
      Thread.sleep(10000);
    }
    catch( InterruptedException e ){
      System.out.println( e );
    }
  }
  public Test01(){
    Timer timer = new Timer( 1000, new Tick() );
    timer.start();
  }
  class Tick implements ActionListener {
    public void actionPerformed( ActionEvent e ){
      System.out.print( "*" );
    }
  }
}
