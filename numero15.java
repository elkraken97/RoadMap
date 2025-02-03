import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class numero15 {
    public static void main(String[] args) {
        //funciones asincronas

        ejecutarTarea("primera tarea",5);
        try{
            TimeUnit.SECONDS.sleep(10);
            System.out.println("terminado");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void ejecutarTarea(String t, int i) {
        CompletableFuture.runAsync(()->{

                System.out.println("["+ LocalTime.now() +"]"+"tarea :"+t+" empezada esta durara "+i+" segundos");
                try{
                    TimeUnit.SECONDS.sleep(i);
                }catch (Exception e){
                    System.out.println(e);
                }
                System.out.println("["+ LocalTime.now() +"]"+"tarea :"+t+" a terminado");

        }
        );
    }
}
