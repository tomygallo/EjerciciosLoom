package tp_lanzandoElCaber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejoArchivos {
	
	public static void leerArchivo(String path, List<Competidor> listaCompetidores) {
				
		Scanner entrada;
		try {
			entrada = new Scanner(new File(path));
			
			entrada.nextInt(); // leo el numero de competidores pero no necesito usarlo
			
			int tiros;
			double dist;
			double ang;
			int numCompetidor = 1;
			//List<Lanzamiento> lanz = new ArrayList<Lanzamiento>();
				
			while(entrada.hasNextLine()) {
				
				Competidor comp = new Competidor(numCompetidor++);
				tiros = 0;
				
				while(tiros < 3) {
					dist = entrada.nextDouble();
					ang = entrada.nextDouble();
					
					Lanzamiento lanz = new Lanzamiento(dist, ang);
					lanz.calcularDistanciaReal(); // calcula la distancia definitiva
					
					comp.agregarLanzamiento(lanz);

					tiros++;
				}
				
				listaCompetidores.add(comp);
			}				
			
			entrada.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void escribirArchivo(String path, List<Competidor> lista) throws IOException {
        try {
        	File archivo = new File(path);
            FileWriter escribir = new FileWriter(archivo, true);
          
            for (Competidor competidor : lista) {
            	int numero = competidor.getNumCompetidor();
            	String numComp= Integer.toString(numero);
    			escribir.write(numComp+" ");
    		}
            escribir.write("\n");
            escribir.close();
        } 
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
	
}
