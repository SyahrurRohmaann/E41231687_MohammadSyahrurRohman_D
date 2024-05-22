package swing;

import java.awt.event.ItemEvent;
import javax.swing.*;
import java.sql.*;
import main.Config;

public class PenyewaTextField extends JTextField {
    public static cmbKamar cmbKamar;

    public PenyewaTextField() {
        populateTextField();
        this.setEditable(false); // Agar tidak dapat diubah secara manual
    }

    // Setter untuk cmbKamar
    public void setCmbKamar(cmbKamar cmbKamar) {
        this.cmbKamar = cmbKamar;

        // Tambahkan listener untuk cmbKamar
        this.cmbKamar.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                populateTextField();
            }
        });
    }

    public void populateTextField() {
        if (cmbKamar == null) {
            // Jika cmbKamar belum diatur, kembalikan saja
            return;
        }

        // Ambil no_kamar yang dipilih dari cmbKamar
        String selectedNoKamar = (String) cmbKamar.getSelectedItem();

        try {
            // Menghubungkan ke database menggunakan koneksi instance field
            Connection conn = Config.configDB();
            // Membuat statement SQL
            String sql = "SELECT nama_penyewa FROM penyewa WHERE no_kamar = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, selectedNoKamar);

            // Mengeksekusi query
            ResultSet resultSet = statement.executeQuery();

            // Mendapatkan data dari ResultSet dan menambahkannya ke JTextField
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                String namaPenyewa = resultSet.getString("nama_penyewa");
                sb.append(namaPenyewa).append("\n");
            }

            setText(sb.toString());

            // Menutup koneksi
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle exception (misalnya menampilkan pesan error)
        }
    }
}
