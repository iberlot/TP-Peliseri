package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

/**
 * Clase de la vista que muestra todo lo relacionado con una publicacion
 * 
 * @author iberlot <@>
 *
 */
public class VPublicaciones implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta una nueva publicacion? S/N ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar la publicacion? S/N ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar la publicacion? S/N ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la publicacion son:\n%s\n", dato);
	}

	/**
	 * Muestra por pantalla un mensaje con los datos pasados por parametro de la
	 * publicacion
	 * 
	 * @param codigo
	 * @param nombre
	 * @param empresa
	 * @param fPubli
	 * @param genero
	 * @param sinopsis
	 */
	public void mostrarElemento(int codigo, String nombre, String empresa, Calendar fPubli, String genero,
			String sinopsis) {

		System.out.printf("Los datos de la publicacion son:\n");
		mostrarCodigo(codigo);
		mostrarNombre(nombre);
		mostrarEmpresa(empresa);
		mostrarFechaPubli(fPubli);
		mostrarGenero(genero);
		mostrarSinopsis(sinopsis);

	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado de la sinopsis de la
	 * publicacion
	 * 
	 * @param sinopsis
	 */
	public void mostrarSinopsis(String sinopsis) {
		System.out.printf("la sinopsis es: %s\n", sinopsis);

	}

	/**
	 * Pide que se ingrese por teclado la sinopsis de la publicacion
	 * 
	 * @return
	 */
	public String pedirSinopsis() {
		return funciones.Funciones.pedirString("Ingrese la sinopsis: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del genero de la
	 * publicacion
	 * 
	 * XXX esto creo que no va aca, estoy casi seguro de que deberia llamarse a una
	 * funcion de la clase VGenero - iberlot <@>
	 * 
	 * @param genero
	 */
	public void mostrarGenero(String genero) {
		System.out.printf("El generos es es: %s\n", genero);

	}

	/**
	 * Pide que se ingrese por teclado el genero de la publicacion
	 * 
	 * XXX esto creo que no va aca, estoy casi seguro de que deberia llamarse a una
	 * funcion de la clase VGenero - iberlot <@>
	 * 
	 * @return
	 */
	public String pedirGenero() {
		return funciones.Funciones.pedirString("Ingrese el genero: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado de la empresa
	 * 
	 * @param empresa
	 */
	public void mostrarEmpresa(String empresa) {
		System.out.printf("la empresa es: %s\n", empresa);

	}

	/**
	 * Pide que se ingrese por teclado la empresa
	 * 
	 * @return
	 */
	public String pedirEmpresa() {
		return funciones.Funciones.pedirString("Ingrese la empresa: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado de la fecha de la
	 * publicacion
	 * 
	 * @param fPubli
	 */
	public void mostrarFechaPubli(Calendar fPubli) {
		System.out.printf("La fecha de publicaion es: %s\n", Fechas.fechaAString(fPubli, '/'));

	}

	/**
	 * Pide que se ingrese por teclado la fecha de la publicacion
	 * 
	 * @return
	 */
	public Calendar pedirFechaPubli() {
		return funciones.Funciones.pedirFecha("Ingrese la fecha de publicacion:");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del nombre de la
	 * publicacion
	 * 
	 * @param nombre
	 */
	public void mostrarNombre(String nombre) {
		System.out.printf("El nombre de la publicacion es: %s\n", nombre);

	}

	/**
	 * Pide que se ingrese por teclado el nombre de la publicacion
	 * 
	 * @return
	 */
	public String pedirNombre() {
		return funciones.Funciones.pedirString("Ingrese el nombre de la publicacion: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del codigo de la
	 * publicacion
	 * 
	 * @param codigo
	 */
	public void mostrarCodigo(int codigo) {
		System.out.printf("El codigo es: %s\n", codigo);

	}

	/**
	 * Pide que se ingrese por teclado el codigo de la publicacion
	 * 
	 * @return
	 */
	public int pedirCodigo() {
		return funciones.Funciones.pedirEnteroPositivo("Inferese el codigo de lapublicacion.: ");
	}

}
