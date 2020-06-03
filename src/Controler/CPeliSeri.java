package Controler;

import java.util.ArrayList;
import Model.*;
import Model.DAO.*;
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

	private CActores controlerActores = new CActores();
	private CCalendario controlerCalendario = new CCalendario();
	private CCalificaciones controlerCalificaciones = new CCalificaciones();
	private CEpisodios controlerEpisodios = new CEpisodios();
	private CGeneros controlerGeneros = new CGeneros();
	private CPeliculas controlerPeliculas = new CPeliculas();
	private CPublicaciones controlerPublicaciones = new CPublicaciones();
	private CSuscripciones controlerSuscripciones = new CSuscripciones();
	
	
	
	// FIXME esto no se pero creeria que tiene que estar en cada controler
	private daoActores daoActores = new daoActores();
	private daoCalendario daoCalendario = new daoCalendario();
	private daoCalificaciones daoCalificaciones = new daoCalificaciones();
	private daoEpisodios daoEpisodios = new daoEpisodios();
	private daoGeneros daoGeneros = new daoGeneros();
	private daoPeliculas daoPeliculas = new daoPeliculas();
	private daoPublicaciones daoPublicaciones = new daoPublicaciones();
	private daoSuscriptores daoSuscripciones = new daoSuscriptores();
	
	
	
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
	

	public void inicializar_archivos() throws Exception {
		generos = daoGeneros.recuperar_datos_archivo();
		actores = daoActores.recuperar_datos_archivo();
		suscriptores = daoSuscripciones.recuperar_datos_archivo();
		daoCalificaciones.setSuscriptores(suscriptores);
		daoPublicaciones.setGeneros(generos);
		publicaciones = daoPublicaciones.recuperar_datos_archivo();

	}
}
