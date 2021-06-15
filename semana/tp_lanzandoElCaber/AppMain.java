package tp_lanzandoElCaber;

import java.io.IOException;

public class AppMain {
	
	public static void main(String[] args) throws IOException {
		Competencia torneo = new Competencia();
		
		torneo.cargarCompetidores("entradas\\entradaEmpate.txt");
		torneo.calcularPodioDistancia();
		torneo.calcularPodioConsistencia();
		
		System.out.println("Podio de Consistencia");
		torneo.mostrarPodioConsistencia();
		System.out.println();
		System.out.println("Podio de Distancia");
		torneo.mostrarPodioDistancia();
		torneo.escribirResultados("salidasObtenidas\\salidaEmpate.txt");
		
		Competencia torneo2 = new Competencia();
		
		torneo2.cargarCompetidores("entradas\\entradaEnunciado.txt");
		torneo2.calcularPodioDistancia();
		torneo2.calcularPodioConsistencia();
		
		System.out.println("Podio de Consistencia");
		torneo2.mostrarPodioConsistencia();
		System.out.println();
		System.out.println("Podio de Distancia");
		torneo2.mostrarPodioDistancia();
		torneo2.escribirResultados("salidasObtenidas\\salidaEnunciado.txt");
		
		Competencia torneo3 = new Competencia();
		
		torneo3.cargarCompetidores("entradas\\entradaFlujoNormal1.txt");
		torneo3.calcularPodioDistancia();
		torneo3.calcularPodioConsistencia();
		
		System.out.println("Podio de Consistencia");
		torneo3.mostrarPodioConsistencia();
		System.out.println();
		System.out.println("Podio de Distancia");
		torneo3.mostrarPodioDistancia();
		torneo3.escribirResultados("salidasObtenidas\\salidaFlujoNormal1.txt");
		
		Competencia torneo4 = new Competencia();
		
		torneo4.cargarCompetidores("entradas\\entradaPodiosNoCompartenCompetidores.txt");
		torneo4.calcularPodioDistancia();
		torneo4.calcularPodioConsistencia();
		
		System.out.println("Podio de Consistencia");
		torneo4.mostrarPodioConsistencia();
		System.out.println();
		System.out.println("Podio de Distancia");
		torneo4.mostrarPodioDistancia();
		torneo4.escribirResultados("salidasObtenidas\\salidaPodiosNoCompartenCompetidores.txt");
		
		Competencia torneo5 = new Competencia();
		
		torneo5.cargarCompetidores("entradas\\entradaSinPodioConsistencia.txt");
		torneo5.calcularPodioDistancia();
		torneo5.calcularPodioConsistencia();
		
		System.out.println("Podio de Consistencia");
		torneo5.mostrarPodioConsistencia();
		System.out.println();
		System.out.println("Podio de Distancia");
		torneo5.mostrarPodioDistancia();
		torneo5.escribirResultados("salidasObtenidas\\salidaSinPodioConsistencia.txt");
	}
}
