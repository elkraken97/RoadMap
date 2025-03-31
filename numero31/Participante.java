package numero31;

import java.util.Objects;

public class Participante {

    private String nombre;
    private int edad;
    private Character Genero;
    private double altura;
    private double peso;
    private String NombreDelEventoAPArticipar;
    public Participante(String nombre, int edad, Character genero, double altura, double peso,String NombreDelEventoAPArticipar) {
        this.nombre = nombre;
        this.edad = edad;
        Genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.NombreDelEventoAPArticipar = NombreDelEventoAPArticipar;
    }

    public String getNombreDelEventoAPArticipar() {
        return NombreDelEventoAPArticipar;
    }

    public void setNombreDelEventoAPArticipar(String nombreDelEventoAPArticipar) {
        NombreDelEventoAPArticipar = nombreDelEventoAPArticipar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Character getGenero() {
        return Genero;
    }

    public void setGenero(Character genero) {
        Genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String
    toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Genero=" + Genero +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}



