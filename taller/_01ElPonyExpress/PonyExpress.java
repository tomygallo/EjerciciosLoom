package _01ElPonyExpress;

public class PonyExpress {

	public static int jinetes(int[] estaciones) {
		int cantJinetes = 1;
		int sumaMillas = 0;

		if (estaciones[0] > 100) // si el primer elemento es mayor a 100 millas, no se puede hacer la entrega
			return 0;

		for (int i = 0; i < estaciones.length; i++) {

			// se analiza que la suma de las estaciones correspondientes a cada jinete no
			// supere las 100 millas
			if ((sumaMillas + estaciones[i]) <= 100) {
				sumaMillas += estaciones[i];
			} else { // si supera las 100, se cambia de jinete y se reinician las millas al nuevo
						// jinete
				cantJinetes++;
				sumaMillas = estaciones[i];
			}
		}

		return cantJinetes;
	}
}
