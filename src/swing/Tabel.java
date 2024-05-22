/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Administrator
 */
public class Tabel extends JTable {

    
    public Tabel() {
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
            if (column == -1){
                header.setHorizontalAlignment(JLabel.CENTER);
            }
            return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column != -1) {
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
} }
