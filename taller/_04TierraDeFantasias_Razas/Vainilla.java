package _04TierraDeFantasias_Razas;
public class Vainilla extends Raza {

	public Vainilla() {
		this.salud = 500;
		this.rangoInf = 10;
		this.rangoSup = 30;
		this.ataque = 15;
		this.pos = 20;
	}

	@Override
	public void atacar(Raza victima) {

		if (Math.abs(this.pos - victima.pos) > this.rangoInf && Math.abs(this.pos - victima.pos) < this.rangoSup) {
			victima.recibirAtaque(this.ataque);
		} else {
			System.out.println("Enemigo fuera de rango");
		}

	}

	@Override
	public void recibirAtaque(int ataque) {
		this.salud -= ataque;
	}
}
