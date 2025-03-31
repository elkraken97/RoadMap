package numero31;


import java.util.ArrayList;
import java.util.Objects;

public class Evento {
    private String nombreDelEvento;
    private String fecha;
    private final ArrayList<Participante> participantes = new ArrayList<>();

    public Evento(String nombreDelEvento, String fecha) {
        this.nombreDelEvento = nombreDelEvento;
        this.fecha = fecha;
    }

    public Evento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreDelEvento() {
        return nombreDelEvento;
    }

    public void setNombreDelEvento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;
    }

    public void agregarParticipante(Participante p){
        participantes.add(p);
    }
    public void eliminarParticipante(Participante p){
        participantes.remove(p);
    }


    @Override
    public String toString() {
        return "Evento{" +
                "nombreDelEvento='" + nombreDelEvento + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(nombreDelEvento, evento.nombreDelEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreDelEvento);
    }
}
