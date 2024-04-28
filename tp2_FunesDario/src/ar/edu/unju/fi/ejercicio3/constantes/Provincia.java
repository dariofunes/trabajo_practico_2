package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(673973, 37623),
	SALTA(1453269, 159549),
	TUCUMAN(1668312, 25736),
	CATAMARCA(367828, 102602),
	LA_RIOJA(389635, 92306),
	SANTIAGO_DEL_ESTERO(874061, 142587);
	
	private int cantidaPoblacion;
	private int superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}

	private Provincia(int cantidaPoblacion, int superficie) {
		this.cantidaPoblacion = cantidaPoblacion;
		this.superficie = superficie;
	}
	
	public String mostrarDatos() {
		return "\nPoblacion= " + cantidaPoblacion + "\nSuperficie= " + superficie + " km2"
				+ "\nDensidad Poblacinal= " + calcularDensidadPoblacional() + "\n";
	}
	
	public double calcularDensidadPoblacional() {
		return (double) this.cantidaPoblacion/this.superficie;
	}

	public int getCantidaPoblacion() {
		return cantidaPoblacion;
	}

	public void setCantidaPoblacion(int cantidaPoblacion) {
		this.cantidaPoblacion = cantidaPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
}
