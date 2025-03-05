package numero26;

public class Libro {
    private String titulo;
    private String desc;
    private boolean prestado;
    private String autor;
    private int copias;


    public Libro(String titulo, String desc, String autor, int copias) {
        this.titulo = titulo;
        this.desc = desc;
        this.prestado = false;
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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
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
                ", prestado=" + prestado +
                ", autor='" + autor + '\'' +
                ", copias=" + copias +
                '}';
    }
}
