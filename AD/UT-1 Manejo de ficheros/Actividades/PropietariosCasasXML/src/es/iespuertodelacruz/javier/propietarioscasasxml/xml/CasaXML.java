/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.propietarioscasasxml.xml;

import es.iespuertodelacruz.javier.propietarioscasasxml.entities.Casa;
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
public class CasaXML implements JavaToXMLString<Casa>{

    @Override
    public String objToStringXML(Casa casa) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringWriter stringWriter = new StringWriter();
        try {
            contexto = JAXBContext.newInstance(casa.getClass());
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(casa, stringWriter);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return stringWriter.toString();
        }
    }

    @Override
    public Casa stringXMLToObj(String texto) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader stringReader = new StringReader(texto);
        Casa casa = null;
        try {
            contexto = JAXBContext.newInstance(Casa.class);
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            casa = (Casa) unmarshaller.unmarshal(stringReader);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return casa;
        }
    }
    
}
