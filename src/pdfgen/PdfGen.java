/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdfgen;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class PdfGen {
    public void generatePDF(File f, ResultSet rs) {
        try {
            Document document = new Document(PageSize.A4);
            OutputStream outputStream = new FileOutputStream(f);
            // Create PDFWriter instance.
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            // Add header
            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
            writer.setPageEvent(event);

            // Open the document.
            document.open();

            // Add content to the document
            PdfPTable table = new PdfPTable(4); // 3 columns
           
            table.setWidthPercentage(100); // Width 100%
         
//            document.setMargins(0, 0, 100, 0);
           
           

            // Add column headers
            Paragraph p = new Paragraph("SAP ID");
            p.getFont().setStyle(Font.BOLD);
            PdfPCell cell1 = new PdfPCell(p);
            
            p = new Paragraph("Date");
            p.getFont().setStyle(Font.BOLD);
            PdfPCell cell2 = new PdfPCell(p);
            
            p = new Paragraph("In Time");
            p.getFont().setStyle(Font.BOLD);
            PdfPCell cell3 = new PdfPCell(p);
            
            p = new Paragraph("Out Time");
            p.getFont().setStyle(Font.BOLD);
            PdfPCell cell4 = new PdfPCell(p);

            cell1.setPadding(7);
            cell2.setPadding(7);
            cell3.setPadding(7);
            cell4.setPadding(7);
             
          
            
            // Add cells to the table
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);

            // Add 150 rows to the table
            while (rs.next()) {
                for(int j = 1; j <= 4; j++) {
                    PdfPCell cell = new PdfPCell(new Paragraph(rs.getString(j)));
                    cell.setPadding(7);
                    table.addCell(cell);
                }
            }

            document.add(table);

            // Close document and outputStream.
            document.close();
            outputStream.close();
            System.out.println("Pdf created successfully.");
        } catch (DocumentException | IOException | SQLException e) {
        }
    }
}

class HeaderFooterPageEvent extends com.itextpdf.text.pdf.PdfPageEventHelper {
    private final float headerHeight = 150; // Height of the header image

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
        try {
            String imagePath = "header.jpg"; // Replace with the actual path
            Image headerImage = Image.getInstance(getClass().getResource("header.jpg"));
            headerImage.scaleToFit(PageSize.A4.getWidth(), headerHeight); // Scale image to fit width of page
            headerImage.setAlignment(Image.ALIGN_CENTER);
            document.add(headerImage);
           
           
           
        } catch (DocumentException | IOException e) {
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            // Adjust Y position of subsequent content
//            document.setMargins(0, 0 ,0 ,100);
        } catch (Exception e) {
        }
    }
}
