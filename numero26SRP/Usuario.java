package numero26SRP;



import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private int ID;
    private static int count = 0;
    private String correo;
    private String password;
    private final List<Libro> prestados = new ArrayList<>();
    public Usuario(String correo, String nombre, String password) {
        this.correo = correo;
        this.password = password;
        this.ID = ++count;
        this.nombre = nombre;
    }

    public List<Libro> verPrestados(){
        return prestados;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", ID=" + ID +
                ", correo='" + correo + '\'' +
                '}';
    }

    public void devolverLibro(Libro librow){
        prestados.remove(librow);
    }
    public void agregarPrestado(Libro librow){
        prestados.add(librow);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
