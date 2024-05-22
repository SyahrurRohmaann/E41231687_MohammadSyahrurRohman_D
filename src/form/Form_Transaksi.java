/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.Config;


public class Form_Transaksi extends javax.swing.JPanel {

    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Form_Transaksi(){
        initComponents();
        txtDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDate();
            }
            
            });
    }
    public void updateTotalHarga(){
        try{
            int hargaKamar = Integer.parseInt(txtHargaKamar.getText());
            int hargaTambahan = Integer.parseInt(txtHargaTb.getText());
            int totalHarga = hargaKamar + hargaTambahan;
            txtHargaTotal.setText(String.valueOf(totalHarga));
            
        } catch (Exception e){
            txtHargaTotal.setText("Invalid input");
        }

    }
    public void updateDate() {
                 try {
            String inputText = txtDate.getText();
            String multiplierText = txtDate3.getText();
            int multiplier = Integer.parseInt(multiplierText);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            Date inputDate = dateFormat.parse(inputText);
            
            // Mengalikan jumlah hari dengan nilai dari txtDate3
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(Calendar.DAY_OF_MONTH, multiplier * 30);
            Date newDate = calendar.getTime();
            
            // Menampilkan tanggal baru di txtDate2
            txtDate2.setText(dateFormat.format(newDate));
        } catch (Exception ex) {
            txtDate2.setText("Invalid Date");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtFasil = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbKamar = new swing.cmbKamar();
        txtPenghuni = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtDate2 = new javax.swing.JTextField();
        txtDate3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtHargaTotal = new javax.swing.JTextField();
        txtHargaKamar = new javax.swing.JTextField();
        txtHargaTb = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        dateChooser1.setDateFormat("dd-MMMM-yyyy");
        dateChooser1.setTextRefernce(txtDate);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 82, 139));
        jLabel1.setText("Transaksi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 82, 139));
        jLabel2.setText("Detail Sewa");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 96, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("No Kamar");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nama Penghuni");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tanggal Mulai Sewa");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tanggal Akhir Sewa");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 256, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Fasilitas Tambahan");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 334, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Harga Tambahan");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 372, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 195, 215));
        jButton1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(127, 82, 139));
        jButton1.setText("Lanjut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 421, -1, -1));

        txtFasil.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtFasil.setForeground(new java.awt.Color(51, 51, 51));
        txtFasil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtFasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFasilActionPerformed(evt);
            }
        });
        add(txtFasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 332, 150, 20));

        txtHarga.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtHarga.setForeground(new java.awt.Color(51, 51, 51));
        txtHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHargaTb.setText(txtHarga.getText());
                updateTotalHarga();
            } });
            txtHarga.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtHargaActionPerformed(evt);
                }
            });
            add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 370, 150, 20));

            jLabel10.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(51, 51, 51));
            jLabel10.setText("Jumlah Bulan");
            add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 292, -1, -1));

            cmbKamar.setBackground(new java.awt.Color(255, 255, 255));
            cmbKamar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            cmbKamar.setForeground(new java.awt.Color(51, 51, 51));
            cmbKamar.setToolTipText("");
            cmbKamar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            cmbKamar.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
                public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                }
                public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                    cmbKamarPopupMenuWillBecomeInvisible(evt);
                }
                public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                }
            });
            cmbKamar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmbKamarActionPerformed(evt);
                }
            });
            add(cmbKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 143, 150, -1));

            txtPenghuni.setBackground(new java.awt.Color(255, 255, 255));
            txtPenghuni.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            add(txtPenghuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 184, 150, -1));

            txtDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            txtDate.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtDateActionPerformed(evt);
                }
            });
            add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 219, 150, -1));

            txtDate2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            txtDate2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtDate2ActionPerformed(evt);
                }
            });
            add(txtDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 255, 150, -1));

            txtDate3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
            txtDate3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtDate3ActionPerformed(evt);
                }
            });
            txtDate3.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtDate3KeyPressed(evt);
                }
            });
            add(txtDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 291, 150, -1));

            jButton2.setBackground(new java.awt.Color(255, 217, 227));
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/calendar.png"))); // NOI18N
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 213, -1, -1));

            jPanel1.setVisible(false);
            jPanel1.setBackground(new java.awt.Color(249, 219, 249));

            jLabel9.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(127, 82, 139));
            jLabel9.setText("Detail Bayar");

            jLabel11.setFont(new java.awt.Font("Montserrat Light", 0, 12)); // NOI18N
            jLabel11.setForeground(new java.awt.Color(51, 51, 51));
            jLabel11.setText("Harga Kamar");

            jLabel12.setFont(new java.awt.Font("Montserrat Light", 0, 12)); // NOI18N
            jLabel12.setForeground(new java.awt.Color(51, 51, 51));
            jLabel12.setText("Harga Tambahan");

            jLabel13.setFont(new java.awt.Font("Montserrat Light", 0, 12)); // NOI18N
            jLabel13.setForeground(new java.awt.Color(51, 51, 51));
            jLabel13.setText("Harga Total");

            jLabel14.setText(":");

            jLabel15.setText(":");

            jLabel16.setText(":");

            txtHargaTotal.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            txtHargaTotal.setForeground(new java.awt.Color(51, 51, 51));
            txtHargaTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
            txtHargaTotal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtHargaTotalActionPerformed(evt);
                }
            });

            txtHargaKamar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            txtHargaKamar.setForeground(new java.awt.Color(51, 51, 51));
            txtHargaKamar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
            txtHargaKamar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtHargaKamarActionPerformed(evt);
                }
            });

            txtHargaTb.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
            txtHargaTb.setForeground(new java.awt.Color(51, 51, 51));
            txtHargaTb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
            txtHargaTb.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    updateTotalHarga();
                } });
                txtHargaTb.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txtHargaTbActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHargaTb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(18, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(txtHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(txtHargaTb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(txtHargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(173, Short.MAX_VALUE))
                );

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 96, -1, -1));

                btnBayar.setBackground(new java.awt.Color(255, 195, 215));
                btnBayar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
                btnBayar.setForeground(new java.awt.Color(127, 82, 139));
                btnBayar.setText("Bayar");
                btnBayar.setVisible(false);
                btnBayar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBayarActionPerformed(evt);
                    }
                });
                add(btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

                btnBatal.setBackground(new java.awt.Color(255, 195, 215));
                btnBatal.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
                btnBatal.setForeground(new java.awt.Color(127, 82, 139));
                btnBatal.setText("Batal");
                btnBayar.setVisible(false);
                btnBatal.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBatalActionPerformed(evt);
                    }
                });
                add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));
            }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String inputDate1 = txtDate.getText();
        String inputDate2 = txtDate2.getText();
        String inputDate3 = txtDate3.getText();
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            Date parsedDate1 = inputFormat.parse(inputDate1);
            Date parsedDate2 = inputFormat.parse(inputDate2);
            String formattedDate1 = outputFormat.format(parsedDate1);
            String formattedDate2 = outputFormat.format(parsedDate2);
            Connection conn = Config.configDB();
            if (conn == null) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung ke Database");
            return;
        }
            String sql = "INSERT INTO transaksi (no_kamar, nama_penyewa, tgl_mulai_sewa, tgl_akhir_sewa, jumlah_bulan, "
                    + "fasilitas_tambahan, harga_tambahan) VALUES ("
                    + "'" + cmbKamar.getSelectedItem() + "', " 
                    + "'" + txtPenghuni.getText() + "', " 
                    + "'" + formattedDate1 + "', "
                    + "'" + formattedDate2 + "', "
                    + "'" + inputDate3 + "', "
                    + "'" + txtFasil.getText() + "', "
                    + "'" + txtHarga.getText() + "');";
            
            String sql2 = "SELECT harga_tambahan FROM transaksi WHERE id_transaksi = (SELECT MAX(id_transaksi) FROM transaksi);";
            String sql3 = "UPDATE tagihan SET tagihan.tgl_akhir_sewa = '" + formattedDate2 + "' WHERE "
                    + "tagihan.nama_penyewa = '" + txtPenghuni.getText() +"'";
            PreparedStatement pst =conn.prepareStatement(sql);
            PreparedStatement pstt =conn.prepareStatement(sql2);
            PreparedStatement psttt =conn.prepareStatement(sql3);
            pst.execute();
            pstt.execute();
            psttt.execute();
            
            btnBayar.setVisible(true);
            btnBayar.setVisible(true);
            jPanel1.setVisible(true);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Mohon masukkan data dengan benar \n sebelum melanjutkan "+ e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFasilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFasilActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void cmbKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKamarActionPerformed

    private void cmbKamarPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbKamarPopupMenuWillBecomeInvisible
        String tmp = (String)cmbKamar.getSelectedItem();
        String sql = "SELECT * FROM penyewa WHERE no_kamar = ?";
        try{
            Connection conn = Config.configDB();;
                if (conn == null) {
            JOptionPane.showMessageDialog(null, "Gagal Terhubung ke Database");
            return;}
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String add = rs.getString("nama_penyewa");
                txtPenghuni.setText(add);
                
                
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
         
    try {
        String sql1 = "SELECT * FROM kamar WHERE no_kamar=?";
        pst = Config.configDB().prepareStatement(sql1);
        pst.setString(1, cmbKamar.getSelectedItem().toString());
        rs = pst.executeQuery();
        if (rs.next()) {
            String hargaKamar = rs.getString("harga_kamar");
            txtHargaKamar.setText(hargaKamar);
            updateTotalHarga();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_cmbKamarPopupMenuWillBecomeInvisible

    
    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        dateChooser1.toDay();
    }//GEN-LAST:event_txtDateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate2ActionPerformed
       updateDate();
    }//GEN-LAST:event_txtDate2ActionPerformed

    private void txtDate3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDate3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate3KeyPressed

    private void txtDate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate3ActionPerformed
        updateDate();        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate3ActionPerformed

    private void txtHargaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaTotalActionPerformed

    private void txtHargaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaKamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaKamarActionPerformed

    private void txtHargaTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaTbActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        Connection conn = null;
        try{
            conn =(Connection) Config.configDB();
            String sID = "SELECT MAX(id_transaksi) as id, tgl_transaksi FROM transaksi";
            PreparedStatement pst = conn.prepareStatement(sID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String nilaiID = rs.getString("id");
            String nilaiTgl = rs.getString("tgl_transaksi");
            
            String sql = "INSERT INTO detail_bayar VALUES ('" + nilaiID +"', "+ txtHargaKamar.getText() +"' , '" + 
                            txtHargaTb.getText()+ "' , '" + txtHargaTotal.getText() +"')";
            String sql1 = "INSERT INTO keuangan (tanggal, jumlah) Values ('" + nilaiTgl + "', '" + txtHargaTotal.getText() + "')";
            PreparedStatement pstt = conn.prepareStatement(sql);
            PreparedStatement psttt = conn.prepareStatement(sql1);
            pstt.execute();
            psttt.execute();
            JOptionPane.showMessageDialog(null, "Transaksi berhasil");
            rs.close();
            pstt.close();
            psttt.close();
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        Connection conn = null;
        try{
            int konfirmasiBatal = JOptionPane.showConfirmDialog(null,"Apakah anda ingin membatalkan transaksi?", 
                    "Batal Transaksi", JOptionPane.YES_NO_OPTION);
            
            conn = (Connection) Config.configDB();
            if (konfirmasiBatal == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM transaksi WHERE id_transaksi = (SELECT MAX(id_transaksi) FROM transaksi)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal menghapus");
            e.printStackTrace();    
        }
        btnBatal.setVisible(false);
        btnBayar.setVisible(false);
        jPanel1.setVisible(false);
    }//GEN-LAST:event_btnBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBayar;
    private swing.cmbKamar cmbKamar;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDate2;
    private javax.swing.JTextField txtDate3;
    private javax.swing.JTextField txtFasil;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHargaKamar;
    private javax.swing.JTextField txtHargaTb;
    private javax.swing.JTextField txtHargaTotal;
    public javax.swing.JTextField txtPenghuni;
    // End of variables declaration//GEN-END:variables

}
