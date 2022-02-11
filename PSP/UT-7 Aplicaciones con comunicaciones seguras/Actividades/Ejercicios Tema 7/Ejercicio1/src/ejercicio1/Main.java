/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Main {

    private String usuario;
    private String password;
    private KeyGenerator keyGenerator;
    private SecureRandom secureRandom;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    int cantBytes;
    
    /**
     * Se encarga de cifrar un fichero
     * @param urlFichero ruta del fichero base
     * @return llave con la cual descifrar el fichero.cifrado
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    private SecretKey cifrar(String urlFichero) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
            FileNotFoundException, IOException,IllegalBlockSizeException, BadPaddingException{
        keyGenerator = KeyGenerator.getInstance("Rijndael");
        secureRandom = new SecureRandom((usuario + password).getBytes());
        keyGenerator.init(128, secureRandom);
        SecretKey llave = keyGenerator.generateKey();
        
        //Crear el Cipher
        System.out.println("\nLlave: ");
        System.out.write(llave.getEncoded(), 0, llave.getEncoded().length );
        
        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, llave);
        
        System.out.println("\n\nCifrar el fichero \"" + urlFichero + "\" y crea \"" + urlFichero + ".cifrado\"");
              
        byte[] buffer = new byte[1000];
        byte[] bufferCifrado;
        fileInputStream = new FileInputStream(urlFichero); 
        fileOutputStream = new FileOutputStream(urlFichero + ".cifrado"); 

        // Leer el fichero cifrado y guardarlo en el nuevo fichero cifrado
        cantBytes = fileInputStream.read(buffer, 0, 1000);
        while (cantBytes != -1) {
            bufferCifrado = cipher.update(buffer, 0, cantBytes);
            fileOutputStream.write(bufferCifrado);
            cantBytes = fileInputStream.read(buffer, 0, 1000);
        }
        bufferCifrado = cipher.doFinal(); 
        
        fileOutputStream.write(bufferCifrado); 
        fileInputStream.close();
        fileOutputStream.close();
        return llave;
    }
    
    /**
     * Se encarga de descifrar un fichero cifrado
     * @param llave de cifrado
     * @param ficheroCifrado ruta del fichero cifrado
     * @param ficheroDescifrado ruta del fichero descifrado
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    private void descifrar(SecretKey llave, String ficheroCifrado, String ficheroDescifrado) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
            FileNotFoundException, IOException, IllegalBlockSizeException, BadPaddingException {
        
        // Creamo el cipher y lo ponemos en modo decifrar
        Cipher cipher = Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, llave);
        
        System.out.println("\nCifrar el fichero \"" + ficheroCifrado + "\" y crea \"" + ficheroDescifrado + "\"");
        
        fileInputStream = new FileInputStream(ficheroCifrado);
        fileOutputStream = new FileOutputStream(ficheroDescifrado);
        
        byte[] bufferPlano;
        byte[] buffer = new byte[1000];
        
        // Leer el fichero cifrado y guardarlo en el nuevo fichero
        cantBytes = fileInputStream.read(buffer, 0, 1000);
        while (cantBytes != -1) {
            bufferPlano = cipher.update(buffer, 0, cantBytes);
            fileOutputStream.write(bufferPlano);
            cantBytes = fileInputStream.read(buffer, 0, 1000);
        }
        bufferPlano = cipher.doFinal();
        
        fileOutputStream.write(bufferPlano);
        
        fileInputStream.close();
        fileOutputStream.close();
        // Mostrar el contenido del fichero
        mostrarFichero(ficheroDescifrado);
    }
    
    /**
     * Se encarga de mostrar el contenido de un Fichero
     * @param fichero ruta del fichero
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void mostrarFichero(String fichero) throws FileNotFoundException, IOException {
        System.out.println("\n\t*** Contenido del Fichero descifrado ***\n");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
        String salida = "";
        while ((salida = bufferedReader.readLine()) != null) {
            System.out.println(salida);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Main main = new Main();
        SecretKey llave;
        Scanner sc = new Scanner(System.in);
        
        // Recoger el usuario y la contraseña
        System.out.print("Usuario: ");
        main.setUsuario(sc.nextLine());
        System.out.print("Contraseña: ");
        main.setPassword(sc.nextLine());
        
        // ciframos el fichero y luego lo desciframos con la llave
        try {
            llave = main.cifrar("fichero");
            main.descifrar(llave, "fichero.cifrado", "fichero.descifrado");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
