
package sgp.Utilities;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import java.util.Arrays;
import sgp.database.Database;

public class PDF {
    private static PDF instance;
    private int subtotal;
    private int discount;
    public PDF() {
        instance = null;
        subtotal = 0;
        discount = 0;
    }
    public static PDF get_instance() {
        if (instance == null) {
            instance = new PDF();
        }
        return instance;
    }
    public int create_PDF(ArrayList<String> register) throws DocumentException, IOException {
        Document pdf = new Document();
        String code_formatted = String.format("%05d", Integer.valueOf(register.get(0)));
        String title = "Factura y Garantia de Registro " + code_formatted;
        try {
            PdfWriter pdf_instance = PdfWriter.getInstance(pdf, new FileOutputStream(title + ".pdf"));
            pdf.open();
            PdfContentByte helper = pdf_instance.getDirectContent();
            add_metadata(pdf, title, register);
            add_logo(pdf);
            create_header(helper, code_formatted, register.get(6));
            add_client_information(pdf, Database.get_instance().obtain_client(Integer.parseInt(register.get(1))),helper);
            pdf.add(create_services_table(register.get(2)));
            add_padding(pdf, 1);
            pdf.add(create_promotions_table(register.get(7)));
            add_padding(pdf, 1);
            pdf.add(create_subtotal_table());
            add_padding(pdf, 1);
            add_final_information(pdf);
            pdf.close();
            subtotal = 0;
            discount = 0;
        }
        catch (FileNotFoundException ex) {
            return 1;
        }
        catch (DocumentException ex) {
            return 2;
        }
        return 0;
    }
    public void add_metadata(Document pdf, String title, ArrayList<String> register) {
        pdf.addTitle(title);
        pdf.addSubject("Fecha de Creacion: " + register.get(5));
        pdf.addKeywords("Factura Garantia");
        pdf.addAuthor("sh4dowtech@gmail.com");
        pdf.addCreator("sh4dowtech@gmail.com");
        pdf.addCreationDate();
        pdf.addLanguage("Español");
    }
    public void add_logo(Document pdf) {
        try {
            Image logo = Image.getInstance("/home/sh4dow18/NetBeansProjects/SGP/images/Logo.png");
            logo.setAbsolutePosition(30, 710);
            logo.scalePercent(35);
            pdf.add(logo);
        }
        catch (BadElementException | IOException  ex) {
            System.err.println(ex);
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
    }
    public void create_header(PdfContentByte helper, String code, String date) {
        create_headings_about_business(helper);
        create_headings_about_bill_and_date(helper, code, date);
    }
    public void create_headings_about_business(PdfContentByte helper) {
        create_heading(helper, 150, 790, "Negocio de Tecnologia \"Sh4dowtech\"", 10);
        create_heading(helper, 150, 775, "Cedula: 305350316", 8);
        create_heading(helper, 150, 760, "Dueño del Negocio: Ramses Solano Arias", 8);
        create_heading(helper, 150, 745, "Direccion: Del Super Cali 50 N 50 E, Rincon Herrera, Guacima", 8);
        create_heading(helper, 150, 730, "Alajuela (Alajuela)", 8);
        create_heading(helper, 150, 715, "Teléfono: +506 8941-4905", 8);
        create_heading(helper, 150, 700, "Correo Electronico: sh4dowtechalajuela@gmail.com", 8);
    }
    public void create_headings_about_bill_and_date(PdfContentByte helper, String code, String date) {
        create_rectangles_for_bill_and_date(helper);
        create_heading(helper, 488, 804, "Factura", 12);
        create_heading(helper, 492, 780, code, 14);
        create_heading(helper, 494, 739, "Fecha", 12);
        create_heading(helper, 473, 715, date, 14);
    }
    public void create_heading(PdfContentByte helper, float position_x, float position_y, String text, int tam){
        helper.beginText();
        try {
            helper.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED), tam);
        }
        catch (DocumentException | IOException ex) {
            System.err.println(ex);
        }
        helper.setTextMatrix(position_x,position_y);
        helper.showText(text);
        helper.endText();
    }
    
    public void create_rectangles_for_bill_and_date(PdfContentByte helper) {
        helper.setLineWidth(1f);
        helper.roundRectangle(460, 770, 100, 50, 5 );
        helper.roundRectangle(460, 705, 100, 50, 5 );
        helper.moveTo(460,797); // (x,y)
        helper.lineTo(560,797);
        helper.moveTo(460,732);
        helper.lineTo(560,732);
        helper.stroke();
    }
    public PdfPTable create_services_table(String services) {
        PdfPTable table = new PdfPTable(4);
        try {
            table.setTotalWidth(new float[]{ 60, 250, 75, 120});
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
        table.setLockedWidth(true);
        table.addCell(create_cell_for_columns("Codigo"));
        table.addCell(create_cell_for_columns("Servicio"));
        table.addCell(create_cell_for_columns("Garantia"));
        table.addCell(create_cell_for_columns("Precio"));
        create_rows_for_services(table, services);
        return table;
    }
    public PdfPCell create_cell_for_columns(String column) {
        PdfPCell cell = new PdfPCell(new Phrase(column));
        cell.setColspan(1);
        cell.setHorizontalAlignment (Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPaddingTop(5);
        cell.setPaddingBottom(5);
        return cell;
    }
    public void create_rows_for_services(PdfPTable table, String services_codes) {
        ArrayList<String> services = new ArrayList(Arrays.asList(services_codes.split("\\s*, \\s*")));
        for (String service_code : services) {
             ArrayList<String> service = Database.get_instance().obtain_service(Integer.parseInt(service_code));
             table.addCell(create_cell_for_rows(String.format("%02d", Integer.valueOf(service.get(0)))));
             table.addCell(create_cell_for_rows(service.get(1)));
             table.addCell(create_cell_for_rows(service.get(2) + " Meses"));
             table.addCell(create_cell_for_rows(service.get(3) + " Colones"));
             subtotal = subtotal + Integer.parseInt(service.get(3));
        }
    }
    public void create_rows_for_promotions(PdfPTable table, String promotions_codes) {
        ArrayList<String> promotions = new ArrayList(Arrays.asList(promotions_codes.split("\\s*, \\s*")));
        for (String promotion_code : promotions) {
             ArrayList<String> promotion = Database.get_instance().obtain_promotion(Integer.parseInt(promotion_code));
             table.addCell(create_cell_for_rows(String.format("%02d", Integer.valueOf(promotion.get(0)))));
             table.addCell(create_cell_for_rows(promotion.get(1)));
             table.addCell(create_cell_for_rows(promotion.get(2) + " Colones"));
             discount = discount + Integer.parseInt(promotion.get(2));
        }
    }
    public PdfPCell create_cell_for_rows(String row_cell) {
        PdfPCell cell = new PdfPCell(new Phrase(row_cell));
        cell.setHorizontalAlignment (Element.ALIGN_CENTER);
        cell.setPaddingBottom(5);
        return cell;
    }
    public PdfPTable create_promotions_table(String promotions) {
        PdfPTable table = new PdfPTable(3);
        try {
            table.setTotalWidth(new float[]{ 60, 250, 120});
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
        table.setLockedWidth(true);
        table.addCell(create_cell_for_columns("Codigo"));
        table.addCell(create_cell_for_columns("Promocion"));
        table.addCell(create_cell_for_columns("Descuento"));
        create_rows_for_promotions(table, promotions);
        return table;
    }
    public void add_client_information(Document document, ArrayList<String> client, PdfContentByte helper) {
        create_rectangle_for_client(helper);
        Paragraph line = new Paragraph();
        add_manual_padding(line, 8);
        try {
            document.add(line);
            line = new Paragraph(
                    "Cedula: " + client.get(0) + "\n" + 
                    "Nombre Completo: " + client.get(1) + "\n" + 
                    "Numero de Celular: +506 " + client.get(2) + "\n" + 
                    "Correo Electronico: " + client.get(3) + "\n"
            );
            line.setAlignment(Element.ALIGN_CENTER);
            document.add(line);
            line = new Paragraph();
            add_manual_padding(line, 2);
            document.add(line);
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
    }
    public void create_rectangle_for_client(PdfContentByte helper) {
        helper.setLineWidth(1f);
        helper.roundRectangle(25, 580, 540, 102, 5 );
        helper.moveTo(25,660);
        helper.lineTo(565,660);
        helper.stroke();
        create_heading(helper, 275, 667, "Cliente" , 12);
    }
    public  void add_manual_padding(Paragraph line, int number) {
        for (int iterator = 0; iterator < number; iterator++) {
                line.add(new Paragraph(" "));
        }
    }
    public PdfPTable create_subtotal_table() {
        PdfPTable table = new PdfPTable(3);
        try {
            table.setTotalWidth(new float[]{120, 120, 120});
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
        table.setLockedWidth(true);
        table.addCell(create_cell_for_columns("Sub-total"));
        table.addCell(create_cell_for_columns("Descuento"));
        table.addCell(create_cell_for_columns("Total"));
        table.addCell(create_cell_for_rows(subtotal + " Colones"));
        table.addCell(create_cell_for_rows(discount + " Colones"));
        int total = subtotal - discount;
        if (total < 0) {
            total = 0;
        }
        table.addCell(create_cell_for_rows(total + " Colones"));
        return table;
    }
    public void add_padding(Document pdf, int space) {
        Paragraph padding = new Paragraph();
        add_manual_padding(padding, space);
        try {
            pdf.add(padding);
        }
        catch (DocumentException ex) {
            System.err.println(ex);
        }
    }
    public void add_final_information(Document pdf) {
        Paragraph final_information = new Paragraph(
                """
                Firma del Cliente                                    Sello de Sh4dowtech\n\n
                _______________________                    _______________________\n\n
                Para hacer valida la garantia debe presentar la factura original con sello y firma del cliente\n
                Consulte nuestros servicios en sh4dowtech.github.io\n
                """);
        try {
            final_information.setAlignment(Element.ALIGN_CENTER);
            Image qr_code = Image.getInstance("/home/sh4dow18/NetBeansProjects/SGP/images/qr_code.png");
            qr_code.setAlignment(Element.ALIGN_CENTER);
            pdf.add(final_information);
            Paragraph qr_code_line = new Paragraph("Codigo QR de la pagina oficial de Sh4dowtech");
            qr_code_line.setAlignment(Element.ALIGN_CENTER);
            pdf.add(qr_code_line);
            pdf.add(qr_code);
        } 
        catch (DocumentException | IOException ex) {
            System.err.println(ex);
        }
    }
}
