/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesmtp;

import javax.mail.MessagingException;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException {
        
        String usuario = "";
        String password = "";
        
        String correo = "prueba1@gmail.com";
        
        String[] correos = {
            "prueba1@gmail.com",
            "prueba2@gmail.com",
            "prueba3@gmail.com"
        };
        
        ClienteSMTP clienteSMTP = new ClienteSMTP();
        
        // Credenciales del usuario que envia el correo
        clienteSMTP.setMailUser(usuario);
        clienteSMTP.setPassword(password);
        
        // Conexion con el servidor
        clienteSMTP.connectTo("smtp.gmail.com", "465");
        clienteSMTP.setSender(usuario);
        
        // Usuarios a los cuales queremos enviarle el correo
        clienteSMTP.addRecipient(correo);
        //clienteSMTP.addRecipinents(correos);
        
        // Asunto del correo
        clienteSMTP.setSubject("Prueba Cliente SMTP");
        // Contenido del correo
        clienteSMTP.setMailText("Esto es una prueba de un cliente");
        
        // Enviar el correo y recoger si todo ha salido bien o ha fallado algo
        if (clienteSMTP.send()) {
            System.out.println("Enviado correctamente");
        } else {
            System.out.println("Error al enviar el correo");
        }
    }
}
