import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
class Estudiante{
    private String nombre;
    private LocalDate fecha;
    private List<Float> calificaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Float> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Float> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Estudiante(String nombre, LocalDate fecha, List<Float> calificaciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", calificaciones=" + calificaciones +
                '}';
    }
}
public class numero22 {
    //funciones de orden superior

    public static void main(String[] args) {
//        Function<Integer, String> multiplicar = a -> "Hola paciente numero:" + a;
//
//
//        String b = multiplicar.apply(2);
//        System.out.println(b);
        administrar();


/**/
    }

    private static void administrar() {
        Function<Estudiante,Float> Promedio = e -> (float) e.getCalificaciones().stream().mapToDouble(Float::floatValue).average().orElse(0.0);
        Function<List<Estudiante>,Float> CalfMasAlta = l -> (float) l.stream().mapToDouble(
                e ->  e.getCalificaciones().stream().mapToDouble(Float::floatValue).max().orElse(0.0f)).max().orElse(0.0);
        System.out.println("Promedios de la clase:");
        HashMap<String ,Float> a =  Promedios(Promedio,ListaDeEstduiantes());
        a.forEach((s,f)-> System.out.println("Nombre:"+s+" Promedio:"+f));
        System.out.println("Mejores de la clase:");
        List<String> mejores = MejoresEstudiantes(Promedio,ListaDeEstduiantes());
        mejores.forEach(System.out::println);
        System.out.println("Orden de nombres por el mas joven:");
        Ordenoven(ListaDeEstduiantes()).forEach(System.out::println);
        System.out.println("Calificacion mas alta de todas:");
        System.out.println(CalfMasAlta.apply(ListaDeEstduiantes()));


    }



    public static HashMap<String,Float> Promedios(Function<Estudiante,Float> f,List<Estudiante> lista){
        HashMap<String,Float> a = new HashMap<>();
        lista.forEach(e->a.put(e.getNombre(),f.apply(e)));
        return a;
    }
    public static List<String> MejoresEstudiantes(Function<Estudiante,Float> f,List<Estudiante> lista){
        List<String> m = new ArrayList<>();
        lista.forEach(e-> {
            if(f.apply(e)>=9.0f){
                m.add(e.getNombre());
            }

                }
        );
        return m;
    }


    public static List<Estudiante> Ordenoven(List<Estudiante> e){

        e.sort(Comparator.comparing(Estudiante::getFecha));

        return e;
    }

    public static List<Estudiante> ListaDeEstduiantes(){
        return new ArrayList<>(List.of(new Estudiante("Pablo", LocalDate.of(2002, 2, 21), Arrays.asList(25f, 30f, 40f, 50f)),
                new Estudiante("Ana", LocalDate.of(2001, 5, 15), Arrays.asList(35f, 45f, 50f, 60f)),
                new Estudiante("Luis", LocalDate.of(2003, 8, 10), Arrays.asList(20f, 25f, 35f, 45f)),
                new Estudiante("Sofía", LocalDate.of(2002, 12, 5), Arrays.asList(40f, 50f, 60f, 70f)),
                new Estudiante("Carlos", LocalDate.of(2001, 3, 27), Arrays.asList(30f, 40f, 50f, 60f))));
    }
}
