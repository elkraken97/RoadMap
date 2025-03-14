import java.util.ArrayList;
import java.util.List;

class Vehiculo{
    public void acelerar(){
        System.out.println("Vehiculo Acelera");
    }
    public void frenar(){
        System.out.println("Vehiculo Frena");
    }


}
class Coche extends Vehiculo{
    @Override
    public void acelerar(){
        System.out.println("Coche Acelera");
    }

    @Override
    public void frenar(){
        System.out.println("Coche Frena");
    }

}
class Elicoptero extends Vehiculo{
    @Override
    public void acelerar(){
        System.out.println("Elcoptero Acelera");
    }
    @Override
    public void frenar(){
        System.out.println("Elicoptero Frena");
    }

}
class Tren extends Vehiculo{
    @Override
    public void acelerar(){
        System.out.println("Tren Acelera");
    }
    @Override
    public void frenar(){
        System.out.println("Tren Frena");
    }

}
public class numero28 {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo());
        vehiculos.add(new Coche());
        vehiculos.add(new Elicoptero());
        vehiculos.add(new Tren());

        for (Vehiculo vehiculo : vehiculos) {

            vehiculo.acelerar();
            vehiculo.frenar();

        }
    }


}
