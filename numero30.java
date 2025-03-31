import java.util.ArrayList;

interface Envios{
 public void EnviarMensaje(String Sms);
}
class Sms implements Envios{

 @Override
 public void EnviarMensaje(String Sms) {
  System.out.println("Mensaje SMS:"+Sms);
 }
 public void saldo (){
  System.out.println("Aun hay saldo");
 }
}
class PUSH implements Envios{

 @Override
 public void EnviarMensaje(String Sms) {
  System.out.println("Mensaje PUSH:"+Sms);
 }
}
class Email implements Envios{

 @Override
 public void EnviarMensaje(String Sms) {
  System.out.println("Mensaje Email:"+Sms);
 }
}

class Mensajeria{
  private final Envios envio;

  public Mensajeria(Envios o){
   envio = o;
  }

  public void EnviarMensaje(String mensaje){
     envio.EnviarMensaje(mensaje);
  }
}

public class numero30 {
 public static void main(String[] args) {
    Envios sms = new Sms();
    Envios push = new PUSH();
    Envios email = new Email();

    Mensajeria mensajesms = new Mensajeria(sms);
    mensajesms.EnviarMensaje("sms");
    Mensajeria mensajepush = new Mensajeria(push);
    mensajepush.EnviarMensaje("push");
    Mensajeria mensajeemail = new Mensajeria(email);
    mensajeemail.EnviarMensaje("email");

  ((Sms)sms).saldo();
  verificarDIP(Mensajeria.class,Envios.class);
 }
 public static void verificarDIP(Class<?> clase, Class<?> interfaz) {
  boolean cumpleDIP = false;

  for (Class<?> interfazImplementada : clase.getDeclaredConstructors()[0].getParameterTypes()) {
   if (interfaz.isAssignableFrom(interfazImplementada)) {
    cumpleDIP = true;
    break;
   }
  }

  if (cumpleDIP) {
   System.out.println(" El sistema de notificaciones cumple DIP: depende de una abstracción.");
  } else {
   System.out.println(" ERROR: El sistema depende de clases concretas y NO cumple DIP.");
  }
 }
}
