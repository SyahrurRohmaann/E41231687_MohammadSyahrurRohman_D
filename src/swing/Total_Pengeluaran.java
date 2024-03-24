package swing;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Config;

public class Total_Pengeluaran extends JLabel implements Runnable{

    public Total_Pengeluaran() {
    super();
    pengeluaran();
    }
    private void pengeluaran(){
        try{
          Connection conn = (Connection)Config.configDB();
            String sql = "select sum(jumlah_pengeluaran) as total from pengeluaran";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String valueFromDB = rs.getString("total");
                setText(valueFromDB);
            }
            else{
                setText("NULL");
            }
            rs.close();
            pst.close();
        } catch (Exception e){
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
