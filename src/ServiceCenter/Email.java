/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceCenter;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Shehan Atapattu
 */
public class Email {
    public void send2(String path,String fname) {

    
    
  

    final String username = "chamlishehan123@gmail.com"; //ur email
    final String password = "0712881618";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("chamlishehan123@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("shanuka.bps@gmail.com"));//u will send to
        message.setSubject("Reorder Items");    
        message.setText("PFA");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();


     
     
    //attached 1 --------------------------------------------
        String file = path;
        String fileName = fname;
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
    //------------------------------------------------------    
     
//     //attached 2 --------------------------------------------  
//       String file2="path of file";
//       String fileName2 = "AnyName2";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source2 = new FileDataSource(file2);      
//    messageBodyPart.setDataHandler(new DataHandler(source2));
//    messageBodyPart.setFileName(fileName2);
//    multipart.addBodyPart(messageBodyPart);
//  //attached 3------------------------------------------------
//       
//       String file3="path of file";
//       String fileName3 = "AnyName3";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source3 = new FileDataSource(file3);      
//    messageBodyPart.setDataHandler(new DataHandler(source3));
//    messageBodyPart.setFileName(fileName3);
//    multipart.addBodyPart(messageBodyPart);
//    //attached 4------------------------------------------------
//    String file4="path of file";
//       String fileName4 = "AnyName4";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source4 = new FileDataSource(file4);      
//    messageBodyPart.setDataHandler(new DataHandler(source4));
//    messageBodyPart.setFileName(fileName4);
//    multipart.addBodyPart(messageBodyPart);
//    //>>>>>>>>
   
    
    
        message.setContent(multipart);

       
        System.out.println("sending");
        
        try{
        Transport.send(message);
        System.out.println("E-mail sent ");
        JOptionPane.showMessageDialog(null, "Email Sent");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in connecting to server....\nPlease Check your internet connection");
        }
            
}catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}
