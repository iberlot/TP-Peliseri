package Controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Actores;
import Model.Calendario;
import Model.Episodios;
import Model.Generos;
import Model.Peliculas;
import Model.Publicaciones;
import Model.Suscriptores;
import Model.DAO.daoActores;
import Model.DAO.daoGeneros;
import Model.DAO.daoPublicaciones;
import Model.DAO.daoSuscriptores;
import Vista.VActores;
import Vista.VEpisodios;
import Vista.VGeneros;
import Vista.VPeliSeri;
import Vista.VPeliculas;
import Vista.VPublicaciones;
import Vista.VSuscriptores;

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

//XXX Esto esta solo para recordarme que tengo que crearlos al usarlos
//	private CActores controlerActores = new CActores();
//	private CCalendario controlerCalendario = new CCalendario();
//	private CCalificaciones controlerCalificaciones = new CCalificaciones();
//	private CEpisodios controlerEpisodios = new CEpisodios();
//	private CGeneros controlerGeneros = new CGeneros();
//	private CPeliculas controlerPeliculas = new CPeliculas();
//	private CPublicaciones controlerPublicaciones = new CPublicaciones();
//	private CSuscripciones controlerSuscripciones = new CSuscripciones();
//	

	// FIXME esto no se pero creeria que tiene que estar en cada controler
	private daoActores daoActor = new daoActores();
