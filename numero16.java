import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numero16 {
    public static void main(String[] args) {
        String texto = "456 pesos menos 567 centavos";
        String patron = "\\d+";
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);

        List<String> numeros = new ArrayList<>();

        while (m.find()) {
            numeros.add(m.group());
        }
        System.out.println("numeros encontrados:" + numeros);
        System.out.println();
        //PROBLEMA DE DIFICULTAD
        String correo = "elyamalfredo0609gmail.com";
        String validador = "^[a-zA-Z0-9]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern v = Pattern.compile(validador);
        Matcher t = v.matcher(correo);


        if (t.matches()) {
            System.out.println("correo valido");
        } else {
            System.out.println("correo invalido");
        }


        String numero = "+52 2727225937";
        String regex = "^\\+[0-9]{1,3}\s*[0-9]{10}$";
        Pattern num = Pattern.compile(regex);
        Matcher mat = num.matcher(numero);

        if(mat.matches()){
            System.out.println("telefono valido");
        }
        else{
            System.out.println("telefono invalido");
        }
        String ulr = "http://chatgpt.com";
        String ulrregex = "^[htps]+://[a-z0-9]+\\.[a-z]{2,7}.*";
        Pattern ullv = Pattern.compile(ulrregex);
        Matcher matcher = ullv.matcher(ulr);

        if(matcher.matches()){
            System.out.println("url validad");
        }else{
            System.out.println("ulr invalida");
        }



    }
}