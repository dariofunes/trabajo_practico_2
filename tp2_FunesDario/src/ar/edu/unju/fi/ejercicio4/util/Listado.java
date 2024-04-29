package ar.edu.unju.fi.ejercicio4.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Listado {
	private List<Jugador> lista = new ArrayList<>();

	public List<Jugador> getLista() {
		return lista;
	}

	public void setLista(List<Jugador> lista) {
		this.lista = lista;
	}
	
	public void agregar(Jugador jugador) {
		this.lista.add(jugador);
	}
	
	public void mostrarDatos() {
		this.lista.forEach(jugador -> System.out.println(jugador));
	}
	
	public boolean eliminarJugador(String nombre,String apellido) {
		Iterator<Jugador> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Jugador j = iterador.next();
			if(j.getNombre().equalsIgnoreCase(nombre) && j.getApellido().equalsIgnoreCase(apellido)){
				iterador.remove();
				return true;
			}
		}
		return false;
	}
	
	public int buscarJugador(String nombre, String apellido) {
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i).getNombre().equalsIgnoreCase(nombre) && lista.get(i).getApellido().equalsIgnoreCase(apellido))
				return i;
		}
		return -1;
	}
	
	public void modificarPosicion(String nombre, String apellido, Scanner sc, int pos) {
		mostarPosiciones();
		boolean valido = false;
		do{
			try {
				int posicion;
				do {
					System.out.println("Ingrese la posicion del jugador, mostrada arriba: (ingrese un valor numerico)");
					posicion = sc.nextInt();
					if(posicion<1 || posicion>4)
						System.out.println("Error: valor incorrecto: "+posicion+". Ingrese un valor entre 1 y 4.");
				}while(posicion<1 || posicion>4);
				lista.get(pos).setPosicion(Posicion.values()[posicion-1]);
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("Valor ingresado inválido. Por favor vuelva a ingresar la posición del jugador.");
			}
		}while(!valido);
	}
	
	public static void mostarPosiciones() {
		System.out.println("------- Posiciones -------\n");
		for(int i=0;i<Posicion.values().length;i++) {
			System.out.println((i+1)+" - "+Posicion.values()[i]);
		}
		System.out.println("Elija una posición: ");
	}
}
