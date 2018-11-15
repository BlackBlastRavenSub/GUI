package ex8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ActionTest01B extends JFrame implements ActionListener {

    Timer timer;
    int time;
    int interval;
    ArrayList<Integer> timelist = new ArrayList();
    ArrayList<Integer> intervallist = new ArrayList();

    public static void main(String[] args) {
        ActionTest01B w = new ActionTest01B("MouseEventTest05");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(350, 250);
        w.setVisible(true);
    }

    public ActionTest01B(String title) {
        super(title);
        JPanel panel = (JPanel) getContentPane();
        timer = new Timer(1000, this);
        panel.addMouseListener(new MouseCheck());
    }

    public void actionPerformed(ActionEvent e) {
        time++;
        interval++;
        System.out.println(time);
    }

    class MouseCheck extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                timer.start();
            }
            if (SwingUtilities.isMiddleMouseButton(e)) {

            }
            if (SwingUtilities.isRightMouseButton(e)) {
                timer.stop();
                timelist.add(time);
                intervallist.add(interval);
                interval = 0;
                System.out.println("現在のタイムは" + time + "、前回との間隔は" + interval + "です");
                System.out.println("これまでの値、タイムと間隔は");
                for (int i = 0; i < timelist.size(); i++) {
                    System.out.println(timelist.get(i) + "," + intervallist.get(i));
                }
            }
        }
    }
}
