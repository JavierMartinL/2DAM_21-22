/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.javier.propietarioscasasxml.xml;

/**
 *
 * @author Javier Martin Lorenzo <javiermartin.gara@gmail.com>
 */
public interface JavaToXMLString<T> {
    
    String objToStringXML(T obj);
    
    T stringXMLToObj(String texto);
}
