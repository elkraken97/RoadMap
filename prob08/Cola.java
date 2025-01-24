package prob08;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
  
    private Queue<String> cola = new LinkedList<>();

    public Cola(Queue<String> cola){
        this.cola=cola;
    }
    public void agregar(String parametro){
        cola.add(parametro);
    }
    public String eliminar(){
        return cola.poll();
    }
    public int elementos(){
        return cola.size();
    }

    public void imprimir(){
        cola.forEach(e ->{System.out.println(e);});
    }
    
    
}
