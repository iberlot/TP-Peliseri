package Vista;

import java.io.IOException;
import java.util.Calendar;

public class VPeliculas extends VPublicaciones {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta una nueva pelicula? S/N ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar la pelicula? S/N ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar la pelicula? S/N ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la pelicula son:\n%s\n", dato);
	}

	public void mostrarElemento(int anio, int duracion) {

		System.out.printf("Los datos de la pelicula son:\n");
		mostrarAnio(anio);
		mostrarDuracion(duracion);

		// No se si aca tengo que retornar los datos de Publicaciones o llamar a una
		// funcion de VPublicaciones o Extender esto
	}

	public void mostrarElemento(int codigo, String nombre, String empresa, Calendar fPubli, String genero,
			String sinopsis, int anio, int duracion) {

		super.mostrarElemento(codigo, nombre, empresa, fPubli, genero, sinopsis);
		mostrarAnio(anio);
		mostrarDuracion(duracion);
	}

	public int pedirAnio() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el anio:");
	}

	public void mostrarAnio(int anio) {
		System.out.printf("El apellido es: %s\n", anio);
	}

	public int pedirDuracion() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese la duracon en minutos:");
	}

	public void mostrarDuracion(int duracion) {
		System.out.printf("La duracion es de: %f\n", duracion);
	}

}
