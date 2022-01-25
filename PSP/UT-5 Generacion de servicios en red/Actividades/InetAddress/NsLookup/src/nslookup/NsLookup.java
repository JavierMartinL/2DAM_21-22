/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nslookup;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class NsLookup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pattern pattern;
        NsLookup prog;
        
        if (args.length == 0) {
            System.out.println("Error de sintaxis. Es necesario escribir el pedido seguido de un valor IP o del nombre de un host: NsLookup [hostName][ipValue]");
            return;
        }
        
        prog = new NsLookup();
        String param = args[0];
        
        try {
            if (prog.isIpAddress(param))
                prog.showHost(param);
            else
                prog.showIps(param);
        } catch (Exception e) {
            System.out.println("Error, host desconocido: " + args[0]);
        }
    }
    
    private void showIps(String host) throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName(host);
        System.out.println("Answer:");
        for (InetAddress in : address) {
            System.out.println("Name: \t " + in.getHostName());
            System.out.println(" Address: \t " + in.getHostAddress());
        }
    }

    private void showHost(String ip) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(ip);
        System.out.println("Answer:");
        System.out.println(" Address: \t " + address.getHostAddress());
        System.out.println("Name: \t " + address.getHostName());
    }
    
    private boolean isIpAddress(String cad) {
        return isIpV4(cad) || isIpV6(cad);
    }
    
    private boolean isIpV4(String cad) {
        boolean ret;
        String[] strBytes = cad.split(".");
        ret = strBytes.length == 4;
        ret = ret && strBytes[0].matches(".d{1,3}");
        return ret;
    }
    
    private boolean isIpV6(String cad) {
        int i = 0;
        boolean ret;
        String[] strBytes = cad.split(":");
        ret = strBytes.length > 0;
        while (ret && strBytes[i].isEmpty()) {
            i++;
        }
        ret = ret && strBytes[i].matches("[0-9A-Fa-f]{1,4}");
        return ret;
    }
    
}
