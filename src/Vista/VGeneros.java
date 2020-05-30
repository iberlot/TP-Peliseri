/**
 * 
 */
package Vista;

import java.io.IOException;

/**
 * @author IVANB
 *
 */
public class VGeneros implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta un nuevo genero? ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar el genero? ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar el genero? ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos del genero son:\n%s\n", dato);
	}

	public void mostrarElemento(int cantidad, int id, String descripcion) {

		System.out.printf("Los datos del genero son:\n");
		mostrarID(id);
		mostrarDescrip(descripcion);
		mostrarCantidad(cantidad);
	}

	public int pedirCantidad() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese la Cantidad:");
	}

	private void mostrarCantidad(int dato) {
		System.out.printf("La cantidad de titulos es de: %s\n", dato);	
	}

	public String pedirDescrip() {
		return funciones.Funciones.pedirString("Ingrese la descripcion:");
	}
	private void mostrarDescrip(String dato) {
		System.out.printf("El generos es: %s\n", dato);	
		
	}

	public int pedirID() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el ID:");
	}
	
	private void mostrarID(int dato) {
		System.out.printf("El Id es: %s\n", dato);	
		
	}


}
