package oia2_mesadasDeGranitos;

public class Mesada {
	private int largo;
	private int ancho;
	private int id;
	private int cantMesasEncima = 0;

	public Mesada(int id, int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCantMesasEncima() {
		return cantMesasEncima;
	}

	public void setCantMesasEncima(int cantMesasEncima) {
		this.cantMesasEncima = cantMesasEncima;
	}
	public void sumarCantMesasEncima() {
		this.cantMesasEncima ++;
	}
	
	// este metodo indica si la mesada del parametro puede colocarse encima de la mesada que la "llama"
	public boolean puedePonerseEncima(Mesada obj) {
		
		if(this.largo >= obj.largo && this.ancho >= obj.ancho) {
			return true;
		}
		if(this.largo >= obj.ancho && this.ancho >= obj.largo) {
			return true;
		}
		return false;
	}

	
	@Override
	public String toString() {
		return "Mesada --> Id: " + id + ", largo: " + largo + ", ancho: " + ancho + ", cantidad de mesas encima: " + cantMesasEncima;
	}
	
	
	
}
