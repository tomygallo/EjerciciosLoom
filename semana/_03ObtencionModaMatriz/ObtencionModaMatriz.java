package _03ObtencionModaMatriz;

public class ObtencionModaMatriz {

	public static int[] obtenerModa(int[][] matriz) {

		int cont, max = 0;
		boolean mayor; // bandera

		int[] vectorSalida = new int[matriz.length]; // vector final con salida correcta
		

		for (int i = 0; i < matriz.length; i++) {
			
			int[] vecAuxiliar = new int[matriz[i].length]; // vector para guardar cada fila para poder comparar luego
			
			mayor = false;
			//vecAuxiliar = matriz[i]; // guardo la fila para compararla

			for (int j = 0; j < matriz[i].length; j++) {

				cont = 0;

				for (int k = 0; k < matriz[i].length; k++) {
					if (matriz[i][j] == vecAuxiliar[k]) { // comparo cada valor de la fila aux con el valor de la matriz
						cont++;
					}
				}

				if (mayor == false || max < cont) {
					mayor = true;
					max = cont;
					vectorSalida[i] = matriz[i][j];
				} else if (max == cont) {
					if (vectorSalida[i] < matriz[i][j]) {
						vectorSalida[i] = matriz[i][j];
					}
				}
			}

		}

		return vectorSalida;
	}

	public static void main(String[] args) {

		int[][] mat = {{0}, {1,2,2}, {2}};;
		int[] vecSal = new int[mat.length];

		vecSal = obtenerModa(mat);

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < vecSal.length; i++) {
			System.out.print(vecSal[i] + " ");
		}

	}

}
