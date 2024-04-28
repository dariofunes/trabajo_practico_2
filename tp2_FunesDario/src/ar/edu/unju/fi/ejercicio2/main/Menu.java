package ar.edu.unju.fi.ejercicio2.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.util.Listado;

public class Menu {
	private int opcion = 0;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public void generarMenu() {
		Listado list = new Listado();
		Scanner sc = new Scanner(System.in);
		while(opcion!=5) {
			System.out.println("****** Menu de Opciones *****");
			System.out.println("1– Crear Efeméride\n2– Mostrar Efemérides\n3– Eliminar Efeméride"
					+ "\n4– Modificar Efeméride\n5– Salir\nElija una opcion: ");
			try {
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado es inválido.");
			}
			
			if(opcion>1 && opcion<5 && list.getLista().isEmpty())
				System.out.println("La lista de jugadores esta VACIA.\n");
			else
				opcion = seleccionarOpcion(opcion,sc, list);
		}
		sc.close();
	}
	
	public static int seleccionarOpcion(int opcion, Scanner sc, Listado list) {
		switch (opcion) {
		case 1: {
			System.out.println("Estas por generar una nueva Efeméride.");
			alta(list,sc,null);
			break;
		}
		case 2:{
			list.mostrarDatos();
			break;
		}
		case 3:{
			eliminarEfemeride(list,sc);
			break;
		}
		case 4:{
			modificarEfemeride(list,sc);
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
	
	public static void alta(Listado list, Scanner sc, String codigo) {
		Efemeride efemeride = new Efemeride();
		if(codigo==null) {
			System.out.println("Ingrese el código de la Efeméride: ");
			codigo = sc.next();
		}	
		efemeride.setCodigo(codigo);
		System.out.println("Ingrese el detalle de la Efeméride: ");
		efemeride.setDetalle(sc.next());
		boolean valido = false;
		int opc = -1;
		while(!valido) {
			try {
				while(opc<1 || opc>12) {
					Listado.mostarMeses();
					System.out.println("Ingrese el número de mes de la Efeméride: ");
					opc = sc.nextInt();
					if(opc<1 || opc>12)
						System.out.println("Valor Incorrecto: "+opc+". Vuelva a ingresar el número.");
				}
				efemeride.setMes(Mes.values()[opc-1]);
				do {
					System.out.println("Ingrese el dia de la Efeméride: ");
					opc = sc.nextInt();
				}while(opc<1 || opc>31);
				efemeride.setDia(opc);
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("Error: día o mes de la efémeride inválido. Vuelva a ingresar los datos.");
			}
		}
		
		list.agregar(efemeride);
	}
	
	public static void eliminarEfemeride(Listado list,Scanner sc) {
		System.out.println("Ingrese el codigo de la efeméride que desea borrar: ");
		if(list.eliminarEfemeride(sc.next()))
			System.out.println("La efeméride se ha elimado exitosamente.");
		else
			System.out.println("Error: no se pudo eliminar la efeméride. Verifique el codigo ingresado");
	}
	
	public static void modificarEfemeride(Listado list, Scanner sc) {
		System.out.println("Ingrese el codigo de la efeméride que desea modificar: ");
		String codigo = sc.next();
		if(list.eliminarEfemeride(codigo)) {
			System.out.println("La efeméride se ha encontrado.");
			alta(list, sc, codigo);
			System.out.println("La efeméride se ha modificado.");
		}
		else
			System.out.println("Error: no se encontró la efeméride. Verifique el codigo ingresado");
		
	}
	
	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
}
