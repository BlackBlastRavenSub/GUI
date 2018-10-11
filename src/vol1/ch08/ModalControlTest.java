package vol1.ch08;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ModalControlTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new ModalControlTest();
                }
            });
    }

    public ModalControlTest() {
        init("Document 1", 200, 100);
        init("Document 2", 500, 100);
    }

    private void init(String title, int x, int y) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, 100, 75);
        JButton button = new JButton(title);
        frame.add(button);
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton)e.getSource();
                    showDialog(source);
                }
            });
        frame.setVisible(true);
    }

    private void showDialog(JButton parent) {
        JOptionPane pane = new JOptionPane(parent.getText(),
                                           JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(parent, parent.getText());
//        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
        dialog.setVisible(true);
    }
}
