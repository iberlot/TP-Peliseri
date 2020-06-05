/**
 * 
 */
package Vista;

import java.io.IOException;
import java.util.Calendar;

/**
 * @author IVANB
 *
 */
public class VEpisodios extends VPublicaciones {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta un nuevo episodio? S/N ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar el episodio? S/N ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar el episodio? S/N ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos del episodio son:\n%s\n", dato);
	}

	public void mostrarElemento(int anio, float duracion, int nroEpisodio, String serie, int temporada) {

		System.out.printf("Los datos de la pelicula son:\n");
		mostrarAnio(anio);
		mostrarDuracion(duracion);
		mostrarNroEpisodio(nroEpisodio);
		mostrarSerie(serie);
		mostrarTemporada(temporada);
// No se si aca tengo que retornar los datos de Publicaciones o llamar a una
		// funcion de VPublicaciones o Extender esto
		System.out.println("\n");
	}

	public void mostrarElemento(int codigo, String nombre, String empresa, Calendar fPubli, String genero,
			String sinopsis, int anio, float duracion, int nroEpisodio, String serie, int temporada) {

		super.mostrarElemento(codigo, nombre, empresa, fPubli, genero, sinopsis);
		mostrarAnio(anio);
		mostrarDuracion(duracion);
		mostrarNroEpisodio(nroEpisodio);
		mostrarSerie(serie);
		mostrarTemporada(temporada);

		System.out.println("\n");
	}

	public int pedirAnio() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el anio:");
	}

	public void mostrarAnio(int dato) {
		System.out.printf("El apellido es: %s\n", dato);
	}

	public int pedirDuracion() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese la duracion en minutos:");
	}

	public void mostrarDuracion(float dato) {
		System.out.printf("La duracion es de: %f\n", dato);
	}

	public int pedirNroEpisodio() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el Nro de episodio:");
	}

	public void mostrarNroEpisodio(int dato) {
		System.out.printf("Episodio nro: %s\n", dato);
	}

	public String pedirSerie() {
		return funciones.Funciones.pedirString("Ingrese el anio:");
	}

	public void mostrarSerie(String dato) {
		System.out.printf("La serie es : %s\n", dato);
	}

	public int pedirTemporada() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el anio:");
	}

	public void mostrarTemporada(int dato) {
		System.out.println("La duracion es de: " + dato);
	}

}
