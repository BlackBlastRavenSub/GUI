package ex12;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.Element;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.event.*;

public class EJDicGUI extends JFrame {
    JTextField english, japanese;
    JList list;
    JButton addButton, removeButton, updateButton;
    JPanel pane;
    EJDic dictionary;
    RTFEditorKit rtfEditor;


    public static void main(String[] args) {
        JFrame w = new EJDicGUI("EJDicGUI");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 300);
        w.setVisible(true);
    }

    public EJDicGUI(String title) {
        super(title);
        dictionary = new EJDic();
        pane = (JPanel) getContentPane();
        rtfEditor = new RTFEditorKit();

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

        JPanel fields = new JPanel(new GridLayout(1, 2));
        english = new JTextField();
        english.setBorder(new TitledBorder("英語"));
        fields.add(english);
        japanese = new JTextField();
        japanese.setBorder(new TitledBorder("日本語"));
        fields.add(japanese);
        pane.add(fields, BorderLayout.SOUTH);

        DefaultListModel listModel = new DefaultListModel();
        list = new JList(listModel);
        list.addListSelectionListener(new WordSelect());
        JScrollPane sc = new JScrollPane(list);
        sc.setBorder(new TitledBorder("項目一覧"));
        pane.add(sc, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));
        addButton = new JButton(new AddAction());
        buttons.add(addButton);
        updateButton = new JButton(new UpdateAction());
        buttons.add(updateButton);
        removeButton = new JButton(new RemoveAction());
        buttons.add(removeButton);
        pane.add(buttons, BorderLayout.NORTH);
    }

    class WordSelect implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    class OpenAction extends AbstractAction {
        OpenAction() {
            putValue(Action.NAME, "開く");
            putValue(Action.SHORT_DESCRIPTION, "開く");
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            int error = jFileChooser.showOpenDialog(EJDicGUI.this);
            //エラー発生
            if (error != JFileChooser.APPROVE_OPTION) {
                return;
            }
            EJDicGUI.this.dictionary.open(jFileChooser.getSelectedFile().getAbsolutePath());
            EJDicGUI.this.list.setListData(dictionary.keySet().toArray());
            System.out.println(jFileChooser.getSelectedFile().getName());
        }
    }

    class SaveAction extends AbstractAction {
        SaveAction() {
            putValue(Action.NAME, "保存");
            putValue(Action.SHORT_DESCRIPTION, "保存");
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            int error = jFileChooser.showSaveDialog(EJDicGUI.this);
            //エラー発生
            if (error != JFileChooser.APPROVE_OPTION) {
                return;
            }
            EJDicGUI.this.dictionary.save(jFileChooser.getSelectedFile().getAbsolutePath());
            EJDicGUI.this.list.setListData(dictionary.keySet().toArray());
            System.out.println(jFileChooser.getSelectedFile().getName());
        }
    }

    class ExitAction extends AbstractAction {
        ExitAction() {
            putValue(Action.NAME, "終了");
            putValue(Action.SHORT_DESCRIPTION, "終了");
        }

        public void actionPerformed(ActionEvent e) {
            int dirlog = JOptionPane.showConfirmDialog(null, "シャットダウンしますか?", "終了しますか?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (dirlog) {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }

    class AddAction extends AbstractAction {
        AddAction() {
            putValue(Action.NAME, "追加");
            putValue(Action.SHORT_DESCRIPTION, "追加");
        }

        public void actionPerformed(ActionEvent e) {
            String english = EJDicGUI.this.english.getText();
            String japanese = EJDicGUI.this.japanese.getText();
            //両方のフィールド内の値を削除する
            EJDicGUI.this.english.setText("");
            EJDicGUI.this.japanese.setText("");
            //どちらかのフィールドに値が入っていない
            if (english.equals("") || japanese.equals("")) {
                System.out.println("両方のフィールドに値を入力してください");
                return;
            }
            //英語と日本語のペアをhashMapに保存する
            EJDicGUI.this.dictionary.put(english, japanese);
            //listにデータをセットして表示
            EJDicGUI.this.list.setListData(dictionary.keySet().toArray());
        }
    }

    class UpdateAction extends AbstractAction {
        UpdateAction() {
            putValue(Action.NAME, "更新");
            putValue(Action.SHORT_DESCRIPTION, "更新");
        }

        public void actionPerformed(ActionEvent e) {
            String english = EJDicGUI.this.english.getText();
            String japanese = EJDicGUI.this.japanese.getText();
            //両方のフィールド内の値を削除する
            EJDicGUI.this.english.setText("");
            EJDicGUI.this.japanese.setText("");
            //どちらかのフィールドに値が入っていない、あるいは英語に対応したキーが無い
            if (english.equals("") || japanese.equals("") || EJDicGUI.this.dictionary.get(english) == null) {
                System.out.println("エラー発生");
                return;
            }
            EJDicGUI.this.dictionary.replace(english, japanese);
        }
    }

    class RemoveAction extends AbstractAction {
        RemoveAction() {
            putValue(Action.NAME, "削除");
            putValue(Action.SHORT_DESCRIPTION, "削除");
        }

        public void actionPerformed(ActionEvent e) {
            String chooseEnglish = list.getSelectedValue().toString();
            if (chooseEnglish == null) {
                System.out.println("項目を選択してください");
                return;
            }
            int checkDirlog = JOptionPane.showConfirmDialog(null, "削除しますか?", "本当に良いですか?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (checkDirlog) {
                case JOptionPane.YES_OPTION:
                    dictionary.remove(chooseEnglish);
                    EJDicGUI.this.list.setListData(dictionary.keySet().toArray(new String[0]));
                    System.out.println("削除!");
                    break;
                case JOptionPane.NO_OPTION:
                    break;
            }
        }
    }

}

