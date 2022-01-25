/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8066/quijote");
        for (int i = 0; i < 10; i++) {
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            System.out.println(new Date((long)uc.getDate()*1000));
            String txt ="";
            while ((inputLine = in.readLine()) != null) {
                txt = inputLine.replaceAll("</(h1|h2|h3|h4|h5|h6|p|title|br)>", "\n");
                txt = txt.replaceAll("<[^>]*>", ""); 
            }
            System.out.println(txt);
            in.close(); 
        }
    }
}
