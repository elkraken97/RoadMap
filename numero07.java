
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class numero07 {



    public static void main(String[] args) {

        //PILAS
        //implemetancion de las colas en java (Stack)
        //la regla de las pilas es LIFO last in first out
        //ultimo en entrar primero en salir
        Stack<Integer> pila = new Stack<>();
        //(push o add sirven hacen lo mismo)
        pila.add(5);
        pila.add(4);
        pila.add(3);
        pila.add(2);
        pila.push(1);
        //esto debe de mostrar la sima de la pila sin retirarla
        System.out.println(pila.peek());
        //esto la debe de mostrar y/0 eliminar
        System.out.println(pila.pop());
        //aqui elimnado
        System.out.println(pila.peek());


        //en esencia es meter todo en un bote
        //que debes de sacar cosas para agarrar algo del fondo es igual


        //cosas extra son solo para saber si la cola esta vacia o no
        System.out.println(pila.isEmpty());

        //y buscar en que posicion esta cierto item si no esta se retorna -1
        System.out.println(pila.search(5));
        System.out.println();
        //COLAS
        //aqui la regla es FIFO (no FIFA) primero en entrar primero en salir

        //es decir una cola del super el primero que se formo el primero en ser atendido y ya
        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(4);
        cola.add(3);
        cola.add(2);
        cola.add(1);


        //aqui el primero que se agrego es decir 5
        System.out.println(cola.peek());
        //aqui se elimina o se quita quien esta al incio de la cola
        System.out.println(cola.poll());

        //despues de retirar sigue el otro que se formo despues
        System.out.println(cola.peek());
        // y ya esta eso es todo tambien tiene otras funciones como las pilas
        System.out.println(cola.isEmpty());



        //

    }


}
