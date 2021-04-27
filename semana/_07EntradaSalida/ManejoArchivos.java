package _07EntradaSalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivos {

	private int cant, promedio, minimo = 12001, maximo = -1; // estos valores iniciales son para poder comparar luego
																// correctamente
	private File archivo;

	public void escribirArchivoValores(String nombreArchivo) { // metodo que escribe en archivo los numeros iniciales

		cant = (int) (Math.floor(Math.random() * (10001) + 10000)); // cantidad de numeros entre 10000 y 20000

		// creo el stream de escritura de archivo
		archivo = new File(nombreArchivo);
		FileWriter archWriter = null;
		BufferedWriter bW = null;

		try {
			archWriter = new FileWriter(archivo);
			bW = new BufferedWriter(archWriter);

			for (int i = 0; i < cant; i++) {

				bW.write((int) (Math.random() * 12001) + "\n"); // un numero aleatorio por linea entre 0 y 12000
																// inclusives
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bW.close();
				archWriter.close(); // cierro archivos
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void leerArchivoYObtenerValores(String nombreArchivo) { // metodo que lee el archivo antes creado y obtiene
																	// lo pedido

		int numero, suma = 0, i = 0;
		// creo el stream de lectura
		archivo = new File(nombreArchivo);
		FileReader archReader = null;
		BufferedReader br = null;

		try {
			archReader = new FileReader(archivo);
			br = new BufferedReader(archReader);

			while (archivo.canRead() && i < cant) { // ciclo que comprueba que haya algo que leer y que el ciclo sea
													// menor a la cantidad total de numeros
				numero = Integer.parseInt(br.readLine()); // leo cada linea el numero completo en String y casteo a
															// Entero

				if (numero > maximo) {
					maximo = numero;
				}
				if (numero < minimo) {
					minimo = numero;
				}

				suma += numero;
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close(); // cierro stream
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		promedio = (int) (suma / cant);

	}

	public void escribirResultado(String nombreArchivo) { // metodo que escribe el resultado con el formato pedido

		// creo stream de escritura
		archivo = new File(nombreArchivo);
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(archivo);
			bw = new BufferedWriter(fw);

			// escribo en el txt los resultados con los formatos pedidos
			bw.write("+----------+-------+\n");
			bw.write(String.format("| Máximo   | %5d |\n", maximo));
			bw.write("+----------+-------+\n");
			bw.write(String.format("| Mínimo   | %5d |\n", minimo));
			bw.write("+----------+-------+\n");
			bw.write(String.format("| Promedio | %5d |\n", promedio));
			bw.write("+----------+-------+\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		ManejoArchivos m = new ManejoArchivos();

		m.escribirArchivoValores("archivoPrueba.txt");
		m.leerArchivoYObtenerValores("archivoPrueba.txt");
		m.escribirResultado("archResultado.txt");
	}

}
