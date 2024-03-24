package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.Model_PemasukanPengeluaran;

public class Pemasukan extends javax.swing.JPanel {

    public Pemasukan() {
        initComponents();
        setOpaque(false);

    }

    public void setData(Model_PemasukanPengeluaran data) {
        IbIcon.setIcon(data.getIcon());
        IbTitle.setText(data.getTitle());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbTitle = new javax.swing.JLabel();
        IbIcon = new javax.swing.JLabel();
        total_Pemasukan1 = new swing.Total_Pemasukan();

        IbTitle.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        IbTitle.setForeground(new java.awt.Color(127, 82, 139));
        IbTitle.setText("Pemasukan");

        IbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profit.png"))); // NOI18N

        total_Pemasukan1.setForeground(new java.awt.Color(0, 204, 0));
        total_Pemasukan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_Pemasukan1.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(IbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(IbTitle))
                    .addComponent(total_Pemasukan1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(IbTitle)
                .addGap(0, 0, 0)
                .addComponent(total_Pemasukan1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(IbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grafik) {

        Graphics2D g2 = (Graphics2D) grafik;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(249, 213, 245, 255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, getWidth() - 20, getWidth(), getHeight());
        super.paintComponent(grafik);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbIcon;
    private javax.swing.JLabel IbTitle;
    private swing.Total_Pemasukan total_Pemasukan1;
    // End of variables declaration//GEN-END:variables
}
