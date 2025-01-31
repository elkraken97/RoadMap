package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class ListadePersonas{
    private List<Persona> listadepersonas = new ArrayList<>();

    public ListadePersonas(){}

    public ListadePersonas(List<Persona> listadepersonas) {
        this.listadepersonas = listadepersonas;
    }

    @XmlElement
    public List<Persona> getListadepersonas() {
        return listadepersonas;
    }

    public void setListadepersonas(List<Persona> listadepersonas) {
        this.listadepersonas = listadepersonas;
    }
}
