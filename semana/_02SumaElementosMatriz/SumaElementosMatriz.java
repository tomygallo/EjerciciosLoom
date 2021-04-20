package _02SumaElementosMatriz;

public class SumaElementosMatriz {

	public static int[][] sumarElementosMatriz(int[][] matrizEntrada) {

		int[][] matrizSalida = new int[matrizEntrada.length][matrizEntrada[0].length];

		for (int i = 0; i < matrizEntrada.length; i++) {
			for (int j = 0; j < matrizEntrada[0].length; j++) {
				matrizSalida[i][j] = matrizEntrada[i][j];
			}
		}

		for (int i = 0; i < matrizEntrada.length; i++) {
			for (int j = 0; j < matrizEntrada[0].length; j++) {

				if (j != 0) {
					matrizSalida[i][j] += matrizEntrada[i][j - 1];
				}

				if (j != matrizEntrada[0].length - 1) {
					matrizSalida[i][j] += matrizEntrada[i][j + 1];
				}

				if (i != 0) {
					matrizSalida[i][j] += matrizEntrada[i - 1][j];
				}

				if (i != matrizEntrada.length - 1) {
					matrizSalida[i][j] += matrizEntrada[i + 1][j];
				}
			}
		}

		return matrizSalida;
	}

	public static void main(String[] args) {

		int[][] matrizEntrada = { { 1, 2, 0}, { 0, 2, -5 }, { 1, 1, -5 } };
		int[][] matrizSalida;

		matrizSalida = sumarElementosMatriz(matrizEntrada);

		for (int i = 0; i < matrizSalida.length; i++) {
			for (int j = 0; j < matrizSalida[0].length; j++) {
				System.out.print("" + matrizSalida[i][j] + "  ");
			}
			System.out.println("");
		}

	}
}
