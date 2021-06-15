package _03MonjesVikingos;

public class Vikingo {
	
	Estado estado = new Normal();
	private String danioRecibido;
	private double ataque;
	
	Vikingo()
	{	
		this.ataque=10;
		this.danioRecibido="Normal";
		this.estado =new Normal();
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void recibirAtaque()
	{
		estado=estado.recibirAtaque(this);
	}
	
	public void meditar()
	{
		estado=estado.meditar(this);
	}
	
	public void atacar()
	{
		estado=estado.atacar(this);
	}

	public void setDanioRecibido(String danioRecibido) {
		this.danioRecibido = danioRecibido;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	@Override
	public String toString() {			
		return "Vikingo [estado=" + this.estado.getClass().getName() + ", danioRecibido=" + danioRecibido + ", ataque=" + ataque + "]";
	}

	
	
}
