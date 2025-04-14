package numero31;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlParticipantes {

    private final List<Participante> TodosLosParticipantes = new ArrayList<>();

    public Participante buscarParticipante(String nombre){
        for (Participante participante : TodosLosParticipantes) {
            if(Objects.equals(participante.getNombre(), nombre)){
                return participante;
            }
        }
        return null;
    }

    public List<Participante> buscarParticipantePorPais(String pais){
        List<Participante> especi = new ArrayList<>();
        for (Participante participante : TodosLosParticipantes) {
            if(Objects.equals(participante.getPais(), pais)){
                especi.add(participante);
            }
        }
        return especi.isEmpty()?especi:null;
    }
    public boolean agregarParticipante(String nombre,String pais){
        Participante nuevoParticipante = new Participante(nombre,pais);


        boolean agregado = TodosLosParticipantes.add(nuevoParticipante);

        return TodosLosParticipantes.contains(nuevoParticipante);
    }

    public List<Participante> getTodosLosParticipantes() {
        return TodosLosParticipantes;
    }

    public void mostrarParticipantes(){
        System.out.println("Particpantes:");
        for (Participante par : TodosLosParticipantes) {
            System.out.println(par);
        }
    }

}
