/**
 * 
 */
package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

/**
 * Clase de la vista que muestra todo lo relacionado con un suscriptor
 * 
 * @author iberlot <@> 
 *
 */
public class VSuscripciones implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta un nuevo suscriptor? ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar al suscriptor? ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar al suscriptor? ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos del suscriptor son:\n%s\n", dato);
	}

	/**
	 * Muestra por pantalla un mensaje con toda la informacion del suscriptor pasada por parametros
	 * 
	 * @param apellido
	 * @param nombre
	 * @param sexo
	 * @param fechaNac
	 * @param documento
	 */
	public void mostrarElemento(String apellido, String nombre, boolean sexo, Calendar fechaNac, long documento) {

		System.out.printf("Los datos del suscriptor son:\n");
		mostrarApellido(apellido);
		mostrarNombre(nombre);
		mostrarSexo(sexo);
		mostrarDocumento(documento);
		mostrarFechaNac(fechaNac);
	}

	/**
	 * Pide que se ingrese por teclado el apellido del suscriptor
	 * @return
	 */
	public String pedirApellido() {
		return funciones.Funciones.pedirString("Ingrese el apellido: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del apellido del suscriptor
	 * 
	 * @param dato
	 */
	public void mostrarApellido(String dato) {
		System.out.printf("El apellido es: %s\n", dato);
	}

	/**
	 * Pide que se ingrese por teclado el nombre
	 * @return
	 */
	public String pedirNombre() {
		return funciones.Funciones.pedirString("Ingrese el nombre: ");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del nombre del suscriptor
	 * 
	 * @param dato
	 */
	public void mostrarNombre(String dato) {
		System.out.printf("El nombre es: %s\n", dato);
	}

	/**
	 * Pregunta por el sexo del suscriptor
	 * @return
	 */
	public boolean pedirSexo() {
		return funciones.Funciones.pedirBooleano("Ingrese el sexo: ", "V", "M");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado del sexo
	 * 
	 * @param dato
	 */
	public void mostrarSexo(boolean dato) {
		if (dato == true) {

			System.out.printf("El sexo es: masculino\n");
		} else {

			System.out.printf("El sexo es: femenino\n");
		}
	}

	/**
	 * Pide que se ingrese por teclado la fecha de nacimiento
	 * @return
	 */
	public Calendar pedirFechaNac() {
		return funciones.Funciones.pedirFecha("Ingrese la fecha de nacimiento:");
	}

	/**
	 * Muestra por pantalla un mensaje con el parametro pasado de la fecha de nacimiento
	 * 
	 * @param fechaNac
	 */
	private void mostrarFechaNac(Calendar fechaNac) {
		System.out.printf("La fecha de nacimiento es: %s\n", Fechas.fechaAString(fechaNac, '/'));
	}

	/**
	 * Pide que se ingrese por teclado el numero de documento
	 * @return
	 */
	public long pedirDocumento() {
		return funciones.Funciones.pedirLong("Ingrese el numero de documento");
	}

	/**
	 * Muestra por pantalla el numero de documento pasado por parametro
	 * 
	 * @param documento
	 */
	private void mostrarDocumento(long documento) {
		System.out.printf("El numero de documento es: %l\n", documento);
	}
}
