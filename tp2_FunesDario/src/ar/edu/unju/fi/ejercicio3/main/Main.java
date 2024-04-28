package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = new Provincia[6];
		for(int i=0;i<provincias.length;i++) {
			provincias[i] = Provincia.values()[i];
		}
		
		for(int i=0;i<provincias.length;i++) {
			System.out.println(provincias[i]+provincias[i].mostrarDatos());
		}
	}

}
