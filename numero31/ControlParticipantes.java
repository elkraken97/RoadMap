package numero31;

import java.util.ArrayList;
import java.util.List;

public class ControlParticipantes {

    private final List<Participante> TodosLosParticipantes = new ArrayList<>();

    public Participante BuscarParticipante(String nombre){
        for (Participante participante : TodosLosParticipantes) {
            if(participante.equals(nombre)){
                return participante;
            }
        }
        return null;
    }

}
