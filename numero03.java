import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class numero03 {

    public static HashMap<String,String> map = new HashMap<>();
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("manolo","2711206989" );
        map.put("queti", "2724534654" );
        map.put("queta", "2723546557" );
        int opcion = 0;
        while(opcion != 6){
        opcion = mostrarMenu();
        switch (opcion) {
            case 1:
                    MostrarContactos(map);
                  
                break;
            case 2:
                    BuscarContacto(map);
                   
            break;
            case 3:
                    map = AgregarContacto(map);
           
            break;
            case 4:
                    map = EliminarContacto(map);
   
            break;
            case 5:
                    map = ActualizarContacto(map);
   
            break;
            case 6:

                System.out.println("hasta luego");

            break;

            default:
                System.out.println("Esa opcion no esta disponible");
                break;
        }
    }
    }
    public static int mostrarMenu(){
        System.out.println("Ingrese una opcion");
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                        1.-Ver contactos
                        2.-Buscar contato
                        3.-Agregar contacto 
                        4.-Eliminar un contacto 
                        5.-Actualizar contacto
                        6.-Terminar Programa
                    """);
        int opcion = sc.nextInt();
    
        return opcion;
        
       
    }
    public static void MostrarContactos(HashMap<String,String> map){
        
        map.forEach((key,value)->{

           System.out.printf("nombre:\n%s\ntelefono:\n%s\n\n",key,value);
        });
        Scanner sc = new Scanner(System.in);
        System.out.println("Presiona enter para continuar");
        sc.nextLine();

        
    }

    public static void BuscarContacto(HashMap<String,String> map){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contacto a buscar");
        String nombre = sc.nextLine();
        if(map.containsKey(nombre)){
            System.out.println("Contacto Encontrado:");
            System.out.println("nombre:");
            System.out.println(nombre);
            System.out.println("numero");
            System.out.println(map.get(nombre));
        }else{
            System.out.println("No tienes ese contacto registrado");
        }
        System.out.println("Presiona enter para continuar");
        sc.nextLine();
   
    }
    public static HashMap<String,String> AgregarContacto(HashMap<String,String> map){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese la informacion del nuevo contacto");
        System.out.println("ingrese el nombre");
        String nombre = sc.nextLine();
        System.out.println("ingrese el telefono");
        String telefono = sc.nextLine();
        if(map.containsKey(nombre)||map.containsValue(telefono)){
            System.out.println("Este es un contacto ya existente");
        }else if(telefono.length() != 10){
            System.out.println("El telefono debe tener 10 caracteres");
        }else{
            map.put(nombre, telefono);
            
            System.out.println("contacto agregado correctamente");
            return map;
        }
        System.out.println("Presiona enter para continuar");
        sc.nextLine();
        return map;
    }

    public static HashMap<String,String> EliminarContacto(HashMap<String,String> map){
        System.out.println("ingrese el nombre del contacto a eliminar");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        if(map.containsKey(nombre)){
            map.remove(nombre);
            System.out.println("Contacto removido correctamente");
            return map;
            } 
        else{
            System.out.println("Ese contacto no existe intente de nuevo");
        }
        System.out.println("Presiona para continuar");
        sc.nextLine();
        return map;
    }

    public static HashMap<String,String> ActualizarContacto(HashMap<String,String> map){
        Scanner sc = new Scanner(System.in);
        System.out.println("que contacto quiere actualizar?");
        String nombre = sc.nextLine();
        if(map.containsKey(nombre)){
        System.out.println("ingrese el nuevo numero de ese contacto:");
        String num = sc.nextLine();
        if(num.length()==10){
            map.replace(nombre, num);
            System.out.println("contacto actualizado correctamente");
            return map;
      
        }else{
            System.out.println("EL numero debe de tener 10 caracteres");
        }
    }else{
        System.out.println("ese contacto no existe");
    }
    return map;
        
    }
}
