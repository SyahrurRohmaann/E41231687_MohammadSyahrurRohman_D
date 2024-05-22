package form;

import java.sql.Connection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import main.Config;
import swing.ScrollBar;
import java.sql.SQLException;


public class Form_Keuangan extends javax.swing.JPanel {
    
    public Form_Keuangan() {
        initComponents();
        load_table();
        JPanel p = new JPanel();
        p.setBackground(Color.white);
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane2.setCorner(jScrollPane2.UPPER_RIGHT_CORNER, p);
    }
    public void load_table(){
        try {
            // Establish database connection
            Connection conn = Config.configDB();
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Gagal menghubungkan ke database");
                return;
            }

            
            String sql = "SELECT DATE_FORMAT(keuangan.tanggal, '%d %b %y') AS tanggal, keuangan.detail, keuangan.jumlah FROM keuangan";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            DefaultTableModel model = (DefaultTableModel) tableHistori1.getModel() ;
            model.setColumnIdentifiers(new Object[]{"Tanggal", "Detail", "Jumlah"});

            // Populate table model with data
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                model.addRow(row);
            }

            // Close resources
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCari = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pemasukan1 = new component.Pemasukan();
        pengeluaran1 = new component.Pengeluaran();
        monthFilter1 = new swing.MonthFilter();
        yearFilter1 = new swing.YearFilter();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHistori1 = new swing.TableHistori();
        btnTambah = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));

        bCari.setBackground(new java.awt.Color(255, 195, 215));
        bCari.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        bCari.setForeground(new java.awt.Color(127, 82, 139));
        bCari.setText("Cari");
        bCari.setBorderPainted(false);
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 195, 215));
        btnReset.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(127, 82, 139));
        btnReset.setText("Refresh");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 82, 139));
        jLabel1.setText("Keuangan");

        monthFilter1.setBackground(new java.awt.Color(255, 195, 215));
        monthFilter1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        monthFilter1.setForeground(new java.awt.Color(127, 82, 139));
        monthFilter1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        yearFilter1.setBackground(new java.awt.Color(255, 195, 215));
        yearFilter1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        yearFilter1.setForeground(new java.awt.Color(127, 82, 139));
        yearFilter1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jScrollPane2.setViewportView(tableHistori1);

        btnTambah.setBackground(new java.awt.Color(255, 195, 215));
        btnTambah.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(127, 82, 139));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pemasukan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(pengeluaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pemasukan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pengeluaran1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCari)
                    .addComponent(btnReset)
                    .addComponent(monthFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        swing.MonthFilter fl = new swing.MonthFilter();
        swing.YearFilter f2 = new swing.YearFilter();
         try {
        Connection conn = Config.configDB();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung ke Database");
            return;
        }

        // Ambil bulan yang dipilih dari MonthFilter
        String selectedMonth = (String) monthFilter1.getSelectedItem();
        String selectedYear = (String) yearFilter1.getSelectedItem();

        // Query SQL untuk mengambil data berdasarkan bulan yang dipilih
        String sql = "SELECT * FROM keuangan WHERE YEAR(tanggal) = ? AND MONTH(tanggal) = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, selectedYear);
        pst.setString(2, fl.getMonthNumber(selectedMonth));
        


        ResultSet rs = pst.executeQuery();

        // Buat model tabel baru
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Tanggal", "Detail", "Jumlah"});

        // Populate tabel dengan hasil query
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("tanggal"));
            row.add(rs.getString("detail"));
            row.add(rs.getString("jumlah"));
            model.addRow(row);
        }

//        Set model baru ke dalam tabelHistori1
        tableHistori1.setModel(model);

        // Tutup sumber daya
        rs.close();
        pst.close();

        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        e.printStackTrace();
    }
    }//GEN-LAST:event_bCariActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    load_table();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        Form_TambahPengeluaran   frame = new Form_TambahPengeluaran();
        frame.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCari;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.MonthFilter monthFilter1;
    private component.Pemasukan pemasukan1;
    private component.Pengeluaran pengeluaran1;
    private swing.TableHistori tableHistori1;
    private swing.YearFilter yearFilter1;
    // End of variables declaration//GEN-END:variables
}
