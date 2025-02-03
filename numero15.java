import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class numero15 {
    public static void main(String[] args) {
        //funciones asincronas
/*
        ejecutarTarea("primera tarea",5);*/
      /*  try{
            TimeUnit.SECONDS.sleep(10);
            System.out.println("terminado");
        }catch (Exception e){
            System.out.println(e);
        }*/

        CompletableFuture<Void> tareaA = tareas("Tarea A", 1);
        CompletableFuture<Void> tareaB = tareas("Tarea B", 2);
        CompletableFuture<Void> tareaC = tareas("Tarea C", 3);

        CompletableFuture.allOf(tareaA,tareaB,tareaC).thenRun(
                ()->{
                    tareas("Tarea D",1).join();
                }

        ).join();
    }

    private static CompletableFuture tareas(String primeraTarea, int i) {

        return CompletableFuture.runAsync(()->{

            System.out.println("["+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"]"+"Tarea: "+ primeraTarea +" Iniciada "+" dura: "+ i +" segundos");
            try{
                TimeUnit.SECONDS.sleep(i);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("["+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"]"+"Tarea: "+primeraTarea+" Finalizada");
        });
    }









    /*private static void ejecutarTarea(String t, int i) {
        CompletableFuture.runAsync(()->{

                System.out.println("["+ LocalTime.now() +"]"+"tarea :"+t+" empezada esta durara "+i+" segundos");
                try{
                    TimeUnit.SECONDS.sleep(i);
                }catch (Exception e){
                    System.out.println(e);
                }
                System.out.println("["+ LocalTime.now() +"]"+"tarea :"+t+" a terminado");

        }*/

    }

