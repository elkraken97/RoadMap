package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
public class Main {
    public static void main(String[] args) {

    ObjectMapper mapper = new ObjectMapper();
    List<String> e = new ArrayList<>();
    e.add("python");
    e.add("java");
    e.add("barinfuck");
        Persona persona1 = new Persona("pablito",18,"2006/12/18",e);
        Persona persona2 = new Persona("pepe",22,"23434",e);
        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
    try{
        File f = new File("personas.json");
        mapper.writeValue(f,personas);

       List<Persona> personasLeidas = mapper.readValue(new File("personas.json"),mapper.getTypeFactory().constructCollectionType(List.class,Persona.class));


       personasLeidas.forEach(System.out::println);


    /*   List<Persona> personasLeidasc = mapper.readValue(new File("personas.json"),mapper.getTypeFactory()
               .constructCollectionType(List.class,Persona.class));*/
       /* personasLeidasc.forEach(System.out::println);*/

    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
    }

}
