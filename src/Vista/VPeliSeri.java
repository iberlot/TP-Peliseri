package Vista;

import java.io.IOException;
import java.util.ArrayList;

import Model.Generos;
import funciones.Funciones;

/**
 * Clase de la vista que muestra todo lo relacionado con un la clase principal,
 * por ejemplo los menues
 * 
 * @author IVANB
 *
 */
public class VPeliSeri implements iVistas {

	@Override
	public boolean crear() throws IOException {
		throw new UnsupportedOperationException("Esta funcion esta deshabilitada para esta clase...");
	}

	@Override
	public boolean eliminar() throws IOException {
		throw new UnsupportedOperationException("Esta funcion esta deshabilitada para esta clase...");
	}

	@Override
	public boolean modificar() throws IOException {
		throw new UnsupportedOperationException("Esta funcion esta deshabilitada para esta clase...");
	}

	@Override
	public void mostrarElemento(String dato) throws IOException {
		throw new UnsupportedOperationException("Esta funcion esta deshabilitada para esta clase...");
	}

	public static int menuPrincipal() {
		System.out.println("MENU del programa");
		System.out.println("1 - Ver listado de actores");
		System.out.println("2 - Ver listado de generos");
		System.out.println("3 - Ver listado de publicaciones");
		System.out.println("4 - Ver listado de suscriptores");
		System.out.println("5 - ABM de suscriptores");
		System.out.println("6 - ABM de generos");
		System.out.println("7 - Cargar nuevar altas");
		System.out.println("66 - SALIR");

		return Funciones.pedirEnteroPositivo("");

	}

	public static int menuABMGeneros() {
		System.out.println("MENU del programa");
		System.out.println("1 - Alta de generos");
		System.out.println("2 - Baja de generos");
		System.out.println("3 - Modificar genero");
		System.out.println("4 - Listar generos");
		System.out.println("66 - SALIR");

		return Funciones.pedirEnteroPositivo("");
	}

	/**
	 * FIXME sto esta mal tengo que arreglarlo, debe ejecutar el for en el
	 * controlador, mostrar los datos y luego pedir desde la vista el id
	 * 
	 * @param generos
	 * @return
	 */
	public static int pedirIdGenero(ArrayList<Generos> generos) {
		for (int i = 0; i < generos.size(); i++) {

			System.out.println(i + " - " + generos.get(i).getDescripcion());

		}
		return Funciones.pedirEnteroPositivo("Ingrese el nro identificador deseado", -1, generos.size());
	}

	public static int menuABMSuscriptores() {
		System.out.println("MENU del programa");
		System.out.println("1 - Alta de un suscriptor");
		System.out.println("2 - Baja de un suscriptor");
		System.out.println("3 - Modificar suscriptor");
		System.out.println("4 - Listar suscriptores");
		System.out.println("66 - SALIR");

		return Funciones.pedirEnteroPositivo("");
	}
}
