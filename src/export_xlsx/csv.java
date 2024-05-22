package export_xlsx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import main.Config;

public class csv {
    public static Connection conn;
    public static Statement pst;
    
    public static void main(String[] args) {
         String baseDir = "\\Users\\Administrator\\Documents\\NetBeansProjects\\SmartKost\\src\\export_xlsx\\";
//         String baseDir = "\\Users\\Administrator\\Documents\\Laporan Bulanan SmartKos\\";
        String baseFileName = "Laporan SmartKos";
        String extension = ".csv";

        // Generate timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());

        // Create the new file name
        String csvFilePath = baseDir + baseFileName + "_" + timestamp + extension;
        
        try{
            conn = (Connection) Config.configDB();
            String sql = "SELECT \n" +
"    DATE_FORMAT(transaksi.tgl_transaksi, '%d-%b-%y') AS tanggal,\n" +
"    transaksi.no_kamar,\n" +
"    transaksi.nama_penyewa,\n" +
"    DATE_FORMAT(transaksi.tgl_mulai_sewa, '%d-%b-%y') AS tgl_mulai,\n" +
"    DATE_FORMAT(transaksi.tgl_akhir_sewa, '%d-%b-%y') AS tgl_akhir,\n" +
"    transaksi.jumlah_bulan,\n" +
"    detail_bayar.total_harga\n" +
"FROM \n" +
"    transaksi\n" +
"JOIN \n" +
"    detail_bayar \n" +
"    ON transaksi.id_transaksi = detail_bayar.id_transaksi\n" +
"WHERE \n" +
"    MONTH(transaksi.tgl_transaksi) = MONTH(CURDATE()) \n" +
"    AND YEAR(transaksi.tgl_transaksi) = YEAR(CURDATE())";
            pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery(sql);
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath))){
                fileWriter.write("tanggal, no_kamar, nama_penyewa, tgl_mulai, tgl_akhir, jumlah_bulan, total_harga");
                
                while (resultSet.next()){
            String tanggal = resultSet.getString("tanggal");
            String noKamar = resultSet.getString("no_kamar");
            String namaPenyewa = resultSet.getString("nama_penyewa");
            String tglAwal = resultSet.getString("tgl_mulai");
            String tglAkhir = resultSet.getString("tgl_akhir");
            String jumlahBulan = resultSet.getString("jumlah_bulan");
            String totalHarga = resultSet.getString("total_harga");
                
            String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                    tanggal, noKamar, namaPenyewa, tglAwal, tglAkhir, jumlahBulan, totalHarga);
            
            fileWriter.newLine();
            fileWriter.write(line);
                }
            }
             pst.close();   
    
    } catch (Exception e){
            System.err.println("koneksi gagal"+ e.getMessage());
    }
}}
