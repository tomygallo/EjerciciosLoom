package oia1_conflictoEntreReinas;


public class Reina {
	
	private int id;
	private int posX;
	private int posY;
	
	public Reina(int id, int posX, int posY) {
		this.id = id;
		this.posX = posX;
		this.posY = posY;
	}

	public int getId() {
		return id;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
