package tp_lanzandoElCaber;

import java.util.ArrayList;
import java.util.List;

public class Competidor implements Comparable<Competidor>{
	private int numCompetidor = 0;
	private List<Lanzamiento> listaLanzamientos = new ArrayList<Lanzamiento>();
	private double distanciaTotal = 0;
	private double consistenciaXdistancia;
	private double consistenciaXangulo;
	private boolean compiteConsistencia = true;
	
	public Competidor(int num) {
		this.numCompetidor = num;
	}
	
	public void agregarLanzamiento(Lanzamiento lanz) {
		listaLanzamientos.add(lanz);
	}
	
	public void calcularDistanciaTotal()
	{
		for (Lanzamiento lanzamiento : listaLanzamientos) {
			if(lanzamiento.esLanzamientoValido()) {
				distanciaTotal += lanzamiento.getDistancia();
			}
		}
	}
	
	public void calcularConsistencia()
	{	
		double dif1 = listaLanzamientos.get(0).getDistancia() - listaLanzamientos.get(1).getDistancia();
		double dif2 = listaLanzamientos.get(0).getDistancia() - listaLanzamientos.get(2).getDistancia();
		double dif3 = listaLanzamientos.get(1).getDistancia() - listaLanzamientos.get(2).getDistancia();
		
		if(dif1 < 0) {
			dif1 *= -1;
		}
		if(dif2 < 0) {
			dif2 *= -1;
		}
		if(dif3 < 0) {
			dif3 *= -1;
		}

		if(dif1 > 0){
			consistenciaXdistancia = dif1;
		}
		if(dif2 < consistenciaXdistancia) {
			consistenciaXdistancia = dif2;
		}
		if(dif3 < consistenciaXdistancia) {
			consistenciaXdistancia = dif3;
		}
		
		int ang1 = (int) Math.abs(listaLanzamientos.get(0).getAngulo() - listaLanzamientos.get(1).getAngulo());
		int ang2 = (int) Math.abs(listaLanzamientos.get(0).getAngulo() - listaLanzamientos.get(2).getAngulo());
		int ang3 = (int) Math.abs(listaLanzamientos.get(1).getAngulo() - listaLanzamientos.get(2).getAngulo());
		
		if(ang1 > 0){
			consistenciaXangulo = ang1;
		}
		if(ang2 < consistenciaXangulo) {
			consistenciaXangulo = ang2;
		}
		if(ang3 < consistenciaXangulo) {
			consistenciaXangulo = ang3;
		}
	}
	
	// analizar
	public void comprobarConsistencia() {
		for (Lanzamiento lanzamiento : listaLanzamientos) {
			if(!lanzamiento.esLanzamientoValido()) {
				compiteConsistencia = false;
			}
		}
	}
	
	
	// analizar
	public boolean isCompiteConsistencia() {
		return compiteConsistencia;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	
	public double getConsistenciaXdistancia() {
		return consistenciaXdistancia;
	}
	
	public double getConsistenciaXangulo() {
		return consistenciaXangulo;
	}
	
	public int getNumCompetidor() {
		return numCompetidor;
	}

	@Override
	public String toString() {
		return "Competidor = " + numCompetidor + ", Distancia Total = " + distanciaTotal;
	}

	@Override
	public int compareTo(Competidor comp) {
		if(comp.getDistanciaTotal() > this.distanciaTotal) {
			return 1;
		}else if(comp.getDistanciaTotal() == this.distanciaTotal) {
			return 0;
		}	
		return -1;
	}

//	public double compareTo(Competidor comp) {
//		return  (comp.getDistanciaTotal() - this.getDistanciaTotal());
//	}
	
	
	
}
