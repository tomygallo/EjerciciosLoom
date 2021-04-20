package _00ComprobacionDiagPrincipal;

public class ComprobacionDiagPrinc {

	public static boolean comprobarDiagPrinc(int[][] mat) {

		int suma = mat[0][0];

		for (int i = 1; i < mat.length; i++) {
			if (mat[i][i] != suma) {
				return false;
			}
			suma += mat[i][i];
		}

		return true;
	}

	public static void main(String[] args) {

//		int[][] mat = { { 1, 2, 3 }, { 4, 1, 6 }, { 7, 8, 2 } };
		int[][] mat = { { 3, 2, 3 }, { 4, 3, 6 }, { 7, 7, 6 } };

		System.out.println(comprobarDiagPrinc(mat));

	}
}
