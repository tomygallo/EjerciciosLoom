package _03MonjesVikingos;

public class Colerico extends Estado {
	
	public Estado recibirAtaque(Vikingo vikings)
	{	
		vikings.setAtaque(30);
		vikings.setDanioRecibido("mitad");
		return new Berserker();
	}
	
	public Estado meditar(Vikingo vikings)
	{	
		vikings.setAtaque(10);
		vikings.setDanioRecibido("normal");
		return new Normal();
	}
}
