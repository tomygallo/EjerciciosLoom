package _04TierraDeFantasias_Razas;
import java.util.Random;

public class Reralopes extends Raza {
	private int cantAtaqueErrados;
	private int cantAtaque;
	private int cantAtaqueHecho;
	private String estado;
	private int ataqueBonificado;
	private Random random;

	public Reralopes() {
		this.salud = 53;
		this.rangoInf = 5;
		this.rangoSup = 46;
		this.ataque = 27;
		this.cantAtaqueErrados = 0;
		this.pos = 0;
		this.arma = "Catapulta";
		this.estado = "Normal";
		this.ataqueBonificado = 0;
		this.cantAtaqueHecho=0;
	}

	@Override
	public void descansar() {
		this.estado = "Concentrado";
		this.ataqueBonificado = 3;
	}

	@Override
	public void recibirAtaque(int ataque) {
		this.estado = "Desconcentrado";
		this.ataqueBonificado = 0;
	}

	@Override
	public void atacar(Raza victima) {

		if (Math.abs(this.pos - victima.pos) > this.rangoInf && Math.abs(this.pos - victima.pos) < this.rangoSup) {
			this.cantAtaque++;
			Random random = new Random();
			boolean ataca = random.nextBoolean();
			if (!ataca) {
				this.cantAtaqueErrados++;
			}
			
			if (this.cantAtaqueErrados > 2 || (ataca && this.cantAtaqueHecho < 2)) {
				this.cantAtaqueHecho++;
				if (this.ataqueBonificado > 0) {
					victima.recibirAtaque(this.ataque * 2);
					this.cantAtaque++;
					this.ataqueBonificado--;
				} else {
					victima.recibirAtaque(this.ataque);
					this.cantAtaque++;
				}
			} 
			
			if (this.cantAtaque == 4) {
				this.cantAtaqueErrados = 0;
				this.cantAtaque = 0;
			}

		} else
			System.out.println("Enemigo fuera de rango");

	}

}
