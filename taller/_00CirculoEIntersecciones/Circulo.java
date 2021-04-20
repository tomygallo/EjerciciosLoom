package _00CirculoEIntersecciones;

public class Circulo {

	Punto p1;
	private double radio;

	public Circulo(Punto p, double r) {

		if (r < 0) {
			System.out.println("El radio no puede ser negativo");
			System.exit(1);
		}

		this.radio = r;
		this.p1 = p;
	}

	
	public boolean intersectaCon(Circulo c) {

		return (this.radio + c.radio) >= p1.distanciaEntreDosPuntos(this.p1, c.p1);
	}
}
