package Controler;

import java.util.ArrayList;

import Model.*;

/**
 * @author IVANB
 *
 */
/**
 * @author IVANB
 *
 */
/**
 * @author IVANB
 *
 */
public class CPeliSeri {

	/**
	 * Listado con todos los generos del sistema
	 */
	private ArrayList<Generos> generos;

	/**
	 * Listado de publicaciones
	 */
	private ArrayList<Publicaciones> publicaciones;

	/**
	 * Listado de actores
	 */
	private ArrayList<Actores> actores;

	/**
	 * De los suscriptores
	 */
	private ArrayList<Suscriptores> suscriptores;

	/**
	 * Listado del calendario de pagos
	 */
	private ArrayList<Calendario> pagos;

	/**
	 * Retorna la serie con el mejor promedio de calificaciones
	 * 
	 * @return
	 */
	public Episodios buscarSerieMejorCalif() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Retorna la pelicula con el mejor promedio de calificaciones
	 * 
	 * @return
	 */
	public Peliculas buscarPeliMejorCalif() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Recorre los suscriptores y les recomienda la publicacion que les corresponda
	 */
	public void recomendar() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Retorna el listado de las publicaciones cuyo pago se realizo hace un año o mas
	 * @return
	 */
	public ArrayList<Publicaciones> publicacionesVencidas() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Agrega una publicacion a la lista
	 */
	public void agregarPublicacion() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Muestra el listado de las series ordenado por genero.
	 */
	public void seriesPorGenero() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * 
	 */
	public void mayoresSinClasificacion() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Muesra los datos de una pelicula al azar
	 */
	public void datosPeliculaAlAzar() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * 
	 */
	public void seriesParaMayores() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Cuenta todos aquellos autores que trabajan en publicaciones de un solo genero.
	 * 
	 * @return
	 */
	public int actoresTematicos() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * 
	 * @return
	 */
	public Publicaciones pelisPobres() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Muestra aquellas actrices que han trabajado en una pelicula en los ultimos 2 anios
	 */
	public void actricesActuales() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
