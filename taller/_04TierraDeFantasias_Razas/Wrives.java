package _04TierraDeFantasias_Razas;
public class Wrives extends Raza {
	private int cantAtaque;
	private boolean esAtacado;

	public Wrives() {
		this.salud = 108;
		this.rangoInf = 14;
		this.rangoSup = 28;
		this.ataque = 113;
		this.cantAtaque = 0;
		this.pos = 0;
		this.arma = "Magia";
		this.esAtacado = true;
	}

	@Override
	public void descansar() {
		this.esAtacado = false;
		this.salud += 50;
	}

	@Override
	public void atacar(Raza victima) {
		if (this.esAtacado) {
			if (Math.abs(this.pos - victima.pos) > this.rangoInf && Math.abs(this.pos - victima.pos) < this.rangoSup) {
				this.cantAtaque++;
				if (this.cantAtaque % 2 == 0) {
					victima.recibirAtaque(this.ataque * 2);
				} else {
					victima.recibirAtaque(this.ataque);
				}
			} else {
				System.out.println("Enemigo fuera de rango");
			}

		}

	}

	@Override
	public void recibirAtaque(int ataque) {
		this.esAtacado = true;
		this.salud -= ataque * 2;
	}

}
