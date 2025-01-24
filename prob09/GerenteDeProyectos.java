package prob09;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeProyectos extends Empleado{


    private List<Programador> ProgramadoresAcargo;
    private String commits;
    public GerenteDeProyectos(int id, String nombre,String commits) {
        super(id, nombre);
        this.commits = commits;
        this.ProgramadoresAcargo = new ArrayList<>();
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public List<Programador> getProgramadoresAcargo() {
        return ProgramadoresAcargo;
    }

    public void setProgramadoresAcargo(Programador programadorNuevo) {
        ProgramadoresAcargo.add(programadorNuevo);
    }

    @Override
    public String toString() {
        return "GerenteDeProyectos{" +
                "ProgramadoresAcargo=" + ProgramadoresAcargo.toString() +
                ", commits='" + commits + '\'' +
                '}';
    }
}
