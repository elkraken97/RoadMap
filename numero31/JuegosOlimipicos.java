package numero31;

import java.util.Scanner;

public class JuegosOlimipicos {
    public static final ControlDeEventos controlDeEventos = new ControlDeEventos();
    public static void main(String[] args) {
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        while(salir){
            System.out.println("""
                    1.-Registrar Eventos
                    2.-Registrar Participantes
                    3.-Simular eventos
                    4.-Crear Informes
                    5.-Salir
                    """);
            int op = sc.nextInt();
            switch (op){
                case 1:
                    RegistroDeEventos(sc);
                case 5:
                    salir = false;
                default:
                    System.out.println("Opcion no disponible");
            }
        }
    }

    private static void RegistroDeEventos(Scanner sc) {

        boolean salir = false;
        while (!salir){

            System.out.println("""
                    Hola!
                    Bienvenido al regsitro de eventos se le solicitara el nombre y fecha de su evento
                    Ingrese el nombre:
                    """);
            String nombre = sc.nextLine();
            System.out.println("Ingrese la fecha ");
            String fecha = sc.nextLine();
            if(controlDeEventos.CrearEvento(nombre,fecha)){
                System.out.println("Evento agregado exitosamente!");
            }
            System.out.println("Desea agregar mas eventos?Si(1)No(2)");
            int op = sc.nextInt();

            salir = op==2;

        }

    }
}
