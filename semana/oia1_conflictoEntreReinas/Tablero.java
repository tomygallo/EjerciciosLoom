package oia1_conflictoEntreReinas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tablero {

	private int[][] tablero;
	private int numTablero = 1;
	private int cantReinas = 1;
	private List<Reina> listaReinas = new ArrayList<Reina>();
	private List<Integer> listaSalida = new ArrayList<Integer>();
	private List<String> listaSalida2 = new ArrayList<String>();
	

	public Tablero(String path) {
		cargarReinasDesdeArchivo(path);
		tablero = new int[numTablero][numTablero];
		insertarReinasEnCasilla();
	}

	private void cargarReinasDesdeArchivo(String path) {

		try {
			Scanner archivo = new Scanner(new File(path));

			numTablero = archivo.nextInt();
			cantReinas = archivo.nextInt();

			int numReina = 1;

			while (archivo.hasNext()) {

				listaReinas.add(new Reina(numReina++, archivo.nextInt(), archivo.nextInt()));
			}

			archivo.close();

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo");
			e.printStackTrace();
		}
	}

	private void insertarReinasEnCasilla() {

		int x;
		int y;

		for (Reina reina : listaReinas) {
			x = reina.getPosX();
			y = reina.getPosY();

			if (x > numTablero || y > numTablero) {
				System.out.println("Excede los limites del tablero");
			} else {
				tablero[x - 1][y - 1] = reina.getId();
			}
		}
	}

	public void calcularConflictos() {

		int pivotX;
		int pivotY;
		int contarConflictos;
		boolean noEncuentra = true;

		for (Reina reina : this.listaReinas) {
			pivotX = reina.getPosX() - 1;
			pivotY = reina.getPosY() - 1;
			String linea = "";
			contarConflictos = 0;

			// analizo si encuentro un conflicto por derecha
			for (int j = pivotY + 1; j < this.numTablero && noEncuentra; j++) {

				if (this.tablero[pivotX][j] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX][j]);
					//linea += this.tablero[pivotX][j] + " ";
				}
			}

			noEncuentra = true;
			// analizo si encuentro conflicto por izquierda
			for (int j = pivotY - 1; j >= 0 && noEncuentra; j--) {

				if (this.tablero[pivotX][j] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX][j]);
					//linea += this.tablero[pivotX][j] + " ";
				}
			}

			noEncuentra = true;
			// analizo por abajo
			for (int i = pivotX + 1; i < this.numTablero && noEncuentra; i++) {

				if (this.tablero[i][pivotY] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[i][pivotY]);
					//linea += this.tablero[i][pivotY] + " ";
				}
			}

			noEncuentra = true;
			// analizo por arriba
			for (int i = pivotX - 1; i >= 0 && noEncuentra; i--) {

				if (this.tablero[i][pivotY] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[i][pivotY]);
					//linea += this.tablero[i][pivotY] + " ";
				}
			}

			noEncuentra = true;
			// analizo diagonal superior derecha
			for (int i = 1; pivotX - i >= 0 && pivotY + i < numTablero && noEncuentra; i++) {

				if (this.tablero[pivotX - i][pivotY + i] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX - i][pivotY + i]);
					//linea += this.tablero[pivotX - i][pivotY + i] + " ";
				}
			}

			noEncuentra = true;
			// analizo diagonal inferior derecha
			for (int i = 1; pivotX + i < numTablero && pivotY + i < numTablero && noEncuentra; i++) {

				if (this.tablero[pivotX + i][pivotY + i] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX + i][pivotY + i]);
					//linea += this.tablero[pivotX + i][pivotY + i] + " ";
				}
			}

			noEncuentra = true;
			// analizo diag superior izquierda
			for (int i = 1; pivotX - i >= 0 && pivotY - i >= 0 && noEncuentra; i++) {

				if (this.tablero[pivotX - i][pivotY - i] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX - i][pivotY - i]);
					//linea += this.tablero[pivotX - i][pivotY - i] + " ";
				}
			}

			noEncuentra = true;
			// analizo diag inferior izquierda
			for (int i = 1; pivotX + i < numTablero && pivotY - i >= 0 && noEncuentra; i++) {

				if (this.tablero[pivotX + i][pivotY - i] != 0) {
					contarConflictos++;
					noEncuentra = false;
					this.listaSalida.add(this.tablero[pivotX + i][pivotY - i]);
					//linea += this.tablero[pivotX + i][pivotY - i] + " ";
				}
			}

			// ordeno la lista de id de reinas de menor a mayor
			Collections.sort(this.listaSalida);
			
			// inserto en la primera posicion la cantidad de conflictos para que me quede el
			// array listo para escribir en archivo
			this.listaSalida.add(0, contarConflictos);	
			
			linea = listaSalida.toString();
			
			this.listaSalida2.add(linea);
		}

	}

	public void escribirArchivoSalida(String path) {

		try {
			File archivo = new File(path);
			FileWriter escribir = new FileWriter(archivo);

			for (String reina : listaSalida2) {
				escribir.write(reina + "\n");
			}

			escribir.close();

		} catch (Exception e) {
			System.out.println("Error al escribir archivo");
			e.printStackTrace();
		}

	}

}
