package numero31;

import java.util.*;

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
            sc.nextLine();
            switch (op){
                case 1->
                    RegistroDeEventos(sc);
                case 2->
                    RegistrarParticipantes(sc);
                case 3->
                    SimularEventos();
                case 4->
                    VerInforme();
                case 5->
                    salir = true;
                default->
                    System.out.println("Opcion no disponible");
            }
        }
    }

    private static void VerInforme() {
        System.out.println("INFORME");
        int i = 0;
        for (Evento evento : controlDeEventos.getEventos()) {
            System.out.println("Ganadores de "+evento.getNombreDelEvento());
            for (Participante ganadore : evento.getGanadores()) {
                switch (i){
                    case 1->System.out.println("Oro:"+ganadore);
                    case 2-> System.out.println("Plata:"+ganadore);
                    case 3-> System.out.println("Bronces:"+ganadore);
                }
                i++;
            }
        }


        System.out.println("Raking de los paises con mas medallas");

        Map<String,Integer> ranking = new HashMap<>();
        for (Evento evento : controlDeEventos.getEventos()) {
            for (Participante ganadore : evento.getGanadores()) {

                    ranking.put(ganadore.getPais(),ranking.getOrDefault(ganadore.getPais(), 0) + 1);

            }
        }
        List<Map.Entry<String, Integer>> listaDeEntradas = new ArrayList<>(ranking.entrySet());
        listaDeEntradas.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        Map<String, Integer> rankingOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entrada : listaDeEntradas) {
            rankingOrdenado.put(entrada.getKey(), entrada.getValue());
        }

        rankingOrdenado.forEach((pais,medallas)-> System.out.println("Pais: "+pais+"\n"+"Numerode medallas"+medallas+"\n\n")
        );



    }

    private static void SimularEventos() {
        if(controlDeEventos.HayEventos()) {
            System.out.println(controlDeEventos.SimularEventos());
        }else{
            System.out.println("No hay eventos para simular agrega uno");
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
            System.out.println("Ingrese el pais del Participante");
            String pais = sc.nextLine();





            if (controlParticipantes.agregarParticipante(nombre,pais)) {

                System.out.println("Participante agregado Exitosamente");


            }else{
                System.out.println("Algo paso el participante no se agrego como se debia");
            }
            System.out.println("Desea agregar mas participantes?Si(1)No(2)");
            int op =0;
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            salir = op==2;
            sc.nextLine();
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

            if(controlDeEventos.CrearEvento(nombre)){
                System.out.println("Evento agregado exitosamente!");
            }else{
                System.out.println("El evento no se agrego como debia");
            }
            System.out.println("Desea agregar mas eventos?Si(1)No(2)");
            int op = sc.nextInt();

            salir = op==2;
            sc.nextLine();
        }

    }
}
