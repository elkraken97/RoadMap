class Usuario{
    private int id;
    private String nombre;
    private String email;

    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
class Singleton{
    public Usuario usuario;

    public Usuario getUsuario() {
        if(usuario == null){
           this.usuario = new Usuario(1,"hola","adios");
        }
        return usuario;
    }
    public void deleteUsuario(){
        if(usuario!=null){
            this.usuario = null;
        }

    }
}
public class numero23 {
    public static void main(String[] args) {
        Singleton s = new Singleton();
        System.out.println(s.getUsuario());

    }
//Singleton modelo
    class E{
        private final E e = new E();

        public E(){}
        public synchronized E getInstancia(){
            if(e==null){
                return new E();
            }
            return e;
        }


}


}
