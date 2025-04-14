package numero31;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evento {
    private String nombreDelEvento;
    private List<Participante> ganadores = new ArrayList<>();


    public Evento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;

    }

    public String getNombreDelEvento() {
        return nombreDelEvento;
    }

    public void setNombreDelEvento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;
    }

    public List<Participante> getGanadores() {
        return ganadores;
    }

    public void setGanadores(List<Participante> ganadores) {
        this.ganadores = ganadores;
    }
}
