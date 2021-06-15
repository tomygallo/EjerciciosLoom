package _03MonjesVikingos;

public class Berserker extends Estado  {
	
	public Estado meditar(Vikingo vikings)
	{	
		vikings.setAtaque(10);
		vikings.setDanioRecibido("normal");
		return new Normal();
	}
}
