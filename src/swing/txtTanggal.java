package swing;

import java.text.ParseException;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class txtTanggal extends JTextField {
    swing.Datechooser date = new Datechooser();
    
    
    public txtTanggal(JTextField txtDate) {
        this.date.txtDate = txtDate;
        
        // Tambahkan listener untuk memantau perubahan pada txtDate
        txtDate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTanggal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTanggal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTanggal();
            }
        });
        updateTanggal();
    }

    private void updateTanggal() {
        String tanggalString = date.txtDate.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        try {
            Date tanggal = formatter.parse(tanggalString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(tanggal);
            cal.add(Calendar.DATE, 30);
            Date tanggalPlus30 = cal.getTime();
            String tanggalPlus30String = formatter.format(tanggalPlus30);
            this.setText(tanggalPlus30String);
        } catch (ParseException ex) {
            ex.printStackTrace();
            System.err.println("Format tanggal tidak valid: " + tanggalString);
            this.setText("");
        }
    }
public txtTanggal() {
    this.setEditable(false); // Agar tidak dapat diubah secara manual
    updateTanggal();
}
}
