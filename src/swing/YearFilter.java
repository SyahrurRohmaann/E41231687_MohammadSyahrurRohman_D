package swing;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import main.Config;

public class YearFilter extends JComboBox<String> {
    private Connection conn;

    public YearFilter() {
    String[] years = {"2023","2024"};
    for (String year : years) {
            addItem(year);
    }
    // Menetapkan action listener untuk JComboBox
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterDataByYear();
            }
        });
    }
        private void filterDataByYear() {
        try {
            conn = Config.configDB();
            String selectedYear = (String) getSelectedItem();

            // Query SQL untuk mengambil data berdasarkan bulan
            String sql = "SELECT * FROM keuangan WHERE YEAR(tanggal) = ?";

            // Persiapan statement
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getYearNumber(selectedYear));

            // Eksekusi query
            ResultSet rs = pst.executeQuery();

            // Proses hasil query (misalnya menampilkan data ke tabel)
            // ...

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memfilter data: " + ex.getMessage());
        }
    
    
        }
        public String getYearNumber(String year) {
        switch (year) {
            case "2023": return "01";
            case "2024": return "02";
            default: return null;
        }
    }
}
