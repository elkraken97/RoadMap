package numero26;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
        public static  ArrayList<Librow> l = new ArrayList<>();
    public static ArrayList<Usuario> c = new ArrayList<>();
    public static void main(String[] args) {

        boolean exit = true;
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while(exit){
            System.out.println("""
                    1.-Agregar un librow\s
                    2.-Registrar un cliente
                    3.-Inicio de sesion
                    4.-Salir
                   \s""");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.println("Dame el titulo");
                    String titulo = sc.nextLine();
                    System.out.println("Dame la descripcion del librow");
                    String desc = sc.nextLine();
                    System.out.println("Dame el autor");
                    String autor = sc.nextLine();
                    System.out.println("Dame el numerode copias de este librow");
                    int copias = sc.nextInt();
                l.add(new Librow(titulo,desc,autor,copias));
                sc.nextLine();

                    break;
                case 2:
                    System.out.println("Dame el nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Dame el correo");
                    String correo = sc.nextLine();
                    System.out.println("Dame la contraseña");
                    String pass = sc.nextLine();

                    c.add(new Usuario(nombre,correo,pass));

                    break;
                case 3:

                    System.out.println("Dame el nombre del usuario o id");
                    String n = sc.nextLine();
                    System.out.println("Dame la contraseña");
                    String a = sc.nextLine();
                    boolean encontrado = false;
                    Usuario f = null;
                    int indice = 0;
                    for(Usuario u : c){
                        if((u.getPassword().equals(a)&&u.getNombre().equals(n))||(u.getPassword().equals(a)&& (u.getID() + "").equals(n))){
                            f= u;
                        encontrado = true;
                        break;
                        }
                        indice++;
                    }
                    if(encontrado){
                        session(indice,sc);
                    }else{
                        System.out.println("usuario no encontrado intente denuevo");
                    }

                    break;
                case 4:
                    System.out.println("Adios....");
                    exit = false;
                    break;
                default:
                    System.out.println("Opcion no disponible intente de nuevo");

            }
        }
    }
    public static void session(int indice,Scanner sc){
        boolean salir = true;
        while(salir){
        System.out.println("""
                Bienvenido usuario
                \s""" +c.get(indice).getNombre()+
                """
                \n1.-Tomar un librow\s
                2.-Devolver un librow             \s
                3.-Salir sesion
                \s
                   \s""");
            int op = sc.nextInt();
            sc.nextLine();
        switch (op){
            case 1:
                System.out.println("Lista de libros:");
                l.forEach(System.out::println);
                System.out.println("Ingrese el titulo del librow:");
                String tit = sc.nextLine();

                boolean existe = false;
                for(Librow librow : l){
                    if(librow.getTitulo().equals(tit)){

                        if(librow.getCopias()<=0){
                            System.out.println("no hay mas copias");

                        }else{
                            librow.setCopias(librow.getCopias()-1);
                        c.get(indice).agregarPrestado(librow);
                        existe = true;}
                    }
                }
                if(existe){
                    System.out.println("Libro prestado a este usuario");
                }else{
                    System.out.println("ya no hat mas copias de ese librow o");
                    System.out.println("ese librow no existe intente de nuevo");
                }

                break;
            case 2:
                System.out.println("Lista de libros usados por este usuario:");
                if(c.get(indice).verPrestados()==null){
                    System.out.println("No hay libros");
                }else{
                    System.out.println("Libros de este usuario:");
                    c.get(indice).verPrestados().forEach(System.out::println);
                    System.out.println("Titulo del Libro a devolver:");
                    String titulo = sc.nextLine();
                    boolean ex = false;
                    int i = 0;
                    int este=0;
                    for(Librow librow :c.get(indice).verPrestados()){
                        if(librow.getTitulo().equals(titulo)){
                            System.out.println(i);
                             este= i;

                            ex = true;
                        }
                    i++;
                    }
                    if(ex){
                        for(Librow librow : l){
                            if(librow.getTitulo().equals(titulo)){
                                c.get(indice).devolverLibro(c.get(indice).verPrestados().get(este));
                                librow.setCopias(librow.getCopias()+1);

                            }
                        }
                        System.out.println("Libro devuelto");

                    }else{
                        System.out.println("ese librow no esta pruebe otraves");
                    }
                }
                break;
            case 3:
                System.out.println("Adios");
                salir = false;
                break;
        }

             }
        }

}
