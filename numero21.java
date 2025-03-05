//PRIMER MODELO DE CALLBACKS
//interface Callback{
//    void TareaCompletada(String entrada);
//}
//
//class TareasHelper implements  Callback{
//
//    @Override
//    public void TareaCompletada(String entrada) {
//        System.out.println("Tarea "+entrada+" completada");
//    }
//
//}
//class Tarea {
//    public void CorriendoTarea(String nombre){
//        try{
//            System.out.println("Tarea en proceso");
//            Thread.sleep(2000);
//            TareasHelper t = new TareasHelper();
//            t.TareaCompletada(nombre);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}
//public class numero21 {
//
//
//    public static void main(String[] args) {
//        Tarea tarea = new Tarea();
//        System.out.println("Tarea 5 corriendo");
//        tarea.CorriendoTarea("tarea 5");
//    }
//}


import java.util.Random;

//SEGUNDO MODELO DE CALLBACKS
//interface CallBack{
//    void Complete(String a);
//}
//class Task {
//    public void ProcesarTarea(String nombre,CallBack c){
//        new Thread(()->{
//            try {
//                System.out.println("Tarea Iniciada");
//                System.out.println("Cargando Tarea.....");
//                Thread.sleep(3000);
//                c.Complete(nombre);
//            }catch (Exception e) {
//                System.out.println(e);
//            }
//
//        }).start();
//
//    }
//
//
//}
//public class numero21{
//    public static void main(String[] args) {
//
//
//        Task tarea = new Task();
//        tarea.ProcesarTarea("tarea 1",a -> {
//            System.out.println("tarea: "+a+" Completada");
//        });
//    }
//}

// Dificultad Extra
interface Pedidos{
    void Platillo(String nombre);
}
class Cocina{
    public void Proceso(String nombre,Pedidos confirmacion,Pedidos listo,Pedidos Entrega){
        Random a = new Random();
        new Thread(()->{

            try {
                confirmacion.Platillo(nombre);
                Thread.sleep(a.nextInt(10000)+1000);
                listo.Platillo(nombre);
                Thread.sleep(a.nextInt(10000)+1000);
                Entrega.Platillo(nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }


}
public class numero21{
    public static void main(String[] args) {
        Cocina c = new Cocina();
        c.Proceso("guacamole",confirmacion->{
            System.out.println("Platillo "+confirmacion + " Siendo Ejecutada..");
        },listo->{
            System.out.println("Entregando Platillo "+listo);
        },Entrega->{
            System.out.println("Platillo "+Entrega+" Entregado");
        });
    }
}



