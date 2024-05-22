package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.EmptyBorder;
import main.Config;

public class cmbKamar extends JComboBox<String> {
    Connection conn = null;

    public cmbKamar() {
        super();
        filterDataByMonth();
        setBorder(new EmptyBorder(15, 3, 5, 3));
    }

     @Override
    protected void paintComponent(Graphics grafik) {

        Graphics2D g2 = (Graphics2D) grafik;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255));
        g2.setBackground(Color.white);
        
        super.paintComponent(grafik);
    }
    public void filterDataByMonth() {
        try {
            conn = Config.configDB();
            String sql = "SELECT no_kamar FROM penyewa";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Mengeksekusi query
            ResultSet resultSet = statement.executeQuery();

            // Mendapatkan data dari ResultSet dan menambahkannya ke JComboBox
            List<String> kamarList = new ArrayList<>();
            while (resultSet.next()) {
                String noKamar = resultSet.getString("no_kamar");
                kamarList.add(noKamar);
            }

            for (String noKamar : kamarList) {
                addItem(noKamar);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception (misalnya menampilkan pesan error)
        } finally {
            // Menutup koneksi ke database
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle exception (misalnya menampilkan pesan error)
            }
        }
    }
}