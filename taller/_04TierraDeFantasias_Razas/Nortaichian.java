package _04TierraDeFantasias_Razas;

public class Nortaichian extends Raza{

    private int enfurecido;
    private int piedra;

    public Nortaichian() {
        this.salud = 166;
        this.rangoInf = 16;
        this.rangoSup = 22;
        this.ataque = 18;
        this.pos = 0;
        this.arma = "Arco";
        this.enfurecido = 0;
        this.piedra = 0;
    }

    public void atacar(Raza victima) {

        if (Math.abs(this.pos - victima.pos) > this.rangoInf && Math.abs(this.pos - victima.pos) < this.rangoSup) {
            victima.recibirAtaque(this.ataque);
        } else {
            System.out.println("Enemigo fuera de rango");
        }

    }

    @Override
    public void recibirAtaque(int ataque) {
        if(piedra > 0) {
            this.salud -= (ataque*0.5);
            piedra--;
        }
        else {
            this.salud -= ataque;
        }
        this.enfurecido = 2;
    }

    @Override
    public void descansar() {
        this.salud = 166;
        this.piedra = 2;
        if( enfurecido > 0) {
            enfurecido--;
        }
    }

}