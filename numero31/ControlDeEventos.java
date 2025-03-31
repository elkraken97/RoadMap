package numero31;

import java.util.ArrayList;
import java.util.List;

public class ControlDeEventos {
    private ControlParticipantes control;
    public ControlDeEventos(ControlParticipantes controol){
        this.control = controol;
    }
    private final List<Evento> Eventos = new ArrayList<>();

    public boolean CrearEvento(String nombre,String fecha){

        Evento nuevoEvento = new Evento(nombre, fecha);


        boolean agregado = Eventos.add(nuevoEvento);

        return Eventos.contains(nuevoEvento) && agregado;

    }
    public void EliminarEvento(Evento e){
        System.out.println("!!!Advertencia al eliminar eventos tambien eliminara este evento de la lista de personas\n"+"que tengan este evento registrado");
        Eventos.remove(e);
    }
    public boolean FicharParticipante(String nombre,String NombreEvento){

        for (Evento evento : Eventos) {
            if(evento.equals(NombreEvento)){
                Participante p = control.buscarParticipante(nombre);
                if(p != null)evento.agregarParticipante(p);
                return true;
            }
        }
            return false;
    }


    public Evento buscarEvento(String nombre){
        for (Evento evento : Eventos) {
            if(evento.equals(nombre)){
                return evento;
            }
        }
        return null;
    }
    public void mostrarEventos(){
        System.out.println("Eventos Disponibles");
        for (Evento evento : Eventos) {
            System.out.println(evento.getNombreDelEvento());
        }
    }

}
