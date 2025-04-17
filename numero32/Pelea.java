package numero32;

import java.util.Scanner;

public class Pelea {
    public static void main(String[] args) {
        ControlPelea controlPelea = new ControlPelea();
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        while(salir){
            System.out.println("""
                    Bienvenido a simulador de batallas!
                    AL simular batalla no acabara hasta que uno muera
                    1.-Dar puntos de vida a los personajes
                    2.-Iniciar batalla!
                    3.-Salir
                    """);
                int op = sc.nextInt();
                switch (op){
                    case 1-> {
                        System.out.println("Ingrese la vida de DeadPool");
                        int vidaD = sc.nextInt();
                        System.out.println("Ingrese la vida de Wolverine");
                        int vidaW = sc.nextInt();
                        controlPelea.SetVida(vidaD,vidaW);
                    }
                    case 2->controlPelea.Batalla();
                    case 3->salir = false;
                    default -> System.out.println("Opcion no dispoible");

                }


        }
    }
}
