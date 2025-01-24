package prob09;

public class Programador extends Empleado{
    public String tareas;
    public Programador(int id, String nombre) {
        super(id, nombre);
    }
    public Programador(int id, String nombre,String tareas) {
        super(id, nombre);
        this.tareas = tareas;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "tareas='" + tareas + '\'' +
                '}';
    }
}

