package _03MonjesVikingos;

public class Calmado extends Estado  {
	
	public Estado atacar(Vikingo vikings)
	{	
		vikings.setAtaque(10);
		vikings.setDanioRecibido("normal");
		return new Normal();
	}
	
}
