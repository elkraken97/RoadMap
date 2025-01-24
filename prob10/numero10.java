package prob10;

import java.util.Scanner;
import java.util.regex.Pattern;

class TieneMayusculasExcepcion extends Exception{
    public TieneMayusculasExcepcion(){
        super("La frase tiene mayusculas");
    }

}
class TieneSignosEspecialesException extends Exception{
    public TieneSignosEspecialesException(){
        super("La frase tiene caracteresEspeciales");
    }

}
class TieneNumeros extends Exception{
    public TieneNumeros(){
        super("La frase tiene Numeros");
    }

}


public class numero10 {
    public static void main(String[] args) {
        System.out.println("""
                Hola esta es una prueba ingrese una frase simple
                SIN MAYUSCULAS
                sin signos especiales
                sin numeros
                """);
        Scanner sc = new Scanner(System.in);
    try{
        LanzamientoDeExcepciones(sc.nextLine());
    } catch (TieneMayusculasExcepcion | TieneNumeros | TieneSignosEspecialesException e) {
        System.out.println(e);
    }
    }
    private static void LanzamientoDeExcepciones(String procesar) throws TieneMayusculasExcepcion,TieneNumeros,TieneSignosEspecialesException {

        if(Pattern.compile("[A-Z]").matcher(procesar).find()){
            throw new TieneMayusculasExcepcion();
        }else if(Pattern.compile("[^A-Z0-9]+").matcher(procesar).find()){
            throw new TieneSignosEspecialesException();
        }else if(Pattern.compile("[0-9]").matcher(procesar).find()){
            throw new TieneNumeros();
        }
        System.out.println("no hay ningun error");
    }
}
