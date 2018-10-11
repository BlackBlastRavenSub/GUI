package ex4;

import javax.swing.*;

public class MenuTest01B extends JFrame {
    public static void main(String[] args) {
        MenuTest01B w = new MenuTest01B("MenuTest01B");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(350, 250);
        w.setVisible(true);
    }

    public MenuTest01B(String title) {
        super(title);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        JMenuItem item;
        item = new JMenuItem("新しいウィンドウ");
        file.add(item);
        item = new JMenuItem("新しいタブ");
        file.add(item);
        item = new JMenuItem("URLを開く");
        file.add(item);
        item = new JMenuItem("ファイルを開く");
        file.add(item);
        item = new JMenuItem("ウィンドウを閉じる");
        file.add(item);
        item = new JMenuItem("タブを閉じる");
        file.add(item);
        file.addSeparator();

        item = new JMenuItem("名前をつけてページを保存");
        file.add(item);
        item = new JMenuItem("ページをPDFで保存");
        file.add(item);
        item = new JMenuItem("ページのURLをメールで送信");
        file.add(item);
        file.addSeparator();

        item = new JMenuItem("ページ設定");
        file.add(item);
        item = new JMenuItem("印刷プレビュー");
        file.add(item);
        item = new JMenuItem("印刷");
        file.add(item);
        file.addSeparator();

        item = new JMenuItem("設定とデータのインポート");
        file.add(item);
        file.addSeparator();

        item = new JMenuItem("オフライン作業");
        file.add(item);
        item = new JMenuItem("終了");
        file.add(item);
    }
}
