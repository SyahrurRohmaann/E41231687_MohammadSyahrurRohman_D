package swing;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import main.Config;

public class MonthFilter extends JComboBox<String> {
    private Connection conn;

    public MonthFilter() {
        String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        for (String month : months) {
            addItem(month);
        }

        // Menetapkan action listener untuk JComboBox
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterDataByMonth();
            }
        });
    }

    private void filterDataByMonth() {
        try {
            conn = Config.configDB();
            String selectedMonth = (String) getSelectedItem();

            // Query SQL untuk mengambil data berdasarkan bulan
            String sql = "SELECT * FROM keuangan WHERE MONTH(tanggal) = ?";

            // Persiapan statement
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getMonthNumber(selectedMonth));

            // Eksekusi query
            ResultSet rs = pst.executeQuery();

            // Proses hasil query (misalnya menampilkan data ke tabel)
            // ...

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memfilter data: " + ex.getMessage());
        }
    }

    public String getMonthNumber(String monthName) {
        switch (monthName) {
            case "Januari": return "01";
            case "Februari": return "02";
            case "Maret": return "03";
            case "April": return "04";
            case "Mei": return "05";
            case "Juni": return "06";
            case "Juli": return "07";
            case "Agustus": return "08";
            case "September": return "09";
            case "Oktober": return "10";
            case "November": return "11";
            case "Desember": return "12";
            default: return null;
        }
    }
}
