package numero26SRP;

public class LibreriaControlador {

    private final GestionLibros bookManager;

    public LibreriaControlador(GestionLibros bookManager) {
        this.bookManager = bookManager;
    }

    public boolean prestarLibro(Usuario usuario, String tituloLibro) {
        Libro libro = bookManager.buscarLibro(tituloLibro);
        if (libro != null && libro.getCopias() > 0) {
            libro.setCopias(libro.getCopias() - 1);
            usuario.agregarPrestado(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Usuario usuario, String tituloLibro) {
        for (Libro libro : usuario.verPrestados()) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libro.setCopias(libro.getCopias() + 1);
                usuario.devolverLibro(libro);
                return true;
            }
        }
        return false;
    }


}
