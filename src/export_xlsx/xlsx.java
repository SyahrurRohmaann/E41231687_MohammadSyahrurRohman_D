package export_xlsx;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*; 
import main.Config;

public class xlsx {
public static Connection conn;
public static PreparedStatement pst;
    public static void main(String[] args) {
        String baseDir = "\\Users\\Administrator\\Documents\\Laporan Bulanan SmartKos\\";
        String baseFileName = "Laporan SmartKos";
        String extension = ".xlsx";

        // Generate timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());

        // Create the new file name
        String excel = baseDir + baseFileName + "_" + timestamp + extension;
        
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
            try (XSSFWorkbook workbook = new XSSFWorkbook()){
                XSSFSheet sheet = workbook.createSheet("Report");
                writeHeaderLine(sheet);
                writeDataLines(resultSet, workbook, sheet);
                FileOutputStream outputStream = new FileOutputStream(excel);
                workbook.write(outputStream);
                workbook.close();
                pst.close();
            }
        }catch(Exception e){
            System.err.println("Koneksi gagal" + e.getMessage());   
        }
    }

    private static void writeHeaderLine(XSSFSheet sheet) {
        
        Row headerRow = sheet.createRow(0);
        
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Tanggal");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("No Kamar");

         headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Nama Penyewa");

         headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Tgl Mulai");

         headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Tgl Akhir");

         headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Jumlah Bulan");

         headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Total Harga");
    }

    private static void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
        
        while (result.next()){
            String tanggal = result.getString("tanggal");
            String noKamar = result.getString("no_kamar");
            String namaPenyewa = result.getString("nama_penyewa");
            String tglAwal = result.getString("tgl_mulai");
            String tglAkhir = result.getString("tgl_akhir");
            String jumlahBulan = result.getString("jumlah_bulan");
            String totalHarga = result.getString("total_harga");
            
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            Cell cell =row.createCell(columnCount++);
            cell.setCellValue(tanggal);
            
             cell =row.createCell(columnCount++);
            cell.setCellValue(noKamar);
            
             cell =row.createCell(columnCount++);
            cell.setCellValue(namaPenyewa);
            
             cell =row.createCell(columnCount++);
            cell.setCellValue(tglAwal);
            
             cell =row.createCell(columnCount++);
            cell.setCellValue(tglAkhir);
            
             cell =row.createCell(columnCount++);
            cell.setCellValue(jumlahBulan);
            
            cell =row.createCell(columnCount);
            cell.setCellValue(totalHarga);
            
        }
    }
    
}
