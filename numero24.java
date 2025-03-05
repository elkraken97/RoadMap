public class numero24 {
    public static void main(String[] args) {
        Suma s = new Suma();
        Contador c = new Contador(s);
        c.ejecutar(4,5);
        c.ejecutar(34,5);
        c.ejecutar(3,4);
    }




}
interface Decorador {
    void ejecutar(int a,int b);
}

class Suma implements Decorador{

    @Override
    public void ejecutar(int a,int b) {
        System.out.println("Resultado:"+(a+b));
    }
}
class Contador implements Decorador{
    private final Decorador dec;
    private int count = 0;
    public Contador(Decorador dec) {
        this.dec = dec;
    }

    @Override
    public void ejecutar(int a, int b) {
        count++;
        System.out.println("Contador Actual:"+count);
        dec.ejecutar(a,b);

    }
}