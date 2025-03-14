package numero26;

import java.util.Objects;

public class Librow {
    private String titulo;
    private String desc;

    private String autor;
    private int copias;


    public Librow(String titulo, String desc, String autor, int copias) {
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
        Librow librow = (Librow) o;
        return copias == librow.copias && Objects.equals(titulo, librow.titulo) && Objects.equals(desc, librow.desc) && Objects.equals(autor, librow.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, desc, autor, copias);
    }
}
