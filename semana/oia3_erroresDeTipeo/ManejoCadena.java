package oia3_erroresDeTipeo;

public class ManejoCadena {

	private int contarMovimientos = 0;

	public int procesador(String texto, String prueba) {

		int posPrueba;

		// recorro el String original asi voy comparando cada cadena verificando que
		// tengan los mismos elementos
		for (int iTexto = 0; iTexto < texto.length(); iTexto++) {

			// pregunto si en la misma posicion tienen distinto elemento, de ser asi debo
			// buscar el que corresponde y contar los intercambios
			if (texto.charAt(iTexto) != prueba.charAt(iTexto)) {
				posPrueba = buscarPosicionChar(iTexto, texto.charAt(iTexto), prueba);
				intercambiarPosiciones(posPrueba, iTexto, prueba);
			}
		}

		return contarMovimientos;
	}

	// busca en la segunda cadena la posicion del elemento que debo reacomodar
	private int buscarPosicionChar(int posInicial, char letra, String prueba) {

		for (int i = posInicial; i < prueba.length(); i++) {
			if (prueba.charAt(i) == letra) {
				return i;
			}
		}
		return -1; // retorna esto si no encontro
	}

	// reacomoda el elemento a donde debe estar sumando al contador cada intercambio
	private void intercambiarPosiciones(int posInicial, int posFinal, String prueba) {

		char aux;

		// la posFinal sirve para que no recorra posiciones que ya estan ordenadas y
		// contadas
		while (posInicial > posFinal) {

			aux = prueba.charAt(posInicial - 1);
			prueba.replace(prueba.charAt(posInicial - 1), prueba.charAt(posInicial));
			prueba.replace(prueba.charAt(posInicial), aux);

			contarMovimientos++;
			posInicial--;
		}
	}
}
