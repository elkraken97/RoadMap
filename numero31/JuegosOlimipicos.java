package numero31;

import java.util.Scanner;

public class JuegosOlimipicos {
    private static final ControlParticipantes controlParticipantes = new ControlParticipantes();
    private static final ControlDeEventos controlDeEventos = new ControlDeEventos(controlParticipantes);

    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        while(!salir){
            System.out.println("""
                    1.-Registrar Eventos
                    2.-Registrar Participantes
                    3.-Simular eventos
                    4.-Crear Informes
                    5.-Salir
                    """);
            int op = sc.nextInt();
            switch (op){
                case 1->
                    RegistroDeEventos(sc);
                case 2->
                    RegistrarParticipantes(sc);
                case 5->
                    salir = true;
                default->
                    System.out.println("Opcion no disponible");
            }
        }
    }

    private static void RegistrarParticipantes(Scanner sc) {
        boolean salir = false;
        while (!salir){

            System.out.println("""
                    Hola!
                    Bienvenido al regsitro de Participantes\s
                    Ingrese los datos que se solicite de los participantes\s
                   \s""");
            System.out.println("Ingrese el nombre del participante:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la edad del Participante");
            int edad = sc.nextInt();
            System.out.println("Ingrese el Genero del Participante 'M' o 'F'");
            Character genero = sc.nextLine().charAt(0);
            System.out.println("Ingresa la altura");
            double altura = sc.nextDouble();
            System.out.println("Ingresa el peso");
            double peso = sc.nextDouble();
            System.out.println("Ingrese el nombre del evento al que va a participar el Participante");
            controlDeEventos.mostrarEventos();
            Evento e =  controlDeEventos.buscarEvento(sc.nextLine());
            if(e==null){
                System.out.println("No existe ese evento");
            }else{



            if (controlParticipantes.agregarParticipante(nombre,edad,genero,altura,peso,e.getNombreDelEvento())) {
                controlDeEventos.FicharParticipante(nombre,e.getNombreDelEvento());
                System.out.println("Participante agregado Exitosamente");


            }else{
                System.out.println("Algo paso el participante no se agrego como se debia");
            }
            System.out.println("Desea agregar mas eventos?Si(1)No(2)");
            int op = sc.nextInt();

            salir = op==2;}
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
            }else{
                System.out.println("El evento no se agrego como debia");
            }
            System.out.println("Desea agregar mas eventos?Si(1)No(2)");
            int op = sc.nextInt();

            salir = op==2;

        }

    }
}
