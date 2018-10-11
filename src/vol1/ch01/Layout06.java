package vol1.ch01;
import java.awt.*;
import javax.swing.*;

public class Layout06 extends JFrame {

  public static void main( String[] args ) {
    Layout06 w = new Layout06( "Layout06" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 500,250 );
    w.setVisible( true );
  }

  public Layout06( String title) {
    super( title );

    JLabel label1 = new JLabel( "Label1" );
    JLabel label2 = new JLabel( "Label2" );
    JLabel label3 = new JLabel( "Label3" );
    JLabel label4 = new JLabel( "L_a_b_e_l_4" );
    JTextField field1 = new JTextField( "Field1" );
    JTextField field2 = new JTextField( "Field2" );
    JTextField field3 = new JTextField( "Field3" );
    JButton button1 = new JButton( "Button1" );
    JButton button2 = new JButton( "Button2" );
    JButton button3 = new JButton( "Button3" );
    JButton button4 = new JButton( "Button4" );
    JCheckBox check1 = new JCheckBox( "CHECK1" );
    JCheckBox check2 = new JCheckBox( "CHECK2" );
    JCheckBox check3 = new JCheckBox( "CHECK3" );
    JCheckBox check4 = new JCheckBox( "CHECK4" );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(label1)
        .addComponent(label2)
        .addComponent(label3)
        .addComponent(label4))
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(field1)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup()
            .addComponent(check1)
            .addComponent(check2))
          .addGroup(layout.createParallelGroup()
            .addComponent(check3)
            .addComponent(check4)))
        .addComponent(field2)
        .addComponent(field3))
      .addGroup(layout.createParallelGroup()
        .addComponent(button1)
        .addComponent(button2)
        .addComponent(button3)
        .addComponent(button4))
      );

    layout.setVerticalGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(label1)
        .addComponent(field1)
        .addComponent(button1))
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(label2)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup()
          .addComponent(check1)
          .addComponent(check3))
        .addGroup(layout.createParallelGroup()
          .addComponent(check2)
          .addComponent(check4)))
       .addComponent(button2))
     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
       .addComponent(label3)
       .addComponent(field2)
       .addComponent(button3))
     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       .addComponent(label4)
       .addComponent(field3)
       .addComponent(button4))
    );
  }
}
