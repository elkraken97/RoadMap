package prob08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class numero08{

 public static void main(String[] args) {
    
    System.out.println("Hola");
    Pila p = new Pila(new Stack<>());
    p.agregar("aadafa");
    p.agregar("xdddd"); 

    System.out.println(p.elementos());
    p.eliminar();
    p.imprimir();
    System.out.println();
    System.out.println("tu cola");
   
    Queue<String> a = new LinkedList<>();
    Cola c = new Cola(a);
    c.agregar("A");
    c.agregar("B");
    c.agregar("C");
    System.out.println(c.elementos());
    c.eliminar();
    c.imprimir();    
}  

}