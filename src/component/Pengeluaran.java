
package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import model.Model_PemasukanPengeluaran;


public class Pengeluaran extends javax.swing.JPanel {

    
    public Pengeluaran() {
        initComponents();
        setOpaque(false);
    }

    public void setData(Model_PemasukanPengeluaran data){
        IbIcon1.setIcon(data.getIcon1());
        IbTitle1.setText(data.getTitle1());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbIcon1 = new javax.swing.JLabel();
        IbTitle1 = new javax.swing.JLabel();
        total_Pengeluaran1 = new swing.Total_Pengeluaran();

        setForeground(new java.awt.Color(249, 221, 250));

        IbIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/loss.png"))); // NOI18N

        IbTitle1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        IbTitle1.setForeground(new java.awt.Color(127, 82, 139));
        IbTitle1.setText("Pengeluaran");

        total_Pengeluaran1.setForeground(new java.awt.Color(200, 129, 218));
        total_Pengeluaran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_Pengeluaran1.setFont(new java.awt.Font("Montserrat Medium", 0, 25)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(IbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(total_Pengeluaran1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(IbTitle1)
                        .addGap(25, 25, 25)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(IbTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_Pengeluaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(IbIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 215, 224));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, getWidth() - 20, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbIcon1;
    private javax.swing.JLabel IbTitle1;
    private swing.Total_Pengeluaran total_Pengeluaran1;
    // End of variables declaration//GEN-END:variables

    private void setIcon(Icon icon1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
