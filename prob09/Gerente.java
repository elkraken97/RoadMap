package prob09;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Empleado{
    private String reporte;
    private List<GerenteDeProyectos> ProyectosAcargo;

    public Gerente(int id, String nombre) {
        super(id, nombre);
        this.ProyectosAcargo = new  ArrayList<>();
    }
    public Gerente(int id, String nombre,String reporte) {
        super(id, nombre);
        this.reporte = reporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
    public void agregarProyectoAcargo(GerenteDeProyectos proyecto){
        this.ProyectosAcargo.add(proyecto);
    }
    public List<GerenteDeProyectos> ObtenerProyectosAcargo(){
        return this.ProyectosAcargo;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "reporte='" + reporte + '\'' +
                ", ProyectosAcargo=" + ProyectosAcargo +
                '}';
    }
}
