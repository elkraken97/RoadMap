package numero26SRP;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {

    private final  List<Usuario> u = new ArrayList<>();

    public void registrarUsuario(Usuario user){
    u.add(user);
    }

    public void registrarUsuario(String nombre,String correo,String contrasena){
        u.add(new Usuario(correo,nombre,contrasena));
    }

    public Usuario autenticar(String nombre,String contrasena){
        for (Usuario usuario : u) {
            if(usuario.getNombre().equals(nombre)&&usuario.getPassword().equals(contrasena)){
                return usuario;
            }
        }


        return null;
    }
    public Usuario autenticar(int ID, String contrasena){
        for (Usuario usuario : u) {
            if(usuario.getID()==ID&&usuario.getPassword().equals(contrasena)){
                return usuario;
            }
        }


        return null;
    }
}
