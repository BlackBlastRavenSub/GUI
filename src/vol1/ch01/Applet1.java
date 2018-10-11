package vol1.ch01;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Applet1 extends Applet {
    Applet background;
    
    public void init() {
	Button red = new Button("red");
	red.addActionListener(new Red());
	add(red);
	Button blue = new Button("blue");
	blue.addActionListener(new Blue());
	add(blue);
	background = this;
    }
    class Red implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    background.setBackground(Color.red);
	}
    }
    class Blue implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    background.setBackground(Color.blue);
	}
    }
}
