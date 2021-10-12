/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.monedasxml.xml;

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
public class MonedaXML implements JavaToXMLString<Moneda>{

    @Override
    public String objToStringXML(Moneda moneda) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringWriter stringWriter = new StringWriter();
        try {
            contexto = JAXBContext.newInstance(moneda.getClass());
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(moneda, stringWriter);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return stringWriter.toString();
        }
    }

    @Override
    public Moneda stringXMLToObj(String texto) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader stringReader = new StringReader(texto);
        Moneda moneda = null;
        try {
            contexto = JAXBContext.newInstance(Moneda.class);
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            moneda = (Moneda) unmarshaller.unmarshal(stringReader);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return moneda;
        }
    }
    
}
