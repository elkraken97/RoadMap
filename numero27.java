
interface Calculadora{
    public double calcular(int a,int b);}


class Resultado{
    public double resultado(int a,int b,Calculadora c){
        return c.calcular(a,b);
    }
}

class Sumas implements Calculadora{


    public double calcular(int a, int b) {
        return a+b;
    }
}
class Potencia implements Calculadora{


    public double calcular(int a, int b) {
        return Math.pow(a,b);
    }
}

public class numero27 {
    public static void main(String[] args) {
        Calculadora c = new Sumas();
        Calculadora p = new Potencia();


        System.out.println(c.calcular(2,3));
        System.out.println(p.calcular(10,2));
    }
}
