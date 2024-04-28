package ar.edu.unju.fi.ejercicio2.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Listado {
	
	private List<Efemeride> lista = new ArrayList<>();

	public List<Efemeride> getLista() {
		return lista;
	}

	public void setLista(List<Efemeride> lista) {
		this.lista = lista;
	}
	
	public void agregar(Efemeride efemeride) {
		this.lista.add(efemeride);
	}
	
	public void mostrarDatos() {
		this.lista.forEach(efem -> System.out.println(efem));
	}
	
	public boolean eliminarEfemeride(String codigo) {
		for(Efemeride e: this.lista)
			if(e.getCodigo().equalsIgnoreCase(codigo))
				return this.lista.remove(e);
		return false;
	}

	public static void mostarMeses() {
		for(int i=0;i<Mes.values().length;i++) {
			System.out.println((i+1)+" - "+Mes.values()[i]);
		}
		System.out.println("Elija un mes: ");
	}
}
