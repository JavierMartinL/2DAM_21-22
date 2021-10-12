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
    public String objToStringXML(Historico historico) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringWriter stringWriter = new StringWriter();
        try {
            contexto = JAXBContext.newInstance(historico.getClass());
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(historico, stringWriter);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return stringWriter.toString();
        }       
    }

    @Override
    public Historico stringXMLToObj(String texto) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader stringReader = new StringReader(texto);
        Historico historico = null;
        try {
            contexto = JAXBContext.newInstance(Moneda.class);
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            historico = (Historico) unmarshaller.unmarshal(stringReader);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return historico;
        }
    }
    
    
    
}
