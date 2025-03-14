package numero26SRP;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String desc;

    private String autor;
    private int copias;


    public Libro(String titulo, String desc, String autor, int copias) {
        this.titulo = titulo;
        this.desc = desc;

        this.autor = autor;
        this.copias = copias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", desc='" + desc + '\'' +
                ", autor='" + autor + '\'' +
                ", copias=" + copias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return copias == libro.copias && Objects.equals(titulo, libro.titulo) && Objects.equals(desc, libro.desc) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, desc, autor, copias);
    }
}
