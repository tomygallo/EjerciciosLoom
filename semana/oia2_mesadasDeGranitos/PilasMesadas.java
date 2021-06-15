package oia2_mesadasDeGranitos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PilasMesadas {
	private int cantidadMesadasTotales;
	private int cantPilasTotales;
	private List<Mesada> listaMesadasTotales = new ArrayList<Mesada>();

	public void cargarMesadasDesdeArchivo(String path) {

		try {
			Scanner archivo = new Scanner(new File(path));
			int i = 1;

			cantidadMesadasTotales = archivo.nextInt();

			while (archivo.hasNext()) {
				listaMesadasTotales.add(new Mesada(i++, archivo.nextInt(), archivo.nextInt()));
			}

			archivo.close();

			// calcula las mesadas encima que cada una puede tener
			calcularMesadasEncimas();

		} catch (Exception e) {
			System.out.println("Error al leer archivo");
			e.printStackTrace();
		}

	}

	public void generarArchivoSalida(String path) {

		try {
			File archivo = new File(path);
			FileWriter escribir = new FileWriter(archivo);

			escribir.write(cantPilasTotales + "");

			escribir.close();

		} catch (Exception e) {
			System.out.println("Error al escribir archivo");
			e.printStackTrace();
		}
	}

	public int getCantidadMesadasTotales() {
		return cantidadMesadasTotales;
	}

	private void calcularMesadasEncimas() {

		for (Mesada mesada : listaMesadasTotales) {

			mesada.setCantMesasEncima(0);

			for (int i = 0; i < listaMesadasTotales.size(); i++) {

				if (mesada.getId() != listaMesadasTotales.get(i).getId()) {

					if (mesada.puedePonerseEncima(listaMesadasTotales.get(i))) {
						mesada.sumarCantMesasEncima();
					}
				}
			}
		}
	}

	private void ordenarListaMesadaMayorAMenor() {

		Collections.sort(listaMesadasTotales, new OrdenarMesadasPorCantidadEncima());
	}

	// calcula la cantidad de pilas minimas necesarias, lo que pide el enunciado
	public void calcularCantPilas() {

		int jAux;
		cantPilasTotales = 0;
		List<Mesada> pilaAux = new ArrayList<Mesada>();

		// ordeno la lista por cantidad de mesadas que cada una puede apilar encima
		ordenarListaMesadaMayorAMenor();

		while (!listaMesadasTotales.isEmpty()) {
			// saco el primer elemento de la lista original(que es el de mayor cantidad
			// encima) y lo coloco en la auxiliar donde voy apilando las mesas
			pilaAux.add(listaMesadasTotales.remove(0));

			jAux = 0; // iterador de la lista auxiliar

			// recorro la lista original viendo cuales mesadas puedo poner encima de la
			// ultima que esta en la auxiliar. Voy modificando la lista a medida que la
			// recorro
			for (int iLista = 0; iLista < listaMesadasTotales.size(); iLista++) {

				if (pilaAux.get(jAux).puedePonerseEncima(listaMesadasTotales.get(iLista))) {
					pilaAux.add(listaMesadasTotales.remove(iLista));
					jAux++;
					iLista--; // decremento el iterador ya que removi un elemento de la lista iterada y debo
								// volver a la posicion anterior
				}
			}

			cantPilasTotales++; // contador de las pilas que indicara el archivo de salida
			pilaAux.clear();
			// limpio la auxiliar de los elementos que ya no necesito usar, quedandome en la
			// original con los que tengo que seguir evaluando
		}
	}

	public int getCantPilasTotales() {
		return cantPilasTotales;
	}

	// para pruebas en el AppMain
	@Override
	public String toString() {
		String cadena = "";
		for (Mesada mesada : listaMesadasTotales) {
			cadena += mesada.toString() + "\n";
		}
		return cadena;
	}

}
