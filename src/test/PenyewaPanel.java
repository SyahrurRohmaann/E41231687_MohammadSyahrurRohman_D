/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PenyewaPanel extends JPanel {
    private JComboBox<String> comboBoxNoKamar;
    private JTextField textFieldNamaPenyewa;
    private Connection connection;

    public PenyewaPanel() {
        setLayout(new FlowLayout());

        comboBoxNoKamar = new JComboBox<>();
        textFieldNamaPenyewa = new JTextField(20);
        textFieldNamaPenyewa.setEditable(false);

        add(comboBoxNoKamar);
        add(textFieldNamaPenyewa);

        try {
            // Initialize the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nama_database", "username", "password");

            // Populate the JComboBox with no_kamar
            String queryNoKamar = "SELECT no_kamar FROM penyewa";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryNoKamar);

            while (resultSet.next()) {
                comboBoxNoKamar.addItem(resultSet.getString("no_kamar"));
            }

            // Add action listener to JComboBox to update JTextField
            comboBoxNoKamar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedNoKamar = (String) comboBoxNoKamar.getSelectedItem();
                    updateNamaPenyewa(selectedNoKamar);
                }
            });

            // Initialize the JTextField with the first item's data
            if (comboBoxNoKamar.getItemCount() > 0) {
                updateNamaPenyewa((String) comboBoxNoKamar.getItemAt(0));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNamaPenyewa(String noKamar) {
        try {
            String queryNamaPenyewa = "SELECT nama_penyewa FROM penyewa WHERE no_kamar = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryNamaPenyewa);
            preparedStatement.setString(1, noKamar);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                textFieldNamaPenyewa.setText(resultSet.getString("nama_penyewa"));
            } else {
                textFieldNamaPenyewa.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Penyewa Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new PenyewaPanel());
        frame.setVisible(true);
    }
}
