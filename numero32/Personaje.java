package numero32;

import java.util.Random;

public class Personaje{
    private final Random r = new Random();
    private int Vida;
    private final int rango1;
    private final int rango2;
    private final int evadir;

    public Personaje( int rango1, int rango2, int evadir) {
        this.rango1 = rango1;
        this.rango2 = rango2;
        this.evadir = evadir;
    }

    public int ataque(){
        return r.nextInt(rango2-rango1+1)+rango1;

    }
    public int getrango2(){
        return rango2;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vidaInicial) {
        Vida = vidaInicial;
    }


    public boolean evade(){
        return r.nextInt(100)<evadir;
    }
    public boolean personajeMuerto(){
        return Vida<=0;
    }
}
