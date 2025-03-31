package numero31;

import java.util.ArrayList;
import java.util.List;

public class ControlParticipantes {

    private final List<Participante> TodosLosParticipantes = new ArrayList<>();

    public Participante buscarParticipante(String nombre){
        for (Participante participante : TodosLosParticipantes) {
            if(participante.equals(nombre)){
                return participante;
            }
        }
        return null;
    }
    public boolean agregarParticipante(String nombre, int edad, Character genero, double altura, double peso,String evento){
        Participante nuevoParticipante = new Participante(nombre,  edad,  genero,  altura,  peso,evento);


        boolean agregado = TodosLosParticipantes.add(nuevoParticipante);

        return TodosLosParticipantes.contains(nuevoParticipante) && agregado;
    }
    public void mostrarParticipantes(){
        System.out.println("Particpantes:");
        for (Participante par : TodosLosParticipantes) {
            System.out.println(par);
        }
    }

}
