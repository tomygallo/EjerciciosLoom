package _04TierraDeFantasias_Razas;

public class Radaiteran extends Raza {
	private int cantAtaque;

	public Radaiteran() {
		this.salud = 176;
		this.rangoInf = 17;
		this.rangoSup = 41;
		this.ataque = 56;
		this.cantAtaque = 0;
		this.pos = 0;
		this.arma = "Shurikens";
	}

	@Override
	public void atacar(Raza victima) {
		int ataqueReal = 0;
		if (Math.abs(this.pos - victima.pos) > this.rangoInf && Math.abs(this.pos - victima.pos) < this.rangoSup) {
			ataqueReal = this.ataque + (3 * this.cantAtaque);
			victima.recibirAtaque(ataqueReal);
			this.cantAtaque++;
		} else {
			System.out.println("Enemigo fuera de rango");
		}

	}

	@Override
	public void recibirAtaque(int ataque) {
		this.salud -= ataque;
	}

}
