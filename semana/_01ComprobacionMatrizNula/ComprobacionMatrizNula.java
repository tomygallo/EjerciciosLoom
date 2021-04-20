package _01ComprobacionMatrizNula;

public class ComprobacionMatrizNula {

	public static boolean comprobarMultiNula(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

//		int[][] mat = { { 1, 2, 1 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] mat = { { 1, 2, 3, 4, 5 }, { 4, 5, 6, 7, 0} };

		System.out.println(comprobarMultiNula(mat));

	}

}
