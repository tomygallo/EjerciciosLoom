package oia5_vagonesDeTren;

public class Especie {
	
	private String especie;
	private int agresividad;
	private int cantidad;
	
	public Especie(String especie, int agresividad, int cantidad) {
		this.especie = especie;
		this.agresividad = agresividad;
		this.cantidad = cantidad;
	}

	public String getEspecie() {
		return especie;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "Especie: " + especie + ", agresividad: " + agresividad + ", cantidad: " + cantidad;
	}

}
