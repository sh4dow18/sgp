
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
                return new PasswordAuthentication("XXXXXXXXXXXX", "XXXXXXXXXXXXXXX");  
            }  
        });  
        try{  
          MimeMessage message = new MimeMessage(session);  
          message.setFrom(new InternetAddress("XXXXXXXXXXXXXXXX"));  
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
          message.setSubject("Message Alert");  
          BodyPart messageBodyPart1 = new MimeBodyPart();  
          messageBodyPart1.setText("This is message body");  
          MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
          DataSource source = new FileDataSource(filename);  
          messageBodyPart2.setDataHandler(new DataHandler(source));  
          messageBodyPart2.setFileName(filename);  
          Multipart multipart = new MimeMultipart();  
          multipart.addBodyPart(messageBodyPart1);  
          multipart.addBodyPart(messageBodyPart2);  
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
