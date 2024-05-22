package swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import main.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TableHistori extends JTable {
//    public void load_table(){
//        try {
//            // Establish database connection
//            Connection conn = Config.configDB();
//            if (conn == null) {
//                JOptionPane.showMessageDialog(null, "Gagal menghubungkan ke database");
//                return;
//            }
//
//            
//            String sql = "SELECT DATE_FORMAT(keuangan.tanggal, '%d %b %y') AS tanggal, keuangan.detail, keuangan.jumlah FROM keuangan";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
//            int columnCount = rsmd.getColumnCount();
//            DefaultTableModel model = new DefaultTableModel();
//            model.setColumnIdentifiers(new Object[]{"Tanggal", "Detail", "Jumlah"});
//
//            // Populate table model with data
//            while (rs.next()) {
//                Vector<Object> row = new Vector<>();
//                for (int i = 1; i <= columnCount; i++) {
//                    row.add(rs.getObject(i));
//                }
//                model.addRow(row);
//            }
//
//            
//            setModel(model);
//
//            // Close resources
//            rs.close();
//            pst.close();
//            conn.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }


    public TableHistori() {
        super();
        properties();
        
    
    


}
    private void properties(){
        setShowHorizontalLines(true);
        setGridColor(new Color (230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableHeader header = new TableHeader(value + "");
            if (column == 3){
                header.setHorizontalAlignment(JLabel.CENTER);
            }
            return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column != 3) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                com.setBackground(Color.WHITE);
                setHorizontalAlignment(JLabel.CENTER);
                setBorder(noFocusBorder);
                if(isSelected) {
                    com.setForeground(new Color(20, 20, 20));
                } else {
                    com.setForeground(new Color(129,128,128));
                }
                return com;
            }
            return new JLabel("");
            
            }
        
        });
        

    }
    }