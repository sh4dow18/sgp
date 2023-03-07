
package sgp.Utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
    private static SendEmail instance;
    
    public SendEmail() {
        instance = null;
    }
    
    public static SendEmail get_instance() {
        if (instance == null) {
            instance = new SendEmail();
        }
        return instance;
    }
    
    public int sent_email(String to, String filename) {
        int result = 0;
        Properties properties = System.getProperties();  
        properties.setProperty("mail.smtp.host", "smtp.office365.com");  
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {  
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication("XXXXXXXXXXXXXXXXX", "XXXXXXXXXXXXXXXXXXX");  
            }  
        });  
        try {
            String pdf_name = filename + ".pdf";
            String xml_name = filename + ".xml";
            String logo_file = filename + "-1_1.png";
            String qr_code_file = filename + "-1_2.png";
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress("XXXXXXXXXXXXXXXXXX"));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject("Su Factura Electronica de Sh4dowtech");  
            BodyPart messageBodyPart1 = new MimeBodyPart();  
            messageBodyPart1.setText("Te adjuntamos la factura electrónica en formato PDF.\n También encontrarás adjunto el comprobante electrónico en formato XML, emitido conforme lo establecido en la resolución de Facturación Electrónica No. DGT-R-033-2019 del 20 de Junio del 2019 de la Dirección General de Tributación Directa, en versión 4.3.");  
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
            MimeBodyPart messageBodyPart3 = new MimeBodyPart();  
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();  
            MimeBodyPart messageBodyPart5 = new MimeBodyPart();  
            DataSource source = new FileDataSource(pdf_name);
            DataSource source_2 = new FileDataSource(xml_name);
            DataSource source_3 = new FileDataSource(logo_file);
            DataSource source_4 = new FileDataSource(qr_code_file);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart3.setDataHandler(new DataHandler(source_2));
            messageBodyPart4.setDataHandler(new DataHandler(source_3));
            messageBodyPart5.setDataHandler(new DataHandler(source_4));
            messageBodyPart2.setFileName(pdf_name);  
            messageBodyPart3.setFileName(xml_name);  
            messageBodyPart4.setFileName(logo_file);  
            messageBodyPart5.setFileName(qr_code_file);  
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(messageBodyPart3);
            multipart.addBodyPart(messageBodyPart4);
            multipart.addBodyPart(messageBodyPart5);
            message.setContent(multipart );  
            Transport.send(message);  
         }
        catch (MessagingException ex) {
            result = 1;
            System.err.println(ex);
        } 
        return result;
    }
}
