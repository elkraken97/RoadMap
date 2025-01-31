package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XML {
    public static void main(String[] args) {
        List<String> lenguajes = new ArrayList<>();
        lenguajes.add("C++");
        Persona persona  = new Persona("lucas", 22, "3323", lenguajes);
        Persona persona2 = new Persona("pepe", 22, "3323", lenguajes);
        Persona persona3 = new Persona("chacho", 22, "3323", lenguajes);
        List<Persona> l = new ArrayList<>();
        l.add(persona);
        l.add(persona2);
        l.add(persona3);
        ListadePersonas lista = new ListadePersonas(l);
        try {
            JAXBContext contexto = JAXBContext.newInstance(ListadePersonas.class);
            Marshaller serializador = contexto.createMarshaller();

            serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            serializador.marshal(lista,new File("persona.xml"));

            Unmarshaller deserizalizador = contexto.createUnmarshaller();
            ListadePersonas nueva = (ListadePersonas) deserizalizador.unmarshal(new File("persona.xml"));

           for(Persona p: nueva.getListadepersonas()){
               System.out.println(p);
           }



        } catch (JAXBException e) {
            System.out.println("error" + e);
        }
    }
}

