/**
 * 
 */
package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

/**
 * @author IVANB
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

	public void mostrarElemento(String apellido, String nombre, boolean sexo, Calendar fechaNac, long documento) {

		System.out.printf("Los datos del suscriptor son:\n");
		mostrarApellido(apellido);
		mostrarNombre(nombre);
		mostrarSexo(sexo);
		mostrarDocumento(documento);
		mostrarFechaNac(fechaNac);
	}

	public String pedirApellido() {
		return funciones.Funciones.pedirString("Ingrese el apellido: ");
	}

	public void mostrarApellido(String dato) {
		System.out.printf("El apellido es: %s\n", dato);
	}

	public String pedirNombre() {
		return funciones.Funciones.pedirString("Ingrese el nombre: ");
	}

	public void mostrarNombre(String dato) {
		System.out.printf("El nombre es: %s\n", dato);
	}

	public boolean pedirSexo() {
		return funciones.Funciones.pedirBooleano("Ingrese el sexo: ", "V", "M");
	}

	public void mostrarSexo(boolean dato) {
		if (dato == true) {

			System.out.printf("El sexo es: masculino\n");
		} else {

			System.out.printf("El sexo es: femenino\n");
		}
	}

	public Calendar pedirFechaNac() {
		return funciones.Funciones.pedirFecha("Ingrese la fecha de nacimiento:");
	}

	private void mostrarFechaNac(Calendar fechaNac) {
		System.out.printf("La fecha de nacimiento es: %s\n", Fechas.fechaAString(fechaNac, '/'));
	}

	public long pedirDocumento() {
		return funciones.Funciones.pedirLong("Ingrese el numero de documento");
	}

	private void mostrarDocumento(long documento) {
		System.out.printf("El numero de documento es: %l\n", documento);
	}
}
