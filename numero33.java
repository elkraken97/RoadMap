import java.util.Objects;
import java.util.Scanner;

public class numero33 {
    public static String[][] maze = {
            {"🐭", "⬜️", "⬛️", "⬜️", "⬜️", "⬜️"},
            {"⬜️", "⬛️", "⬛️", "⬜️", "⬛️", "⬜️"},
            {"⬜️", "⬛️", "⬜️", "⬜️", "⬛️", "⬜️"},
            {"⬜️", "⬜️", "⬜️", "⬛️", "⬛️", "⬜️"},
            {"⬛️", "⬛️", "⬜️", "⬛️", "⬜️", "⬜️"},
            {"⬜️", "⬜️", "⬜️", "⬛️", "⬜️", "🚪"}
    };
    public static int posiciony=0;
    public static int posicionx=0;
    public static boolean ganar = false;
    //Laberinto
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(!ganar){
            imprime();
            System.out.println("""
                ¿ a que direccion ir?
                1 Arriba
                2 Abajo
                3 Izquierda
                4 Derecha
                """);
            int op  = sc.nextInt();
            switch (op){
                case 1-> irArriba();
                case 2-> irAbajo();
                case 3-> izquierda();
                case 4-> derecha();
                default -> System.out.println("OPcion no disponible");

        }
        }
        imprime();
        System.out.println("Felicidades haz ganado!");

    }
    public static void imprime(){
        for (String[] coords : maze) {
            for (String coord : coords) {
                System.out.printf(coord);
            }
            System.out.println();
        }
    }
    private static void derecha() {
        posicionx++;
        if(posicionDisponible()) {
            maze[posiciony][posicionx-1] = "⬜️";

            maze[posiciony][posicionx] = "🐭";
        }else{
            posicionx--;
        }
    }

    private static void izquierda() {
        posicionx--;
        if(posicionDisponible()) {
            maze[posiciony][posicionx+1] = "⬜️";

            maze[posiciony][posicionx] = "🐭";
        }else{
            posicionx++;
        }
    }

    private static void irAbajo() {

        posiciony++;
        if(posicionDisponible()){
            maze[posiciony-1][posicionx] = "⬜️";
            maze[posiciony][posicionx] = "🐭";
        }else{
            posiciony--;
        }
    }

    private static void irArriba() {

        posiciony--;
        if(posicionDisponible()){
        maze[posiciony+1][posicionx] = "⬜️";
        maze[posiciony][posicionx] = "🐭";
        }else{

            posiciony++;
        }
    }

    public static boolean posicionDisponible(){
        try{
             if(Objects.equals(maze[posiciony][posicionx], "⬛️")){
                 System.out.println("Pared");
                    return false;
             }
             if(Objects.equals(maze[posiciony][posicionx], "🚪")){
                 ganar = true;
             }
            return true;
        }catch (Exception e){
            System.out.println("No se puede salir del los limites del laberinto");
            return false;
        }
    }



}
