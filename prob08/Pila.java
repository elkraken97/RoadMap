package prob08;

import java.util.Stack;

public class Pila {
    private Stack<String> pila = new Stack<>();

    public Pila(Stack<String> pila){
        this.pila=pila;
    }
    public void agregar(String parametro){
        pila.add(parametro);
    }
    public String eliminar(){
        return pila.pop();
    }
    public int elementos(){
        return pila.size();
    }

    public void imprimir(){
        pila.forEach(e ->{System.out.println(e);});
    }
    

}
