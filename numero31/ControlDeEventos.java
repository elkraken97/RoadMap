package numero31;

import java.util.*;

public class ControlDeEventos {
    private final ControlParticipantes control;
    public ControlDeEventos(ControlParticipantes controol){
        this.control = controol;
    }
    private final List<Evento> Eventos = new ArrayList<>();


    public List<Evento> getEventos() {
        return Eventos;
    }

    public boolean CrearEvento(String nombre){

        Evento nuevoEvento = new Evento(nombre);


            Eventos.add(nuevoEvento);

        return Eventos.contains(nuevoEvento) ;

    }

    public boolean HayEventos(){
        return !Eventos.isEmpty();
    }

    public String SimularEventos(){
        String eventos= "";
        for (Evento evento : Eventos) {
            List<Participante> p =control.getTodosLosParticipantes();
            Collections.shuffle(p);

            evento.setGanadores(Arrays.asList(p.get(0),p.get(1),p.get(2)));
            eventos += "Evento: " + evento.getNombreDelEvento() + "\n" +
                    "Primer lugar: " + p.get(0).toString() + "\n" +
                    "Segundo lugar: " + p.get(1).toString() + "\n" +
                    "Tercer lugar: " + p.get(2).toString();


        }
        return eventos;


    }




}
