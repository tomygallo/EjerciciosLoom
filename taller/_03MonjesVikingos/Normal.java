package _03MonjesVikingos;

public class Normal extends Estado  {
	
	public Estado recibirAtaque(Vikingo vikings)
	{	
		vikings.setAtaque(20);
		vikings.setDanioRecibido("doble");
		return new Colerico();
	}
	
	public Estado meditar(Vikingo vikings)
	{	
		vikings.setAtaque(0);
		vikings.setDanioRecibido("inmune");
		return new Calmado();
	}

}
