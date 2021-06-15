package tp_lanzandoElCaber;

public class Lanzamiento {
	private double distancia;
	private double angulo;
	
	public Lanzamiento(double distancia, double angulo) {
		this.distancia = distancia;
		this.angulo = angulo;
	}
	
	public void calcularDistanciaReal() {
		
		if(this.angulo > 90 || this.angulo < -90) {
			this.distancia = -1;
		} else if(this.angulo > 30 || this.angulo < -30) {
			this.distancia *= 0.8;
		}	
	}
	
	// analizar
	public boolean esLanzamientoValido() {
		
		if(this.distancia >= 0) {
			return true;
		}
		
		return false;
	}

	public double getDistancia() {
		return distancia;
	}
	
	public double getAngulo() {
		return angulo;
	}
	
}
