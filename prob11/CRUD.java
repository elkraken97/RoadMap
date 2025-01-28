package prob11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CRUD {
    public static String ven = "prob11/ventas.txt";

    public static void main(String[] args) {

        boolean i = true;
        try {


            File f = new File(ven);
            while(i){

                if(f.createNewFile()){
                    Inizializador();
                    System.out.println("Archivo creado");
                }

                i = mostrarMenu();
            }


        }catch (FileNotFoundException e){
            System.out.println("a ocurrido un error");
            e.getStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void Inizializador() {
        List<Producto> prueba = new ArrayList<>();
        prueba.add(new Producto(55,34,"cafe"));
        prueba.add(new Producto(12, 20, "azucar"));
        prueba.add(new Producto(78, 50, "leche"));
        prueba.add(new Producto(43, 10, "te"));
        for(Producto producto:prueba){

        AgregarProducto(producto);

        }

    }

    private static boolean mostrarMenu() {

        System.out.println("""
                Hecho!
                1.-Agregar Producto
                2.-Consultar los Productos
                3.-Actualizar un Producto
                4.-Eliminar Un producto
                5.-Eliminar el archivo y salir
                6.-Salir
                """);
        try{
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:

                System.out.println("Ingrese las datos del nuevo Producto");
                sc.nextLine();
                System.out.println("nombre del producto:");
                String nombre = sc.nextLine();
                int cantidad_vendida,precio;
                System.out.println("cantidad vendida del producto:");
                cantidad_vendida = sc.nextInt();

                System.out.println("precio del producto");
                precio = sc.nextInt();

                AgregarProducto(new Producto(cantidad_vendida,precio,nombre));

                break;
            case 2:
                System.out.println("Todos los Productos:");
                TodosLosProductos();
                break;
            case 3:
                System.out.println("Ingresa el nombre del producto que quieres actualizar");
                sc.nextLine();
                String s = sc.nextLine();
                Producto ProductoActualizar = new Producto();
                System.out.println("ingrese el nombre por el cual cambiar");
                ProductoActualizar.setNombre(sc.nextLine());
                System.out.println("ingrese el precio");
                ProductoActualizar.setPrecio(sc.nextInt());
                System.out.println("ingrese la cantidad de productos vendidos");
                ProductoActualizar.setCantidad_vendida(sc.nextInt());
                ActualizarProducto(s,ProductoActualizar);
                break;
            case 4:
                System.out.println("Ingresa el nombre del producto a eliminar");
                sc.nextLine();

                EliminarProducto(sc.nextLine());
                break;
            case 5:
                System.out.println("Eliminando el fichero...");
                EliminarFichero();
                return false;
            case 6:

                return false;
            default:
                System.out.println("opcion no Disponible intente de nuevo");
        }
        return true;
        }catch (Exception e){
            System.out.println("Ingresaste un valor Erroneo! intenta ingresar de nuevo "+e.getMessage());
        return true;

        }

        }

    private static void EliminarFichero() {
        try {


            File f = new File(ven);
            if(f.delete()){
                System.out.println("archivo eliminado");
            }else{
                System.out.println("no se pudo eliminar");
            }
        }
        catch (Exception e){
            System.out.println("Ocurrio un error con el archivo");
        }
    }

    private static void ActualizarProducto(String s, Producto productoActualizar) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ven));
            List<String> lineas = new ArrayList<>();
            String linea;

            while ((linea = lector.readLine()) != null) {

                if (!linea.contains(s)) {
                    lineas.add(linea+System.lineSeparator());
                }else{
                    lineas.add("Nombre:"+productoActualizar.getNombre()+","+"Precio:"+productoActualizar.getPrecio()+","+
                                "Cantidad Vendida:"+productoActualizar.getCantidad_vendida()+System.lineSeparator());
                }
            }
            lector.close();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ven));
            for (String l : lineas) {
                escritor.write(l);
            }
            escritor.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void EliminarProducto(String s) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ven));
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = lector.readLine()) != null) {

                if (!linea.contains(s)) {
                    lineas.add(linea);
                }
            }
            lector.close();

            BufferedWriter escritor = new BufferedWriter(new FileWriter(ven));
            for (String l : lineas) {
                escritor.write(l);
            }
            escritor.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void TodosLosProductos() {
        try {
            BufferedReader b = new BufferedReader(new FileReader(ven));
            Stream<String> s = b.lines();
            s.forEach(System.out::println);
            b.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void AgregarProducto(Producto producto){
       try{
        FileWriter escritor = new FileWriter(ven,true);
            escritor.write("Nombre:"+producto.getNombre()+",");
            escritor.write("Precio:"+producto.getPrecio()+",");
            escritor.write("Cantidad Vendida:"+producto.getCantidad_vendida());
            escritor.write(System.lineSeparator());
        escritor.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
