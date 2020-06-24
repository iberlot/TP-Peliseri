package Controler;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Model.Actores;
import Model.Calificaciones;
import Model.Episodios;
import Model.Generos;
import Model.Peliculas;
import Model.Publicaciones;
import Model.Suscriptores;
import Model.DAO.daoActores;
import Model.DAO.daoCalendario;
import Model.DAO.daoCalificaciones;
import Model.DAO.daoGeneros;
import Model.DAO.daoPublicaciones;
import Model.DAO.daoSuscriptores;
import Vista.VActores;
import Vista.VCalificaciones;
import Vista.VEpisodios;
import Vista.VGeneros;
import Vista.VPeliSeri;
import Vista.VPeliculas;
import Vista.VPublicaciones;
import Vista.VSuscriptores;
import funciones.Fechas;

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
	 * Fecha actual para usar en las comparaciones
	 */
	private Calendar fActual = Calendar.getInstance();

	float valorPelicla = 0;
	float valorSerie = 0;

	float montoTope = 0;

	// FIXME esto no se pero creeria que tiene que estar en cada controler
	private daoActores daoActor = new daoActores();
	private daoGeneros daoGenero = new daoGeneros();
	private daoPublicaciones daoPublicacion = new daoPublicaciones();
	private daoSuscriptores daoSuscripcion = new daoSuscriptores();

	public void recomendarSerie() throws ParseException, IOException {
		CEpisodios conPe = new CEpisodios(buscarSerieMejorCalif(), new VEpisodios());

		Iterator<Suscriptores> it = suscriptores.iterator();

		while (it.hasNext()) {
			Suscriptores susc = it.next();
			if (susc.getEdad() < 35) {
				conPe.recomendarSerieMenor(susc.getDocumento());
			}

		}
	}

	public void recomendarPelicula() throws ParseException, IOException {
		CPeliculas conPe = new CPeliculas(buscarPeliMejorCalif(), new VPeliculas());

		Iterator<Suscriptores> it = suscriptores.iterator();

		while (it.hasNext()) {
			Suscriptores susc = it.next();
			if (susc.getEdad() < 35) {
				conPe.recomendarPeliMayor(susc.getDocumento());
			}

		}
	}

	/**
	 * Retorna la serie con el mejor promedio de calificaciones
	 *
	 * @return
	 * @throws ParseException
	 */
	public Episodios buscarSerieMejorCalif() throws ParseException {
		// XXX En realidad habria que usar algo como esto pero no se como se hace y ya
		// no me da la cabeza =)
		// Collections.sort(publicaciones);

		// @Override
		// public int compareTo(Publicaciones o) {
		// return new Float(promedioCalificaciones()).compareTo(new
		// Float(o.promedioCalificaciones()));
		// }
		// }
		Iterator<Publicaciones> it = publicaciones.iterator();
		Episodios publiMostrar = new Episodios();
		while (it.hasNext()) {
			Publicaciones pub = it.next();
			if (pub instanceof Episodios) {
				if (((Episodios) pub).promedioCalificacionesMenores() > publiMostrar.promedioCalificacionesMenores()) {
					publiMostrar = (Episodios) pub;
				}
			}
		}

		return publiMostrar;
	}

	/**
	 * Retorna la pelicula con el mejor promedio de calificaciones
	 *
	 * @return
	 * @throws ParseException
	 */
	public Peliculas buscarPeliMejorCalif() throws ParseException {
		// XXX En realidad habria que usar algo como esto pero no se como se hace y ya
		// no me da la cabeza =)
		// Collections.sort(publicaciones);
		// Collections.sort((List<Peliculas>) publicaciones);

		Iterator<Publicaciones> it = publicaciones.iterator();
		Peliculas publiMostrar = new Peliculas();
		while (it.hasNext()) {
			Peliculas pub = (Peliculas) it.next();
			if (pub instanceof Peliculas) {
				if (pub.promedioCalificacionesMes() > publiMostrar.promedioCalificacionesMes()) {
					publiMostrar = pub;
				}
			}
		}

		return publiMostrar;
	}

	/**
	 * Recorre los suscriptores y les recomienda la publicacion que les corresponda
	 *
	 * @throws IOException
	 */
	public void recomendar() throws IOException {
		int idPublic = pedirIdPublicacion();

		int idSusc = pedirIdSuscriptor();

//		dato.getActores().forEach(action);
		CPublicaciones conPubli = new CPublicaciones(publicaciones.get(idPublic), new VPublicaciones());
		if (conPubli.existeSuscriptor(suscriptores.get(idSusc)) == false) {
			conPubli.nuevoComentario(suscriptores.get(idSusc));
		}

	}

	/**
	 * Retorna el listado de las publicaciones cuyo pago se realizo hace un año o
	 * mas
	 *
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public void publicacionesVencidas() throws ParseException, IOException {
		int cantidad = 0;
		float totalPago = 0;

		// FIXME la siguiente no es la opcion mas optima pero si la mas rapida de
		// desarrollar en estos momentos
		ArrayList<Publicaciones> pubPagar = new ArrayList<Publicaciones>();

		Iterator<Publicaciones> it = publicaciones.iterator();

		while (it.hasNext()) {
			Publicaciones pub = it.next();

			Calendar fechaPago = Calendar.getInstance();
			fechaPago.set(fActual.get(Calendar.YEAR), fActual.get(Calendar.MONTH) + 1, fActual.get(Calendar.DATE));

			fechaPago.add(Calendar.DAY_OF_MONTH, (7 * cantidad));

			if (Fechas.diferenciaDiasTotal(pub.getFechaPubli(), fActual) < 30) {

				cantidad++;

				if (pub instanceof Peliculas) {
					pub.agregarFPago(cantidad, valorPelicla, fechaPago);
					totalPago += valorPelicla;
				} else {
					pub.agregarFPago(cantidad, valorSerie, fechaPago);
					totalPago += valorSerie;
				}
				pubPagar.add(pub);
			} else if ((Fechas.diferenciaDiasTotal(pub.getFechaPubli(), fActual) < 395)
					&& (Fechas.diferenciaDiasTotal(pub.getFechaPubli(), fActual) > 365)) {
				cantidad++;

				if (pub instanceof Peliculas) {
					pub.agregarFPago(cantidad, valorPelicla * 60 / 100, fechaPago);
					totalPago += valorPelicla * 60 / 100;
				} else {
					float valor = 0;
					valor = (cantidadEpisodiosTemporadaSerie((Episodios) pub) > 12) ? valorSerie * 30 / 100
							: valorSerie * 45 / 100;
					pub.agregarFPago(cantidad, valor, fechaPago);
					totalPago += valor;
				}

				pubPagar.add(pub);
			}
		}

		daoCalendario dao = new daoCalendario();
		dao.cargarTodos(pubPagar, totalPago);
	}

	private int cantidadEpisodiosTemporadaSerie(Episodios episodio) {

		Iterator<Publicaciones> it = publicaciones.iterator();
		int cantidadEpisodios = 0;
		int maximaTemporada = 0;
		while (it.hasNext()) {
			Publicaciones pub = it.next();
			if (((Episodios) pub).getSerie().equalsIgnoreCase(episodio.getSerie())) {
				maximaTemporada = (((Episodios) pub).getTemporada() > maximaTemporada)
						? ((Episodios) pub).getTemporada()
						: maximaTemporada;

				if (((Episodios) pub).getTemporada() == episodio.getTemporada()) {
					cantidadEpisodios = (((Episodios) pub).getNroEpisodio() > cantidadEpisodios)
							? ((Episodios) pub).getNroEpisodio()
							: cantidadEpisodios;
				}
			}
		}
		return cantidadEpisodios;
	}

	/**
	 * Agrega una publicacion a la lista
	 *
	 * @throws Exception
	 */
	public void agregarPublicacion() throws Exception {

		ArrayList<Publicaciones> pubic = daoPublicacion.conv_a_objeto_dire();

		daoPublicacion.limpiarArchivo();

		for (Publicaciones publicacion : pubic) {
//			XXX deberia saber por que no funciona pero no tengo idea
//			if (publicaciones.contains(publicacion) == false) {
//				publicaciones.add(publicacion);
//			}
//			XXX Esto que estoy haciendo me parece una cochinada pero funciono asi que por ahora lo dejamos

			boolean agregar = false;
			if (publicaciones.size() > 0) {
				for (int i = 0; i < publicaciones.size(); i++) {
					if (!publicacion.getNombre().equalsIgnoreCase(publicaciones.get(i).getNombre())) {
						agregar = true;
					} else {
						if (publicacion.getCodigo() != publicaciones.get(i).getCodigo()) {
							agregar = true;
						} else {
							// XXX aca tiene que comprobar que los datos de la publicacion en el json sean
							// iguales pero diferentes y cambiar los que correspondan
							comprobarYUpdetear(publicacion);
						}
					}
				}
			} else {
				agregar = true;
			}
			if (agregar == true) {
				publicaciones.add(publicacion);
			}
		}

		for (Publicaciones publica : publicaciones) {

			CPublicaciones controlerPublicaciones = new CPublicaciones(publica, new VPublicaciones());

			controlerPublicaciones.grabar();
		}
	}

	/**
	 * @param publicacion
	 *
	 */
	private void comprobarYUpdetear(Publicaciones publicacion) {
		for (int i = 0; i < publicaciones.size(); i++) {
			if (!publicacion.getNombre().equalsIgnoreCase(publicaciones.get(i).getNombre())) {
				if (publicacion.getCodigo() == publicaciones.get(i).getCodigo()) {
					if (publicaciones.get(i).comprobarIguales(publicacion) == false) {
						publicaciones.set(i, publicacion);
					}
				}
			}
		}
	}

	/**
	 * Muestra el listado de las series ordenado por genero.
	 */
	public void seriesPorGenero() {

		VPeliSeri vista = new VPeliSeri();

		for (Generos genero : generos) {
			ArrayList<Episodios> epi = new ArrayList<Episodios>();

			Iterator<Publicaciones> it = publicaciones.iterator();

			while (it.hasNext()) {
				Publicaciones pub = it.next();

				if (pub instanceof Episodios) {

					if (((Episodios) pub).getGenero().equals(genero)) {

						boolean agregar = false;
						if (epi.size() > 0) {
							for (int i = 0; i < epi.size(); i++) {
								if (epi.get(i).getSerie().equalsIgnoreCase(((Episodios) pub).getSerie())) {
									agregar = false;

									if (epi.get(i).getTemporada() < ((Episodios) pub).getTemporada()) {
										epi.remove(i);
										epi.add((Episodios) pub);

									} else if (epi.get(i).getTemporada() == ((Episodios) pub).getTemporada()) {
										if (epi.get(i).getNroEpisodio() < ((Episodios) pub).getNroEpisodio()) {
											epi.remove(i);
											epi.add((Episodios) pub);

										}
									}
								} else {
									agregar = true;
								}
							}

							if (agregar == true) {
								epi.add((Episodios) pub);
							}
						} else {
							epi.add((Episodios) pub);
						}

					}
				}
			}

			vista.mostrarGenero(genero.getId(), genero.getDescripcion(), epi.size());

			Collections.sort(epi);

			for (Episodios episodios : epi) {
				ArrayList<Actores> acto = new ArrayList<Actores>();
				int cantidad = 0;
				int cantidadActores = 0;
				for (Publicaciones put : publicaciones) {
					if (put instanceof Episodios) {
						if (((Episodios) put).getSerie().equalsIgnoreCase(episodios.getSerie())) {
							cantidad++;

							for (Actores a : put.getActores()) {
								if (acto.size() > 0) {
									if (!acto.contains(a)) {
										cantidadActores++;
										acto.add(a);
									}
								} else {
									cantidadActores++;
									acto.add(a);
								}
							}
						}
					}
				}
				vista.mostrarSerie(episodios.getNombre(), episodios.getTemporada(), cantidadActores);
			}

		}
	}

	/**
	 * @throws ParseException
	 *
	 */
	public void mayoresSinClasificacion() throws ParseException {

		Iterator<Suscriptores> it = suscriptores.iterator();

		while (it.hasNext()) {
			Suscriptores susc = it.next();
			if (susc.getEdad() > 60) {
				boolean mostrar = true;
				for (Publicaciones publicacion : publicaciones) {
					Iterator<Calificaciones> et = publicacion.getCalificaciones().iterator();

					while (et.hasNext()) {
						Calificaciones califa = et.next();
						if (califa.getSuscriptor().equals(susc)) {
							mostrar = false;
						}
					}
				}

				if (mostrar == true) {
					CSuscriptores control = new CSuscriptores(susc, new VSuscriptores());
					control.mostrarApellido();
					control.mostrarNombre();
				}
			}
		}
	}

	/**
	 * Muesra los datos de una pelicula al azar
	 */
	public void datosPeliculaAlAzar() {
		try {
			Random r = new Random();
			int id = r.nextInt(publicaciones.size() + 1);

			if (publicaciones.get(id) instanceof Peliculas) {

				VPeliculas vpeli = new VPeliculas();
				vpeli.mostrarNombre(publicaciones.get(id).getNombre());

				Collections.sort(publicaciones.get(id).getActores());

				for (Actores act : publicaciones.get(id).getActores()) {
					VActores vaca = new VActores();
					vaca.mostrarVaca(act.getApellido(), act.getNombre());
				}

				vpeli.mostrarDuracion(((Peliculas) publicaciones.get(id)).getDuracion());
				vpeli.mostrarFechaPubli(((Peliculas) publicaciones.get(id)).getFechaPubli());

				for (Calificaciones califa : ((Peliculas) publicaciones.get(id)).getCalificaciones()) {
					VCalificaciones vCalifa = new VCalificaciones();
					vCalifa.mostrarElemento(califa.getFecha(), califa.getCalificacion(),
							califa.getSuscriptor().getApellido() + ", " + califa.getSuscriptor().getNombre(),
							califa.getDescripcion());
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			datosPeliculaAlAzar();
		}
	}

	/**
	 * @throws ParseException
	 *
	 */
	public void seriesParaMayores() throws ParseException {

		Iterator<Publicaciones> it = publicaciones.iterator();

		while (it.hasNext()) {
			Publicaciones epic = it.next();
			if (epic instanceof Episodios) {

				boolean mostrar = true;

				Iterator<Calificaciones> ct = epic.getCalificaciones().iterator();

				while (it.hasNext()) {
					Calificaciones calif = ct.next();
					if (calif.getSuscriptor().isSexo() == true && calif.getSuscriptor().getEdad() > 17
							&& calif.getSuscriptor().getEdad() < 45) {
						mostrar = false;
					}
				}
				if (mostrar == true) {
					CEpisodios contro = new CEpisodios((Episodios) epic, new VEpisodios());
					contro.mostrarCodigo();
					contro.mostrarSerie();
					contro.mostrarTemporada();
					contro.mostrarNroEpisodio();
					contro.mostrarnombre();
				}
			}
		}

	}

	/**
	 * Cuenta todos aquellos autores que trabajan en publicaciones de un solo
	 * genero.
	 *
	 * @return
	 */
	public void actoresTematicos() {
		VPeliSeri vista = new VPeliSeri();
		int total = 0;
		for (Actores actor : actores) {
			ArrayList<Generos> gene = new ArrayList<Generos>();
			for (Publicaciones publicacion : publicaciones) {
				if (publicacion.getActores().contains(actor)) {
					if (!gene.contains(publicacion.getGenero())) {
						gene.add(publicacion.getGenero());
					}
				}
			}
			if (gene.size() > 0) {
				total++;
			}
		}

		vista.actoresTematicos(total);
	}

	/**
	 *
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public void pelisPobres() throws ParseException, IOException {

		Iterator<Publicaciones> it = publicaciones.iterator();

		while (it.hasNext()) {
			Publicaciones pub = it.next();
			boolean mostrar = false;

			if ((Fechas.diferenciaDiasTotal(pub.getFechaPubli(), fActual) < 395)
					&& (Fechas.diferenciaDiasTotal(pub.getFechaPubli(), fActual) > 365)) {

				if (pub instanceof Peliculas) {

					if ((valorPelicla * 60 / 100) > (montoTope + (montoTope * 10 / 100))) {
						mostrar = true;
					}

				} else {
					float valor = 0;
					valor = (cantidadEpisodiosTemporadaSerie((Episodios) pub) > 12) ? valorSerie * 30 / 100
							: valorSerie * 45 / 100;

					if (valor > (montoTope + (montoTope * 10 / 100))) {
						mostrar = true;
					}
				}
				if (mostrar == true) {
					if (pub.promedioCalificaciones() < 3) {
						VPublicaciones vite = new VPublicaciones();

						vite.mostrarNombre(pub.getNombre());
						vite.mostrarGenero(pub.getGenero().getDescripcion());

					}
				}
			}
		}

	}

	/**
	 * Muestra aquellas actrices que han trabajado en una pelicula en los ultimos 2
	 * anios
	 */
	public void actricesActuales() {
		Iterator<Actores> itAc = actores.iterator();
		VActores vaca = new VActores();

		while (itAc.hasNext()) {

			boolean mostrar = false;
			Actores act = itAc.next();
			if (act.isSexo() == false) {
				Iterator<Publicaciones> it = publicaciones.iterator();

				while (it.hasNext()) {

					Publicaciones pub = it.next();
					if (pub instanceof Peliculas) {
						if ((fActual.get(Calendar.DAY_OF_YEAR) - ((Peliculas) pub).getAnio()) < 2) {
							mostrar = true;
						}
					}
				}
			}

			if (mostrar == true) {
				vaca.mostrarVaca(act.getApellido(), act.getNombre());

			}
		}
	}

	/**
	 * Carga en memoria los archivos de datos
	 * 
	 * @throws Exception
	 */
	public void inicializar_archivos() throws Exception {
		generos = daoGenero.recuperar_datos_archivo();
//		actores = daoActor.recuperar_datos_archivo();
		actores = daoActor.recuperar_datos_archivo_base();
		suscriptores = daoSuscripcion.recuperar_datos_archivo();
		Model.DAO.daoCalificaciones.setSuscriptores(suscriptores);
		Model.DAO.daoPublicaciones.setGeneros(generos);
		Model.DAO.daoPublicaciones.setActores(actores);
		publicaciones = daoPublicacion.recuperar_datos_archivo();

		for (Publicaciones publica : publicaciones) {
			daoCalificaciones dCali = new daoCalificaciones();

			publica.setCalificaciones(dCali.recuperar_datos_archivo(publica.getCodigo()));

		}
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
		case 9:
			actoresTematicos();
			break;
		case 10:
			seriesPorGenero();
			break;
		case 11:
			actricesActuales();
			break;
		case 12:
			datosPeliculaAlAzar();
			break;
		case 13:
			recomendarPelicula();
			break;
		case 14:
			recomendarSerie();
			break;
		case 15:
			mayoresSinClasificacion();
			break;
		case 16:
			seriesParaMayores();
			break;
		case 17:
			pelisPobres();
			break;
		case 18:
			publicacionesVencidas();
			break;
		case 20:
			daoPublicacion.limpiarArchivo();
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

	private int pedirIdPublicacion() {
		for (int i = 0; i < publicaciones.size(); i++) {
			VPublicaciones.mostrarEsta(i, publicaciones.get(i).getNombre());
		}
		return VPublicaciones.pedirId(publicaciones.size());
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

	/**
	 * Actualia los datos del genero.
	 *
	 * @throws Exception
	 */
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

	/**
	 * Crea un nuevo genero
	 *
	 * @throws IOException
	 */
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

	/**
	 * Elimina un genero del listado.
	 *
	 * @throws IOException
	 */
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

	/**
	 * Dependiendo la opcion muestra el listado de los datos cargados en el sistema.
	 *
	 * @param opcion
	 */
	private void listarListas(int opcion) {
		switch (opcion) {
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

	/**
	 * Pide el ingreso por teclado de los valores correspondientes a las peliculas y
	 * a las series para poder realiar el calendatio de pagos
	 */
	public void pedirValores() {
		VPeliSeri vista = new VPeliSeri();

		valorPelicla = vista.pedirValorPeliculas();
		valorSerie = vista.pedirValorSerie();
	}

	/**
	 * @return El valor de valorPelicla, es un dato de tipo float
	 */
	public float getValorPelicla() {
		return valorPelicla;
	}

	/**
	 * @param valorPelicla Que se seteara en valorPelicla
	 */
	public void setValorPelicla(float valorPelicla) {
		this.valorPelicla = valorPelicla;
	}

	/**
	 * @return El valor de valorSerie, es un dato de tipo float
	 */
	public float getValorSerie() {
		return valorSerie;
	}

	/**
	 * @param valorSerie Que se seteara en valorSerie
	 */
	public void setValorSerie(float valorSerie) {
		this.valorSerie = valorSerie;
	}

	/**
	 * @return El valor de montoTope, es un dato de tipo float
	 */
	public float getMontoTope() {
		return montoTope;
	}

	/**
	 * @param montoTope Que se seteara en montoTope
	 */
	public void setMontoTope(float montoTope) {
		this.montoTope = montoTope;
	}
}
