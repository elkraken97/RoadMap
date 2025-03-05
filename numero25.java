import javax.swing.event.ListDataEvent;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.*;
class Tarea{
    private String Titulo;
    private String descripcion;
    private float duracion;

    public Tarea(String titulo, String descripcion,float duracion) {
        Titulo = titulo;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }
    public Tarea(String titulo){
        Titulo = titulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(Titulo, tarea.Titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Titulo);
    }
}
public class numero25 {
    private static Logger logerr = Logger.getLogger("Ejecutandose");
    private static ExecutorService ex = Executors.newCachedThreadPool();
    private static final Map<Tarea,CompletableFuture<Void>> Tareas = new HashMap();



    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logerr.addHandler(consoleHandler);
        logerr.setLevel(Level.ALL);
        //        Logger logInfo = Logger.getLogger("nuevo");
//        logInfo.setLevel(Level.ALL);
//        logInfo.log(Level.INFO,"hola");
//        logInfo.log(Level.WARNING,"a");
//        logInfo.log(Level.SEVERE,"a");
//        logInfo.log(Level.CONFIG,"a");
//        logInfo.log(Level.FINE,"a");


        /*
        Dificultad super extra
        * Crea un programa ficticio de gestión de tareas que permita añadir, eliminar
 * y listar dichas tareas.
 * - Añadir: recibe nombre y descripción.
 * - Eliminar: por nombre de la tarea.
 * Implementa diferentes mensajes de log que muestren información según la
 * tarea ejecutada (a tu elección).
 * Utiliza el log para visualizar el tiempo de ejecución de cada tarea.
 * Has que las tareas se ejecuten conforme el tiempo que se configuran aun con la posibilidad de eliminarlas
 * El tiempo de ejecucion es en minutos



         */
        Scanner sc = new Scanner(System.in);
        int op = 0;


        // Add a shutdown hook to stop tasks and shutdown executor when program exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            shutdownTasks();
            ex.shutdown();
            try {
                if (!ex.awaitTermination(60, TimeUnit.SECONDS)) {
                    ex.shutdownNow();
                }
            } catch (InterruptedException e) {
                ex.shutdownNow();
            }
            System.out.println("Program terminated.");
        }));
        boolean salir=true;
        while (salir) {
            System.out.println("""
                      Bienvenido al menu de Tareas 
                    1.-Agregar Una tarea
                    2.-Eliminar una tarea en ejecucion
                    3.-Salir (Esto eliminara todas las tareas tambien)  
                    """);
            op = sc.nextInt();
            if (op == 1) {
                System.out.println("Ingrese el titulo de la tarea");
                sc.nextLine();
                String t = sc.nextLine();
                System.out.println("Ingrese la descripcion de la tarea");
                String d = sc.nextLine();

                System.out.println("ingrese los minutos de ejecucion de la taea");
                float minutos = (sc.nextFloat() * 60000);
                Tarea T = new Tarea(t, d, minutos);
                ejecutarTarea(T);
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
            if (op == 2) {
                eliminarTarea(sc);
            }
            if(op==3){
                shutdownTasks();
                salir=false;
            }
        }
        shutdownTasks();
        ex.shutdown();
        sc.close();
    }

    private static void shutdownTasks() {
        for (Map.Entry<Tarea,CompletableFuture<Void>> entry : Tareas.entrySet()) {
            if (!entry.getValue().isDone()) {
                entry.getValue().cancel(true);
                logerr.log(Level.FINE, "Tarea " + entry.getKey().getTitulo() + " cancelada.");
            }
        }

        ex.shutdown();
        try {
            // Espera a que todas las tareas en el ExecutorService finalicen
            if (!ex.awaitTermination(3, TimeUnit.SECONDS)) {
                // Si no terminan en 60 segundos, forzamos la terminación
                ex.shutdownNow();
            }
        } catch (InterruptedException e) {
            ex.shutdownNow();  // Forzar la terminación si hay interrupciones
        }

        Tareas.clear();  // Clear the list of tasks
    }


    private static void eliminarTarea(Scanner sc) {
        if(!Tareas.isEmpty()){
            System.out.println("Lista de tareas:");
            int i = 0;
            for (Map.Entry<Tarea,CompletableFuture<Void>> entry : Tareas.entrySet()) {
                i++;
                System.out.println(i+".- "+ (entry.getKey()).getTitulo());
            }
            System.out.println("Dame el titulo de la tarea a eliminar");
            sc.nextLine();
            String tit = sc.nextLine();
            CompletableFuture<Void> cancelarTarea =  Tareas.get(new Tarea(tit));
            if(!cancelarTarea.isDone()){
                boolean cancelada = cancelarTarea.cancel(true);
                if (cancelada) {
                    logerr.log(Level.FINE, "Tarea " + tit + " cancelada correctamente.");
                } else {
                    logerr.log(Level.WARNING, "No se pudo cancelar la tarea " + tit);
                }

            }else{
                System.out.println("La tarea ya a sido completada");
            }
            Tareas.remove(new Tarea(tit));
        }else{
            System.out.println("Lista de tareas vacia agrega alguna para cancelarla");
        }

    }

    private static void ejecutarTarea(Tarea t) {
    CompletableFuture<Void> ejecutarEsto = CompletableFuture.runAsync(()->{

            try{
                logerr.log(Level.FINE,"Ejecutando tarea "+t.getTitulo()+"......");
                for (int i = 0; i < t.getDuracion() / 1000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        // Si el hilo es interrumpido, salimos de inmediato
                        throw new InterruptedException("La tarea fue interrumpida.");
                    }
                    Thread.sleep(1000); // Dormir por 1 segundo (se repite para simular ejecución por varios segundos)
                }

                Thread.sleep((long) t.getDuracion());
                logerr.log(Level.FINE,"Tarea "+t.getTitulo()+" Ejecutada");



                Tareas.remove(t);
            }catch (Exception e){
                System.out.println("Tarea "+t.getTitulo()+" Interrumpida");
            }

            }
    ,ex
    );
    Tareas.put(t,ejecutarEsto);

    }


}
