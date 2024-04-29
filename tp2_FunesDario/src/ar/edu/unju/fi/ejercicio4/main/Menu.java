package ar.edu.unju.fi.ejercicio4.main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
import ar.edu.unju.fi.ejercicio4.util.Listado;

//import ar.edu.unju.fi.ejercicio2.util.Listado;

public class Menu {
	private int opcion = 0;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public void generarMenu() {
		Listado lista = new Listado();
		Scanner sc = new Scanner(System.in);
		while(opcion!=5) {
			System.out.println("****** Menu de Opciones *****");
			System.out.println("1– Alta de jugador\n2– Mostrar todos los jugadores\n"
					+ "3– Modificar la posición de un jugador\n4– Eliminar un jugador\n5– Salir"
					+ "\nElija una opcion: ");
			try {
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado es inválido.");
			}
			
			if(opcion>1 && opcion<5 && lista.getLista().isEmpty())
				System.out.println("La lista de jugadores esta VACIA.\n");
			else
				opcion = seleccionarOpcion(opcion,sc, lista);
		}
		sc.close();
	}
	
	public static int seleccionarOpcion(int opcion, Scanner sc, Listado lista) {
		switch (opcion) {
		case 1: {
			System.out.println("Estas por agregar un nuevo jugador.");
			lista.agregar(new Jugador("Hector", "Funes", LocalDate.of(1991, 10, 1), "Arg", 1.79f, 105.6f, Posicion.DELANTERO));
			lista.agregar(new Jugador("Claudia", "Ortiz", LocalDate.of(1971, 5, 3), "Arg", 1.68f, 92.4f, Posicion.MEDIO));
			lista.agregar(new Jugador("Marcelo", "Funes", LocalDate.of(2006, 8, 31), "Arg", 1.81f, 79.2f, Posicion.DEFENSA));
			lista.agregar(new Jugador("Dario", "Funes", LocalDate.of(1997, 11, 5), "Arg", 1.8f, 88.7f, Posicion.ARQUERO));
			lista.agregar(new Jugador("Brenda", "Pacheco", LocalDate.of(1998, 2, 9), "Arg", 1.6f, 92.5f, Posicion.MEDIO));
			//alta(lista,sc);
			break;
		}
		case 2:{
			lista.mostrarDatos();
			break;
		}
		case 3:{
			modificarPosicion(lista, sc);
			break;
		}
		case 4:{
			eliminarJugador(lista, sc);
			break;
		}
		case 5:{
			System.out.println("Realmente desea salir? (s/n)");
			if(sc.next().charAt(0)=='s') {
				System.out.println("Programa Terminado.");
				return 5;
			}
			break;
		}
		default:
			System.out.println("Valor Inesperado. Ingrese un valor entre 1 y 5.\n");
			return 0; //throw new IllegalArgumentException("Valor inesperado: " + opcion);//podemos return 0;
		}
		return 0;
	}
	
	public static void alta(Listado lista, Scanner sc) {
		Jugador jugador = new Jugador();
		System.out.println("Ingrese el nombre del jugador: ");
		jugador.setNombre(sc.next());
		System.out.println("Ingrese el apellido del jugador: ");
		jugador.setApellido(sc.next());
		boolean valido = false;
		while(!valido) {
			try {
				System.out.println("Fecha de Nac.\nIngrese el dia de nacimiento: ");
				int diaNacimiento = sc.nextInt();
				System.out.println("Ingrese el mes de nacimiento: ");
				int mesNacimiento = sc.nextInt();
				System.out.println("Ingrese el año de nacimiento: ");
				int anioNacimiento = sc.nextInt();
				jugador.setFechaNacimiento(LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento));
				valido = true;
			}catch (DateTimeException e) {
				System.out.println("Error: Fecha inválida. Vuelva a ingresar la fecha.");
			}catch (InputMismatchException e) {
				System.out.println("Valor inválido. Por favor vuelva a ingresar la fecha de nacimiento.");
			}
		}
		
		System.out.println("Ingrese la nacionalidad del jugador: ");
		jugador.setNacionalidad(sc.next());
		valido = false;
		while(!valido) {
			try {
				System.out.println("Ingrese la altura del jugador: ");
				jugador.setAltura(sc.nextFloat());
				System.out.println("Ingrese el peso del jugador: ");
				jugador.setPeso(sc.nextFloat());
				
				Listado.mostarPosiciones();
				int posicion;
				do {
					System.out.println("Ingrese la posicion del jugador, mostrada arriba: (ingrese un valor numerico)");
					posicion = sc.nextInt();
					if(posicion<1 || posicion>4)
						System.out.println("Error: valor incorrecto: "+posicion+". Ingrese un valor entre 1 y 4.");
				}while(posicion<1 || posicion>4);
				jugador.setPosicion(Posicion.values()[posicion-1]);
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("Valor ingresado inválido. Por favor vuelva a ingresar los datos.");
			}
		}
		
		lista.agregar(jugador);
	}
	
	public static void eliminarJugador(Listado lista,Scanner sc) {
		System.out.println("Ingrese el nombre del Jugador que desea eliminar: ");
		String nombre = sc.next();
		System.out.println("Ingrese el apellido del Jugador que desea eliminar: ");
		String apellido = sc.next();
		if(lista.eliminarJugador(nombre,apellido))
			System.out.println("El jugador se ha elimado exitosamente.");
		else
			System.out.println("Error: no se pudo eliminar el jugador. Verifique el nombre y apellido ingresado");
	}
	
	public static void modificarPosicion(Listado lista, Scanner sc) {
		System.out.println("Ingrese el nombre del Jugador que desea modificar: ");
		String nombre = sc.next();
		System.out.println("Ingrese el apellido del Jugador que desea modificar: ");
		String apellido = sc.next();
		int posicion = lista.buscarJugador(nombre,apellido);
		if(posicion>=0) {
			System.out.println("Jugador encontrado...\nIngrese la nueva posición del jugador: ");
			lista.modificarPosicion(nombre,apellido,sc,posicion);
			System.out.println("La posicion del jugador se ha modificado con exito.");
		}
		else
			System.out.println("Error: no se encontró jugador con ese nombre y apellido. Verifique los datos ingresados.");
		
	}
}
