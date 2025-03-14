package numero26SRP;

import java.util.ArrayList;
import java.util.List;

public class GestionLibros {

    private final List<Libro> libros = new ArrayList<>();


    public Libro buscarLibro(String titulo){
        for (Libro libro : libros) {
            if(libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }



    public void agregarLibro(Libro l){
        libros.add(l);
    }

    public void agregarLibro(String titulo,String descripcion,String autor,int copias){
        libros.add(new Libro(titulo,descripcion,autor,copias));
    }


    public void mostrarLibros(){
    libros.forEach(System.out::println);
    }



}
