package _04ObtencionDiagonales;

public class ObtencionDiagonales {
	
	
	public static int[][] obtenerMatriz(int[][] matrizEntrada) {

		int[][] matSalida = new int[matrizEntrada.length * 2 - 1][matrizEntrada.length * 2 - 1];
		int i, j, cont = 1, iniColumna, iniFila, limitePasadas = matrizEntrada.length * matrizEntrada.length;
		int tamFila = matrizEntrada.length, finFila = 0;
		int fs = 0;

		iniColumna = 0;
		iniFila = 0;

		while (cont < limitePasadas) {

			cont++;

			i = tamFila - 1;
			j = iniColumna;

			while (i >= finFila) {

				matSalida[fs][j] = matrizEntrada[i][j];

				i--;
				fs++;
			}

			i++;
			j++;

			while (j <= tamFila - 1) {

				matSalida[fs][i] = matrizEntrada[i][j];

				j++;
				fs++;
			}

			iniColumna++;
			iniFila++;
			fs = iniFila;

			finFila++;

		}

		return matSalida;
	}
	
	static void mostrarDiagonales(int matriz[][]) {

		int filas = matriz.length;
		int columnas = matriz[0].length;

		for (int i = filas - 1; i > 0; i--) {
			for (int j = 0; j < columnas - i; j++)

				System.out.print(matriz[i + j][j] + " ");

			System.out.println("");
		} // muestra triangulo inferior a la diag. principal

		for (int i = 0; i < filas; i++)
			System.out.print(matriz[i][i] + " ");
		// muestra diagonal principal

		System.out.println("");

		for (int j = 1; j < columnas; j++) {
			for (int i = 0; i < filas - j; i++)

				System.out.print(matriz[i][j + i] + " ");

			System.out.println("");
		} // muestra triangulo superior a diag. principal
	}

	public static void main(String[] args) {

		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }};
//		int[][] mat = { { 1, 2, 3, 4, 17 }, { 5, 6, 7, 8, 18 }, { 9, 10, 11, 12, 19 }, { 13, 14, 15, 16, 20 }, {21, 22, 23, 24, 25}};
		
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		int[][] mat2 = obtenerMatriz(mat);

		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[i].length; j++) {
				if (mat2[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(mat2[i][j] + " ");
				}

			}
			System.out.println();
		}
		
		System.out.println();
		mostrarDiagonales(mat);
		

		
	}

}
