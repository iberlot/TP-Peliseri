/**
 * 
 */
package Vista;

import java.io.IOException;

/**
 * @author IVANB
 *
 */
public class VActores implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta un nuevo actor? S/N ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar al actor? S/N ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar al actor? S/N ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la persona son:\n%s\n", dato);
	}

	public void mostrarElemento(String apellido, String nombre, boolean sexo) {

		System.out.printf("Los datos de la persona son:\n");
		mostrarApellido(apellido);
		mostrarNombre(nombre);
		mostrarSexo(sexo);
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

}
