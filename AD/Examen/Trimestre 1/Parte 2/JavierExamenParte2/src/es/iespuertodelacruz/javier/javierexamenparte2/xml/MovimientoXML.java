/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.javierexamenparte2.xml;

import es.iespuertodelacruz.javier.javierexamenparte2.model.Movimiento;
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
public class MovimientoXML implements JavaToXMLString<Movimiento>{

    @Override
    public String objToStringXML(Movimiento movimiento) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringWriter stringWriter = new StringWriter();
        try {
            contexto = JAXBContext.newInstance(movimiento.getClass());
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(movimiento, stringWriter);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return stringWriter.toString();
        }
    }

    @Override
    public Movimiento stringXMLToObj(String texto) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader stringReader = new StringReader(texto);
        Movimiento movimiento = null;
        try {
            contexto = JAXBContext.newInstance(Movimiento.class);
            marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            movimiento = (Movimiento) unmarshaller.unmarshal(stringReader);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally {
            return movimiento;
        }
    }
    
}
