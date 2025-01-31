package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DificultadExtra {
    public static void main(String[] args) {
        try{
          /*  ObjectMapper json = new ObjectMapper();
            List<Persona> p =  json.readValue(new File("personas.json"),json.getTypeFactory().constructCollectionType(List.class,Persona.class));
            System.out.println("Contenido Json a objetos Java:");
            p.forEach(System.out::println);
            System.out.println();
            System.out.println("contenido XML a objetos java:");*/



            JAXBContext context = JAXBContext.newInstance(ListadePersonas.class);
            Unmarshaller d = context.createUnmarshaller();
            ListadePersonas lista = (ListadePersonas) d.unmarshal(new File("persona.xml"));
            for(Persona a : lista.getListadepersonas()){
                System.out.println(a);
            }
            ObjectMapper leer = new ObjectMapper();

            leer.writeValue(new File("personas.json"),lista);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
