package oia5_vagonesDeTren;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Vagon {

	private int cantidadEspecies;
	private int limiteAgresividad;
	private int cantVagones = 0;
	private int agresividadTotal = 0;
	List<Especie> listaEspecies = new ArrayList<Especie>();

	public void cargarEspeciesDesdeArchivo(String path) {

		try {
			Scanner archivo = new Scanner(new File(path));

			cantidadEspecies = archivo.nextInt();
			limiteAgresividad = archivo.nextInt();

			while (archivo.hasNext()) {
				String aux = archivo.next();
				String[] especie = aux.split(" ");

				listaEspecies.add(new Especie(especie[0], archivo.nextInt(), archivo.nextInt()));

			}

			archivo.close();

		} catch (Exception e) {
			System.out.println("Error al leer archivo");
			e.printStackTrace();
		}

	}

	private int contarCantidadAnimalesTotales() {

		int cont = 0;

		for (Especie especie : listaEspecies) {
			cont += especie.getCantidad();
		}

		return cont;
	}

	public int calcularVagones() {

		if (contarCantidadAnimalesTotales() > 2500) {
			System.out.println("ERROR: Supera la cantidad maxima de animales a transportar");
			return -1;
		}

		// ordeno de mayor a menor por agresividad
		ordenarPorAgresividad();

		// variable que va sumando la agresividad por vagon, y las variables de minimo y
		// maximo por vagon
		int sumaAgresividadParcial = 0, minAgre = 30001, maxAgre = -1;

		// recorro toda la lista y termino cuando este vacia
		while (!listaEspecies.isEmpty()) {

			// con este ciclo me encargo de poner aquellos que superan el limite y me quedan
			// una especie por vagon
			while (!listaEspecies.isEmpty() && listaEspecies.get(0).getAgresividad() > limiteAgresividad) {
				cantVagones++;
				listaEspecies.remove(0);
			}
			
			// con este analizo ya con aquellos que puedo colocar mas de una especie por vagon
			while (!listaEspecies.isEmpty()) {
				
				// evaluo que la suma de las agresividades de ese vagon no supere el limite
				if (sumaAgresividadParcial + listaEspecies.get(0).getAgresividad() <= limiteAgresividad) {
					sumaAgresividadParcial += listaEspecies.get(0).getAgresividad();
					
					if (listaEspecies.get(0).getAgresividad() > maxAgre) {
						maxAgre = listaEspecies.get(0).getAgresividad();
					}
					if (listaEspecies.get(0).getAgresividad() < minAgre) {
						minAgre = listaEspecies.get(0).getAgresividad();
					}

				} else {
					// compruebo que el minimo no sea el mismo que el maximo para que no se cancelen
					// y que sume a la agresividad total un solo valor
					if (maxAgre == minAgre) {
						agresividadTotal += maxAgre;
					} else {
						agresividadTotal += (maxAgre - minAgre);
					}
					cantVagones++;
					sumaAgresividadParcial = listaEspecies.get(0).getAgresividad();
					
					// reinicio las variables para el nuevo vagon
					minAgre = 30001;
					maxAgre = -1;
				}
				
				
				
				// elimino la especie que ya utilice y no necesito
				listaEspecies.remove(0);
				
				// debo analizar esto para sumar un ultimo vagon ya que no lo estoy sumando antes
				if (listaEspecies.isEmpty()) {
					agresividadTotal += (maxAgre - minAgre);
					cantVagones++;
				}

			}
		}

		return cantVagones;
	}
	
	public void escribirArchivo(String path) {
		
		try {
			FileWriter archivo = new FileWriter(new File(path));
			BufferedWriter escribir = new BufferedWriter(archivo);
			
			escribir.write("" + cantVagones + " " + agresividadTotal);
			
			archivo.close();
			
		} catch (Exception e) {
			System.out.println("Error al escribir archivo");
			e.printStackTrace();
		}
	}

	private void ordenarPorAgresividad() {

		Collections.sort(listaEspecies, new OrdenarAgresividadMayorAMenor());
	}

	public static void main(String[] args) {

		Vagon vagon = new Vagon();

		vagon.cargarEspeciesDesdeArchivo("vagones.in");
		// vagon.mostrarLista();

		System.out.println("La cantidad de vagones minimo necesario es de: " + vagon.calcularVagones());

	}

	public int getAgresividadTotal() {
		return agresividadTotal;
	}	
}
