package numero32;

public class ControlPelea {
    private final Personaje DeadPool= new Personaje(10,100,25);
    private final Personaje Wolverine = new Personaje(10,120,20);

    public void SetVida(int vidaDeadPoll,int vidaWolverine){
        DeadPool.setVida(vidaDeadPoll);
        Wolverine.setVida(vidaWolverine);
    }


    public void Batalla(){

        int numeroDeTurno = 0;
        int ataque;
        String ganador;
        boolean inhabilitado = false;
        while(true){
                numeroDeTurno++;
            System.out.println("Turno numero:"+numeroDeTurno);
            if(!inhabilitado) {
                System.out.println("Turno de Deadpool!");
                PausaAni();
                System.out.println("Deadpool Ataca!");
                ataque = DeadPool.ataque();
                PausaAni();
                System.out.println("Deadpool hace " + ataque + " puntos de daño");
                PausaAni();
                if (Wolverine.evade()) {

                    System.out.println("Wolverine a evadido el ataque!");
                } else {
                    System.out.println("Daño recibido!");
                    PausaAni();
                    Wolverine.setVida(Wolverine.getVida() - ataque);
                    System.out.println("Wolverine ahora tiene " + Wolverine.getVida() + " puntos de vida");

                    if (Wolverine.personajeMuerto()) {
                        ganador = "Deadpool";
                        break;
                    }


                    if (ataque == DeadPool.getrango2()) {
                        PausaAni();
                        System.out.println("!!!!!!");
                        System.out.println("EL ataque a sido critico! Wolverine esta debilitado en el siguiente turno!");
                        System.out.println("!!!!!!");
                        inhabilitado=true;
                    }

                }
            }else{
                System.out.println("Deadpool esta regenerando por el golpe critico!");
                inhabilitado=false;
            }
            if(!inhabilitado){
            PausaAni();
            System.out.println("Turno de wolverine!");
            PausaAni();
            System.out.println("Wolverine Ataca!");
            ataque = Wolverine.ataque();
            PausaAni();
            System.out.println("Wolverine hace "+ataque+" puntos de daño");
            PausaAni();
          if(DeadPool.evade()){
              System.out.println("Deadpool a evadido el ataque");
          }else{
              System.out.println("Daño recibido!");
              PausaAni();
              DeadPool.setVida(DeadPool.getVida()-ataque);
              System.out.println("Deadpool ahora tiene "+DeadPool.getVida()+" Puntos de vida");

              if(DeadPool.personajeMuerto()){
                 ganador="Wolverine";
                 break;
              }

              if(ataque== Wolverine.getrango2()){
                  PausaAni();
                  System.out.println("!!!!!!!!!!");
                  System.out.println("EL ataque a sido critico! Deadpool esta debilitado en el siguiente turno!");
                  System.out.println("!!!!!!!!!!");
                  inhabilitado = true;

              }
          }
            }else{
                System.out.println("Wolverine esta regenerando por el golpe critico!");
                System.out.println("Asi que esta inhabilitado en este turno!");
                inhabilitado=false;
            }

            }

        System.out.println("\n"+ganador+" Ha ganado!");
    }
    private void PausaAni(){
        try{
            Thread.sleep(2050);
        }catch (Exception e){
            System.out.println("HA ocurrido un error en las pausas");
        }
    }

}
