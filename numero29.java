
interface ImpresorasBN{
    public void ImprimirBlancoYNegro(String documento);
}
interface ImpresorasColor{
    public void ImprimirColor(String documento);
}
interface ImpresoraMulti{
    public void escanear(String escaneo);
    public void enviarFax(String mensaje);
}

class ImpresoraBlancoYNegro implements ImpresorasBN{

    @Override
    public void ImprimirBlancoYNegro(String documento) {
        System.out.println("Imprimiendo...");
        try{
            Thread.sleep(1000);
        System.out.println("Documento:"+documento+"Impreso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ImpresoraColor implements ImpresorasColor{



    @Override
    public void ImprimirColor(String documento) {
        System.out.println("Imprimiendo...");
        try{
            Thread.sleep(1000);
            System.out.println("Documento:"+documento+"Impreso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class ImpresoraMult implements ImpresoraMulti,ImpresorasColor,ImpresorasBN{

    @Override
    public void ImprimirColor(String documento) {
        System.out.println("Imprimiendo...");
        try{
            Thread.sleep(1000);
            System.out.println("Documento:"+documento+"Impreso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void escanear(String escanear) {
        System.out.println("Escaneando...");
        try{
            Thread.sleep(1000);
            System.out.println("Documento:"+escanear+"Escaneado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enviarFax(String mensaje) {
        System.out.println("Enviando...");
        try{
            Thread.sleep(1000);
            System.out.println("Documento:"+mensaje+"Enviado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void ImprimirBlancoYNegro(String documento) {
        System.out.println("Imprimiendo...");
        try{
            Thread.sleep(1000);
            System.out.println("Documento:"+documento+"Impreso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class GestorDeImpresoras{
//Solo se necesita una interface con las funciones NECESARIAS si un objeto implementa un interfaz con una funcion
//Que no necesita se rompe este principio ya que se debe de separar en otra especifica para ese objeto


}




public class numero29 {

    public static void main(String[] args) {

    }

}
