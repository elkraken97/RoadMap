package prob11;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.stream.Stream;

public class numero11 {
    public static void main(String[] args) {
        String archivo = "prob11/fichero.txt";
        try{
            File a = new File(archivo);
            if(a.createNewFile()){
                System.out.println("el archivo a sido creado");
            }

            FileWriter escritor = new FileWriter(a);
            escritor.write("Alfredo");
            escritor.write("\n");
            escritor.write("18");

            escritor.close();
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            Stream s = lector.lines();
            s.forEach(System.out::println);
            Scanner sc = new Scanner(System.in);
            System.out.println("preciona Enter para eliminar el fichero");
            sc.nextLine();
            if(a.delete()){
                System.out.println("archivo eliminado");
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
