package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;
@XmlRootElement
public class Persona {
    private String Nombre;
    private int Edad;
    private String fechadenacmiento;
    private List<String> LenguajesDeProgramacion;

    public Persona(){}

    public Persona(String nombre, int edad, String fechadenacmiento, List<String> lenguajesDeProgramacion) {
        this.Nombre = nombre;
        this.Edad = edad;
        this.fechadenacmiento = fechadenacmiento;
        this.LenguajesDeProgramacion = lenguajesDeProgramacion;
    }
    @XmlElement
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    @XmlElement
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
    @XmlElement
    public String getFechadenacmiento() {
        return fechadenacmiento;
    }

    public void setFechadenacmiento(String fechadenacmiento) {
        this.fechadenacmiento = fechadenacmiento;
    }
    @XmlElement
    public List<String> getLenguajesDeProgramacion() {
        return LenguajesDeProgramacion;
    }

    public void setLenguajesDeProgramacion(List<String> lenguajesDeProgramacion) {
        LenguajesDeProgramacion = lenguajesDeProgramacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                ", fechadenacmiento='" + fechadenacmiento + '\'' +
                ", LenguajesDeProgramacion=" + LenguajesDeProgramacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Edad == persona.Edad && Objects.equals(Nombre, persona.Nombre) && Objects.equals(fechadenacmiento, persona.fechadenacmiento) && Objects.equals(LenguajesDeProgramacion, persona.LenguajesDeProgramacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Edad, fechadenacmiento, LenguajesDeProgramacion);
    }
}
