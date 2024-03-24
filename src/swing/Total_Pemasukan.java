package swing;

import java.sql.Connection;
import main.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Total_Pemasukan extends JLabel implements Runnable{

    public Total_Pemasukan() {
        super();
        calculateAndDisplayTotalIncome();
    }

    private void calculateAndDisplayTotalIncome() {
        try {
            Connection connection = (Connection)Config.configDB();

            String sql = "SELECT SUM(total_harga) AS total FROM detail_bayar";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs =pst.executeQuery();
            if (rs.next()){
                String valueFromDB = rs.getString("total");
                setText(valueFromDB);
            }
            else{
                setText("NULL");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     private static String formatCurrency(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedAmount = decimalFormat.format(amount);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return currencyFormat.format(amount);
    }
    @Override 
    public void run(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}