//	private daoCalendario daoCalendario = new daoCalendario();
//	private daoCalificaciones daoCalificaciones = new daoCalificaciones();
	private daoGeneros daoGenero = new daoGeneros();
	private daoPublicaciones daoPublicacion = new daoPublicaciones();
	private daoSuscriptores daoSuscripcion = new daoSuscriptores();

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
		VPublicaciones vistaPublicacion = new VPublicaciones();

		listarListas(3);

	}

	/**
	 * Retorna el listado de las publicaciones cuyo pago se realizo hace un año o
	 * mas
	 * 
	 * @return
	 */
	public ArrayList<Publicaciones> publicacionesVencidas() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Agrega una publicacion a la lista
	 * 
	 * @throws Exception
	 */
	public void agregarPublicacion() throws Exception {
		ArrayList<Publicaciones> pubic = daoPublicacion.conv_a_objeto_dire();

		for (Publicaciones publicacion : pubic) {
			if (publicaciones.contains(publicacion) == false) {
				publicaciones.add(publicacion);

			}
		}
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
	 * Cuenta todos aquellos autores que trabajan en publicaciones de un solo
	 * genero.
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
	 * Muestra aquellas actrices que han trabajado en una pelicula en los ultimos 2
	 * anios
	 */
	public void actricesActuales() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void inicializar_archivos() throws Exception {
		generos = daoGenero.recuperar_datos_archivo();
		actores = daoActor.recuperar_datos_archivo();
		suscriptores = daoSuscripcion.recuperar_datos_archivo();
		Model.DAO.daoCalificaciones.setSuscriptores(suscriptores);
		Model.DAO.daoPublicaciones.setGeneros(generos);
		publicaciones = daoPublicacion.recuperar_datos_archivo();

	}

	public void inicio() throws Exception {

		switch (VPeliSeri.menuPrincipal()) {
		case 1:
			// Autores
			listarListas(1);
			break;
		case 2:
			// Generos
			listarListas(2);
			break;
		case 3:
			// Publicaciones
			listarListas(3);
			break;
		case 4:
			// Suscriptores
			listarListas(4);
			break;
		case 5:
			menu_ABM_suscriptores();
			break;
		case 6:
			menu_ABM_generos();
			break;
		case 7:
			agregarPublicacion();
			break;
		case 8:
			recomendar();
			break;
		case 66:
			System.exit(0);
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		inicio();

	}

	private void menu_ABM_suscriptores() throws Exception {
		switch (VPeliSeri.menuABMSuscriptores()) {
		case 1:
			altaSuscriptor();
			break;
		case 2:
			bajaSuscriptor();
			break;
		case 3:
			updateSuscriptor();
			break;
		case 4:
			listarListas(4);
			break;
		case 66:
			inicio();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		menu_ABM_suscriptores();
	}

	private void altaSuscriptor() throws IOException {
		VSuscriptores vistaSuscriptor = new VSuscriptores();

		if (vistaSuscriptor.crear()) {
			Suscriptores modeloSuscriptor = new Suscriptores();
			CSuscriptores controlerSuscriptor = new CSuscriptores(modeloSuscriptor, new VSuscriptores());

			controlerSuscriptor.setDocumento();
			// FIXME aca debe comprobar que el id no exista ya
			controlerSuscriptor.setApellido();
			controlerSuscriptor.setNombre();
			controlerSuscriptor.setFechaNac();
			controlerSuscriptor.setSexo();
			controlerSuscriptor.grabar();

			controlerSuscriptor.mostrarDatos();

			suscriptores.add(modeloSuscriptor);
		}
	}

	private void bajaSuscriptor() throws IOException {
		VSuscriptores vistaSuscriptor = new VSuscriptores();
		int id = pedirIdSuscriptor();

		if (vistaSuscriptor.eliminar()) {
			suscriptores.remove(id);
			daoSuscripcion.limpiarArchivo();

			for (Suscriptores suscriptor : suscriptores) {

				CSuscriptores controlerSuscriptores = new CSuscriptores(suscriptor, vistaSuscriptor);

				controlerSuscriptores.grabar();
			}
		}
	}

	private void updateSuscriptor() throws IOException {

		int id = pedirIdSuscriptor();

		VSuscriptores vistaSuscriptor = new VSuscriptores();
		if (vistaSuscriptor.modificar()) {

			CSuscriptores controlerS = new CSuscriptores(suscriptores.get(id), vistaSuscriptor);
			controlerS.modificar();
			controlerS.limpiarArchivo();
			controlerS.mostrarDatos();

			for (Suscriptores suscriptor : suscriptores) {

				CSuscriptores controlerSuscriptor = new CSuscriptores(suscriptor, vistaSuscriptor);

				controlerSuscriptor.grabar();
			}
		}
	}

	private int pedirIdSuscriptor() {
		for (int i = 0; i < suscriptores.size(); i++) {
			VSuscriptores.mostrarEsta(i, suscriptores.get(i).getApellido());
		}
		return VSuscriptores.pedirIdSuscriptor(suscriptores.size());
	}

	private void menu_ABM_generos() throws Exception {
		switch (VPeliSeri.menuABMGeneros()) {
		case 1:
			altaGenero();
			break;
		case 2:
			bajaGenero();
			break;
		case 3:
			updateGenero();
			break;
		case 4:
			listarListas(2);
			break;
		case 66:
			inicio();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		menu_ABM_generos();
	}

	private void updateGenero() throws Exception {
		VGeneros vistaGenero = new VGeneros();
		int id = VPeliSeri.pedirIdGenero(generos);

		if (vistaGenero.modificar()) {

			CGeneros controlerG = new CGeneros(generos.get(id), vistaGenero);
			controlerG.modificar();
			controlerG.limpiarArchivo();
			controlerG.mostrarDatos();

			for (Generos genero : generos) {

				CGeneros controlerGeneros = new CGeneros(genero, vistaGenero);

				controlerGeneros.grabar();
			}
		}
	}

	private void altaGenero() throws IOException {
		VGeneros vistaGenero = new VGeneros();

		if (vistaGenero.crear()) {
			Generos modeloGenero = new Generos();
			CGeneros controlerGeneros = new CGeneros(modeloGenero, vistaGenero);

			controlerGeneros.setId();
			// FIXME aca debe comprobar que el id no exista ya
			controlerGeneros.setDescripciones();
			// FIXME aca debe comprobar que la descripcion no exista ya
			controlerGeneros.grabar();

			controlerGeneros.mostrarDatos();

			generos.add(modeloGenero);
		}
	}

	private void bajaGenero() throws IOException {
		VGeneros vistaGenero = new VGeneros();
		int id = VPeliSeri.pedirIdGenero(generos);

		if (vistaGenero.eliminar()) {
			generos.remove(id);
			daoGenero.limpiarArchivo();

			for (Generos genero : generos) {

				CGeneros controlerGeneros = new CGeneros(genero, vistaGenero);

				controlerGeneros.grabar();
			}
		}
	}

	private void listarListas(int opcion) {
		switch (VPeliSeri.menuPrincipal()) {
		case 1:
			for (Actores item : actores) {
				CActores control = new CActores(item, new VActores());
				control.mostrarDatos();
			}
			break;
		case 2:
			for (Generos item : generos) {
				CGeneros control = new CGeneros(item, new VGeneros());
				control.mostrarDatos();
			}
			break;
		case 3:
			for (Publicaciones item : publicaciones) {
				if (item instanceof Peliculas) {
					CPeliculas control = new CPeliculas((Peliculas) item, new VPeliculas());
					control.mostrarDatos();
				} else {
					CEpisodios control = new CEpisodios((Episodios) item, new VEpisodios());
					control.mostrarDatos();
				}
			}
			break;
		case 4:
			for (Suscriptores item : suscriptores) {
				CSuscriptores control = new CSuscriptores(item, new VSuscriptores());
				control.mostrarDatos();
			}
			break;
		case 5:
			break;
		case 66:
			System.exit(0);
			break;

		}
	}
}
