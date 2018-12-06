package ex12;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;

public class AddressBookGUI extends JFrame {
    JTextField nameField, addressField, telField, emailField;
    DefaultListModel model;
    JList list;
    JButton addButton, removeButton, updateButton;
    JPanel pane;
    AddressBook book;

    public static void main(String[] args) {
        JFrame w = new AddressBookGUI("AddressBookGUI");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(400, 300);
        w.setVisible(true);
    }

    public AddressBookGUI(String title) {
        super(title);
        book = new AddressBook();
        pane = (JPanel) getContentPane();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("ファイル");
        menuBar.add(fileMenu);
        JMenuItem item;
        item = new JMenuItem(new OpenAction());
        fileMenu.add(item);
        item = new JMenuItem(new SaveAction());
        fileMenu.add(item);
        fileMenu.addSeparator();
        item = new JMenuItem(new ExitAction());
        fileMenu.add(item);

        model = new DefaultListModel();
        list = new JList(model);
        list.addListSelectionListener(new NameSelect());
        JScrollPane sc = new JScrollPane(list);
        sc.setBorder(new TitledBorder("名前一覧"));
        pane.add(sc, BorderLayout.CENTER);

        JPanel fields = new JPanel();
        fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
        nameField = new JTextField(20);
        nameField.setBorder(new TitledBorder("名前"));
        fields.add(nameField);
        addressField = new JTextField(20);
        addressField.setBorder(new TitledBorder("住所"));
        fields.add(addressField);
        telField = new JTextField(20);
        telField.setBorder(new TitledBorder("電話"));
        fields.add(telField);
        emailField = new JTextField(20);
        emailField.setBorder(new TitledBorder("メール"));
        fields.add(emailField);

        addButton = new JButton(new AddAction());
        fields.add(addButton);
        updateButton = new JButton(new UpdateAction());
        fields.add(updateButton);
        removeButton = new JButton(new RemoveAction());
        fields.add(removeButton);

        pane.add(fields, BorderLayout.EAST);
    }

    class NameSelect implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    class OpenAction extends AbstractAction {
        OpenAction() {
            putValue(Action.NAME, "開く");
            putValue(Action.SHORT_DESCRIPTION, "開く");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class SaveAction extends AbstractAction {
        SaveAction() {
            putValue(Action.NAME, "保存");
            putValue(Action.SHORT_DESCRIPTION, "保存");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class ExitAction extends AbstractAction {
        ExitAction() {
            putValue(Action.NAME, "終了");
            putValue(Action.SHORT_DESCRIPTION, "終了");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class AddAction extends AbstractAction {
        AddAction() {
            putValue(Action.NAME, "追加");
            putValue(Action.SHORT_DESCRIPTION, "追加");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class UpdateAction extends AbstractAction {
        UpdateAction() {
            putValue(Action.NAME, "更新");
            putValue(Action.SHORT_DESCRIPTION, "更新");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }

    class RemoveAction extends AbstractAction {
        RemoveAction() {
            putValue(Action.NAME, "削除");
            putValue(Action.SHORT_DESCRIPTION, "削除");
        }

        public void actionPerformed(ActionEvent e) {

        }
    }
}
