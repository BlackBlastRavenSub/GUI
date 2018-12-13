package ex13;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class JTableExample extends JFrame {
    public static void main(String[] args) {

        JFrame w = new JTableExample("JTableTest01");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(500, 320);
        w.setVisible(true);
    }

    static class JTableExampleModel extends AbstractTableModel {
        String[] columnNames = {
                " ", "時間", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日"
        };
        String[][] data = {
                {"1", "09:20~11:00", "", "離散数学", "", "オペレーティングシステム", "アメリカ理解"},
                {"2", "11:10~12:50", "総合英語IV", "データ記述とWebサービス", "オートマトンと言語理論", "データ構造とアルゴリズム", ""},
                {"3", "11:10~12:50", "データベース", "", "認知心理学", "データ構造とアルゴリズム演習", "英語演習D"},
                {"4", "11:10~12:50", "", "", "情報倫理", "ＧＵＩプログラミング", ""},
                {"5", "17:20~19:00", "", "", "", "", ""},
        };

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            data[row][column] = (String) value;
        }
    }

    JTableExample(String title) {
        super(title);
        //JTable table = new JTable(5, 7); // テーブルの生成
        JTable table = new JTable(new JTableExampleModel());
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        JScrollPane scr = new JScrollPane(table); // スクロールペインにセットする
        getContentPane().add(scr);

        DefaultTableColumnModel columnModel
                = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn column = null;
        int n;
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            // n = Integer.parseInt(columnModel.getColumn(i).toString());
            n = table.getColumnName(i).length();
            column = columnModel.getColumn(i);
            column.setPreferredWidth(n);
            System.out.println(n);
        }
/*
        String[] header = {" ", "時間", "月曜日", "火曜日","水曜日","木曜日","金曜日"};
        for (int i = 0; i < 7; i++) {
            TableColumn col = table.getColumnModel().getColumn(i); // カラムモデルを得てからカラムを得る
            col.setHeaderValue(header[i]); // ヘッダの設定
        }
        */

    }
}
