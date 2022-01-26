/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesmtp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class ClienteSMTP {

    private String mailUser;
    private String password;
    private Properties properties;
    private Session session;
    private Message message;
    
    public ClienteSMTP() {
    }
    /**
     * Método que inicializa las propiedades y autentifica al usuario
     * @param server Servidor al cual queremos conectarnos
     * @param pport Puerto del servidor por el cual conectarnos
     */
    void connectTo (String server, String pport) {
        // Propiedades para la conexion con el servidor
        properties = new Properties();
        properties.put("mail.smtp.host", server);
        properties.put("mail.smtp.socketFactory.port", pport);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", pport);

        // Autentificar el usuario que quiere enviar el correo
        session = Session.getDefaultInstance(properties,
            new javax.mail.Authenticator() {

              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailUser, password);
              }
            });
    }

    /**
     * Método para agregar un grupo de receptores
     * @param recipients Lista de correos 
     * @throws MessagingException 
     */
    void addRecipinents(String[] recipients) throws MessagingException {
        InternetAddress[] internetAddress = new InternetAddress[recipients.length];
        
        for (int i = 0; i < recipients.length; i++) {
            internetAddress[i] = new InternetAddress(recipients[i]);
        }
        
        message.setRecipients(
                Message.RecipientType.TO,
                internetAddress);
    }

    /**
     * Método para agregar un unico receptor
     * @param recipient Correo del receptor
     * @throws MessagingException 
     */
    void addRecipient(String recipient) throws MessagingException {
        message.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(recipient)
        );
    }

    /**
     * Método que inicializa el correo y agrega el emisor del correo
     * @param psender Correo del emisor
     * @throws AddressException
     * @throws MessagingException 
     */
    void setSender(String psender) throws AddressException, MessagingException {
        message = new MimeMessage(session);
        message.setFrom(new InternetAddress(psender));
    }

    /**
     * Método que agrega el Asunto al correo
     * @param subject
     * @throws MessagingException 
     */
    void setSubject(String subject) throws MessagingException {
        message.setSubject(subject);
    }

    /**
     * Meétodo que agrega el contenido del correo
     * @param pbody
     * @throws MessagingException 
     */
    void setMailText(String pbody) throws MessagingException {
        message.setText(pbody);
    }

    /**
     * Método que envia el correo a uno o varios receptores
     * @return 
     */
    boolean send() {
        try {
            Transport.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
