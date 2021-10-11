/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml.xml;

import es.iespuertodelacruz.javier.monedasxml.entities.Historico;
import es.iespuertodelacruz.javier.monedasxml.entities.Moneda;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public class HistoricoXML implements JavaToXMLString<Historico>{

    @Override
    public String objToStringXML(Historico h) {
        String textoXML = null;

        return textoXML;        
    }

    @Override
    public Historico stringXMLToObj(String textoXML) {
        Historico h = null;

        return h;
    }
    
    
    
}
