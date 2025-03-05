import java.util.Scanner;

public class numero19 {
 /*   public enum Semana{
        LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO
    }*/
    public static void main(String[] args) {
    /*    System.out.println("ingrese el numero de dia de la semana");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1:
                System.out.println(Semana.LUNES);
            break;
            case 2:
                System.out.println(Semana.MARTES);
                break;
            case 3:
                System.out.println(Semana.MIERCOLES);
                break;
            case 4:
                System.out.println(Semana.JUEVES);
                break;
            case 5:
                System.out.println(Semana.VIERNES);
                break;
            case 6:
                System.out.println(Semana.SABADO);
                break;
            case 7:
                System.out.println(Semana.DOMINGO);
                break;

            default:
                System.out.println("ese dia no existe");*/

    //extra
        /*
         * DIFICULTAD EXTRA (opcional):
         * Crea un pequeño sistema de gestión del estado de pedidos.
         * Implementa una clase que defina un pedido con las siguientes características:
         * - El pedido tiene un identificador y un estado.
         * - El estado es un Enum con estos valores: PENDIENTE, ENVIADO, ENTREGADO y CANCELADO.
         * - Implementa las funciones que sirvan para modificar el estado:
         *   - Pedido enviado
         *   - Pedido cancelado
         *   - Pedido entregado
         *   (Establece una lógica, por ejemplo, no se puede entregar si no se ha enviado, etc...)
         * - Implementa una función para mostrar un texto descriptivo según el estado actual.
         * - Crea diferentes pedidos y muestra cómo se interactúa con ellos.
         */

        Pedido pedido = new Pedido(1);
        pedido.cancelar();
        pedido.enviar();
        pedido.cancelar();
        pedido.entregar();
    }
}
    class Pedido{


        public enum Estado{
            PENDIENTE,ENVIADO,CANCELADO,ENTREGADO
        }
        private int ID;
        private Estado estado;

        public Pedido(int ID) {
            this.ID = ID;
            this.estado = Estado.PENDIENTE;

        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public Estado getEstado() {
            return estado;
        }


        public void entregar(){

            if(this.estado == Estado.ENVIADO){
                System.out.println("Paquete entregado");
                this.estado = Estado.ENTREGADO;
            }else{
                System.out.println("su paquete no se puede entregar \n Estado actual del paquete:"+this.estado);
            }
        }
        public void cancelar(){
            if(this.estado==Estado.ENVIADO||this.estado==Estado.PENDIENTE||this.estado==Estado.CANCELADO){
                this.estado=Estado.CANCELADO;
                System.out.println("Paquete cancelado");
            }else{
                System.out.println("El paquete no se puede cancelar porque ya ha sido entregado");
            }

        }
        public void enviar(){
           if(this.estado==Estado.PENDIENTE){
               this.estado = Estado.ENVIADO;
               System.out.println("paquete enviado");
           }else if(this.estado==Estado.CANCELADO){
               this.estado = Estado.ENVIADO;
               System.out.println("se a quitado la cancelacion de su paquete");
               System.out.println("paquete enviado");
           }
           else{

               System.out.println("El paquete no se puede enviar Estado actual de su paquete:"+this.estado);
           }
        }
    }





