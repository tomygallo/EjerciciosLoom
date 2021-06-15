package tp_lanzandoElCaber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class Competencia{
	
	private List<Competidor> listaCompetidores = new ArrayList<Competidor>();
	private List<Competidor> podioConsistencia = new ArrayList<Competidor>();
	private List<Competidor> podioDistancia = new ArrayList<Competidor>();
	
	public void cargarCompetidores(String path) {
		
		ManejoArchivos.leerArchivo(path, listaCompetidores);
		// la lista de competidores ya esta cargada completamente con todos los competidores	
	}
	
	public void escribirResultados(String path) throws IOException {
		
		ManejoArchivos.escribirArchivo(path, podioConsistencia);
		ManejoArchivos.escribirArchivo(path, podioDistancia);
	}
	
	public void calcularPodioDistancia() {
		
		// cargo en la lista de podio todos los competidores
		for (Competidor competidor : listaCompetidores) {
			competidor.calcularDistanciaTotal();
			podioDistancia.add(competidor);
		}
		
		// ordeno la lista de podio de la mayor distancia a la menor
		
		//Collections.sort(podioDistancia, new OrdenarCompetidorPorDistancia());
		Collections.sort(podioDistancia);
		
		// elimino las posiciones restantes para quedarme con las primeras tres, quedando asi el podio
		while(podioDistancia.size() > 3) {
			podioDistancia.remove(3);
		}
	}
	
	public void calcularPodioConsistencia() {
		for (Competidor competidor : listaCompetidores) {
			competidor.comprobarConsistencia();
			if(competidor.isCompiteConsistencia())
				podioConsistencia.add(competidor);
		}
		
		for(Competidor comp : podioConsistencia) {
			comp.calcularConsistencia();
		}
		
		Collections.sort(podioConsistencia, new OrdenarCompetidorPorConsistencia());
		
		while(podioConsistencia.size() > 3) {
			podioConsistencia.remove(3);
		}
	}
	
	public boolean compararIds(int[] listaCon, int[] listaDis) {
		
		int i = 0;
		
		for (Competidor competidor : podioConsistencia) {
			if(competidor.getNumCompetidor() != listaCon[i]) {
				return false;
			}
			i++;
		}
		
		int j = 0;
		
		for (Competidor competidor : podioDistancia) {
			if(competidor.getNumCompetidor() != listaDis[j]) {
				return false;
			}
			j++;
		}
		
		return true;
	}
	
	
	// solo para muestras en el Main ----------------------------------------------
	
	public void mostrarPodioDistancia() {
		for (Competidor competidor : podioDistancia) {
			System.out.println(competidor);
		}
	}
	
	public void mostrarPodioConsistencia() {
		for (Competidor competidor : podioConsistencia) {
			System.out.println(competidor);
		}
	}
	
	// -----------------------------------------------------------------------------
}
