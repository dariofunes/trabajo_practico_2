package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	
	private static void modificarPrecioOrigenCategoria(Producto producto,Scanner sc,int num) {
		boolean valido = false;
		int opcion = -1;
		if(num==3) {
			while(!valido) {
				try {
					while(opcion<1 || opcion>4) {
						mostarOrigenFabricacion();
						System.out.println("Ingrese el origen de fabricacion del Producto, los origenes validos se muestra arriba: ");
						opcion = sc.nextInt();
						if(opcion<1 && opcion>4)
							System.out.println("Valor Incorrecto: "+opcion+". Vuelva a ingresar el origen.");
					}
					producto.setOrigenFabricacion(OrigenFabricacion.values()[opcion-1]);
					valido = true;
				}catch (InputMismatchException e) {
					sc.next();
					System.out.println("Error: Origen o Categoria del producto inválido. Vuelva a ingresar los datos.");
				}
			}
		}else { 
			if(num==4){
				while(!valido) {
					try {
						while(opcion<1 || opcion>4) {
							mostarCategorias();
							System.out.println("Ingrese la categoria del Producto, las categorias validas se muestra arriba: ");
							opcion = sc.nextInt();
							if(opcion<1 && opcion>4)
								System.out.println("Valor Incorrecto: "+opcion+". Vuelva a ingresar el origen.");
						}
						producto.setCategoria(Categoria.values()[opcion-1]);
						valido = true;
					}catch (InputMismatchException e) {
						sc.next();
						System.out.println("Error: Origen o Categoria del producto inválido. Vuelva a ingresar los datos.");
					}
				}
			}else {
				if(num==2) {
					while(!valido) {
						try {
							System.out.println("Ingrese el precio del Producto: ");
							producto.setPrecioUnitario(sc.nextDouble());
							valido = true;
						}catch (InputMismatchException e) {
							sc.next();
							System.out.println("El valor ingresado para el precio es inválido. Por favor vuelva a ingresar el precio.");
						}
					}
				}else
					System.out.println("Valor Invalido: "+num);
			}
		}
	}
	
	private static Producto eliminarProducto(ArrayList<Producto> productos, String codigo) {
		for(Producto p : productos)
			if(p.getCodigo().equalsIgnoreCase(codigo)) {
				productos.remove(p);
				return p;
			}
		return null;
	}
	
	private static void modificarProducto(ArrayList<Producto> productos,Scanner sc) {
		System.out.println("Usted va a modificar un Producto.");
		System.out.println("Ingrese el codigo del producto a modificar: ");
		Producto producto = eliminarProducto(productos, sc.next());
		while(producto==null){
			System.out.println("Valor invalido. Vuelva a ingresar el codigo de Producto.");
			producto = eliminarProducto(productos, sc.next());
		}
		int opcion = 0;
		while(opcion<1 || opcion>4) {
			try {
				System.out.println("Que desea modificar de este Producto: \n1- Descripción\n2- Precio Unitario"
						+ "\n3- Origen Fabricación\n4- Categoría\nElija una opcion: ");
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("Error: valor invalido. Vuelva a ingresar el valor.");
			}
		}
		switch (opcion) {
		case 1: {
			System.out.println("Ingrese la descripcion del Producto: ");
			producto.setDescripcion(sc.next());
			break;
		}
		case 2:{
			modificarPrecioOrigenCategoria(producto,sc,opcion);
			break;
		}
		case 3:{
			modificarPrecioOrigenCategoria(producto,sc,opcion);
			break;
		}
		case 4:{
			modificarPrecioOrigenCategoria(producto,sc,opcion);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
		productos.add(producto);
	}
	
	private static void mostarCategorias() {
		System.out.println("\n------ Categoría ------\n");
		for(int i=0;i<Categoria.values().length;i++) {
			System.out.println((i+1)+" - "+Categoria.values()[i]);
		}
		System.out.println("Elija una opción: ");
	}
	
	private static void mostrarProductos(ArrayList<Producto> productos) {
		productos.forEach(producto -> System.out.println(producto));
	}
	
	private static void mostarOrigenFabricacion() {
		//OrigenFabricacion[] origenes = OrigenFabricacion.values();
		System.out.println("\n---- Origen de Fabricación ------\n");
		for(int i=0;i<OrigenFabricacion.values().length;i++) {
			System.out.println((i+1)+" - "+OrigenFabricacion.values()[i]);
		}
		System.out.println("Elija una opción: ");
	}
	
	public static void alta(ArrayList<Producto> productos,Scanner sc) {
		Producto producto = new Producto();
		System.out.println("Ingrese el código del Producto: ");
		producto.setCodigo(sc.next());
		System.out.println("Ingrese la descripcion del Producto: ");
		producto.setDescripcion(sc.next());
		boolean valido = false;
		int opcion = -1;
		while(!valido) {
			try {
				while(opcion<1 || opcion>4) {
					mostarOrigenFabricacion();
					System.out.println("Ingrese el origen de fabricacion del Producto, los origenes validos se muestra arriba: ");
					opcion = sc.nextInt();
					if(opcion<1 && opcion>4)
						System.out.println("Valor Incorrecto: "+opcion+". Vuelva a ingresar el origen.");
				}
				producto.setOrigenFabricacion(OrigenFabricacion.values()[opcion-1]);
				opcion=-1;
				while(opcion<1 || opcion>4) {
					mostarCategorias();
					System.out.println("Ingrese la categoria del Producto, las categorias validas se muestra arriba: ");
					opcion = sc.nextInt();
					if(opcion<1 && opcion>4)
						System.out.println("Valor Incorrecto: "+opcion+". Vuelva a ingresar el origen.");
				}
				producto.setCategoria(Categoria.values()[opcion-1]);
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("Error: Origen o Categoria del producto inválido. Vuelva a ingresar los datos.");
			}
		}
		
		valido = false;
		while(!valido) {
			try {
				System.out.println("Ingrese el precio del Producto: ");
				producto.setPrecioUnitario(sc.nextDouble());
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado para el precio es inválido. Por favor vuelva a ingresar el precio.");
			}
		}
		productos.add(producto);
	}
	
	public static int seleccionarOpcion(int opcion, Scanner sc, ArrayList<Producto> productos) {
		switch (opcion) {
		case 1: {
			System.out.println("Estas por agregar un nuevo producto.");
			alta(productos,sc);
			break;
		}
		case 2:{
			mostrarProductos(productos);
			break;
		}
		case 3:{
			modificarProducto(productos,sc);
			break;
		}
		case 4:{
			System.out.println("Realmente desea salir? (s/n)");
			if(sc.next().charAt(0)=='s') {
				System.out.println("Programa Terminado.");
				return 4;
			}
			break;
		}
		default:
			System.out.println("Valor Inesperado. Ingrese un valor entre 1 y 4.\n");
			return 0; //throw new IllegalArgumentException("Valor inesperado: " + opcion);//podemos return 0;
		}
		return 0;
	}
	
	public static void menu() {
		ArrayList<Producto> productos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion!=4) {
			System.out.println("****** Menu de Opciones *****");
			System.out.println("1- Crear Producto\n2- Mostrar Productos\n3- Modificar Producto\n4- Salir"
					+ "\nElija un opcion: ");
			try {
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado es inválido.");
			}
			
			if(opcion>1 && opcion<4 && productos.isEmpty())
				System.out.println("La lista de jugadores esta VACIA.\n");
			else
				opcion = seleccionarOpcion(opcion,sc,productos);
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		menu();
	}

}
