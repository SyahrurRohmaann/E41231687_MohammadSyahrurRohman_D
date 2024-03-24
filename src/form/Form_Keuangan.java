package form;

import java.awt.Color;
import javax.swing.JPanel;
import swing.ScrollBar;

public class Form_Keuangan extends javax.swing.JPanel {


    public Form_Keuangan() {
        initComponents();
        jScrollPane.setVerticalScrollBar(new ScrollBar());
        jScrollPane.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.white);
        jScrollPane.setCorner(jScrollPane.UPPER_RIGHT_CORNER, p);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pemasukan1 = new component.Pemasukan();
        pengeluaran1 = new component.Pengeluaran();
        jScrollPane = new javax.swing.JScrollPane();
        table_Histori1 = new swing.Table_Histori();

        setBackground(new java.awt.Color(250, 250, 250));

        jScrollPane.setBorder(null);

        table_Histori1.setForeground(new java.awt.Color(128, 128, 128));
        table_Histori1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Detail", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Histori1.setAlignmentX(1.0F);
        table_Histori1.setAlignmentY(1.0F);
        table_Histori1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jScrollPane.setViewportView(table_Histori1);
        if (table_Histori1.getColumnModel().getColumnCount() > 0) {
            table_Histori1.getColumnModel().getColumn(0).setResizable(false);
            table_Histori1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(pemasukan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pengeluaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pengeluaran1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pemasukan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private component.Pemasukan pemasukan1;
    private component.Pengeluaran pengeluaran1;
    private swing.Table_Histori table_Histori1;
    // End of variables declaration//GEN-END:variables
}
