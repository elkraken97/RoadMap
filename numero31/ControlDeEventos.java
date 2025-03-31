package numero31;

import java.util.ArrayList;
import java.util.List;

public class ControlDeEventos {
    private final ControlParticipantes control = new ControlParticipantes();
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
                evento.agregarParticipante(control.BuscarParticipante(nombre));
                return true;
            }
        }
            return false;
    }

}
