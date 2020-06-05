package Model.DAO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Actores;
// Sorry - descargue la libreria de https://mvnrepository.com/artifact/org.json/json/20190722
import Model.Episodios;
import Model.Generos;
import Model.Peliculas;
import Model.Publicaciones;
import funciones.Archivos;
import funciones.Fechas;

public class daoPublicaciones implements Idao<Publicaciones> {

	protected static final String FILE = ARCHIVO + "Audiovisuales.txt";

//	protected static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1 };
	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1, 3, 25, 2 };

	protected static ArrayList<Generos> generos = new ArrayList<Generos>();
	protected static ArrayList<Actores> actores = new ArrayList<Actores>();

	@Override
	public void cargar_archivo(Publicaciones dato) throws IOException {

		try {
			if (dato instanceof Episodios) {
				daoEpisodios dao = new daoEpisodios();
				daoEpisodios.setGeneros(generos);
				daoEpisodios.setActores(actores);
				dao.cargar_archivo((Episodios) dato);

			} else if (dato instanceof Peliculas) {
				daoPeliculas dao = new daoPeliculas();
				daoPeliculas.setGeneros(generos);
				daoPeliculas.setActores(actores);
				dao.cargar_archivo((Peliculas) dato);
			} else {
				throw new Exception("Que paso aca?");
			}

			Iterator<Actores> it = dato.getActores().iterator();

			while (it.hasNext()) {
				Actores actor = it.next();
				daoActores daoA = new daoActores();
				daoA.setPublicacion(dato.getCodigo());
				daoA.cargar_archivo(actor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Publicaciones conv_a_objeto(String[] datos) throws Exception {

		if (Integer.parseInt(datos[8]) == 0) {
			daoPeliculas dao = new daoPeliculas();
			daoPeliculas.setGeneros(generos);

			return dao.conv_a_objeto(datos);

		} else if (Integer.parseInt(datos[8]) == 1) {
			daoEpisodios dao = new daoEpisodios();
			daoEpisodios.setGeneros(generos);

			return dao.conv_a_objeto(datos);

		} else {
			throw new Exception("Que paso aca?");
		}
	}

	@Override
	public ArrayList<Publicaciones> recuperar_datos_archivo() throws Exception {

		ArrayList<Publicaciones> publicaciones = new ArrayList<>();
		daoActores act = new daoActores();
		daoCalificaciones cali = new daoCalificaciones();

		ArrayList<String[]> publi = funciones.Archivos.traeLineasAnchoFijo(FILE, ANCHO);

		for (String[] datos : publi) {
			Publicaciones pub = conv_a_objeto(datos);

			act.setPublicacion(pub.getCodigo());
// FIXME aca tengo que pasar a la clase el arrayList de actores ir comparando y agreando las del arraylist
			pub.setActores(act.recuperar_datos_archivo());
			pub.setCalificaciones(cali.recuperar_datos_archivo(pub.getCodigo()));

			publicaciones.add(pub);
		}

		return publicaciones;
	}

	public void crearJSON(Publicaciones publicacion) throws IOException {
//		JSONObject myObject = new JSONObject();
//
//		// Cadenas de texto b�sicas
//		myObject.put("ID", reserva.getIdVenta());
//		myObject.put("Fecha", reserva.getFecha());
//
//		JSONArray pas = new JSONArray();
//
//		for (int i = 0; i < reserva.getPasajes().size(); i++) {
//			JSONObject cliente = new JSONObject();
//
//			cliente.put("Documento", reserva.getPasajes().get(i).getCliente().getNdoc());
//			cliente.put("Apellido", reserva.getPasajes().get(i).getCliente().getApellido());
//			cliente.put("Nombre", reserva.getPasajes().get(i).getCliente().getNombre());
//			cliente.put("Sexo", reserva.getPasajes().get(i).getCliente().getSexo());
//
//			cliente.put("MasEquipaje", reserva.getPasajes().get(i).isMasEquipaje());
//			cliente.put("Preferencial", reserva.getPasajes().get(i).isPreferencial());
//
//			pas.put(cliente);
//		}
//
//		myObject.put("Clientes", pas);
//
//		myObject.put("NumeroVuelo", reserva.getPasajes().get(0).getVuelo().getNumero());
//
//		File archivo = new File("Archivos/jsons/reserva" + reserva.getIdVenta());
//
//		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
//
//		fw.append(myObject + "\t");
//
//		fw.append("\n");
//		fw.close();
	}

	/**
	 * Importante: Es para el uso exclusivo de un actor por archivo
	 * 
	 * @param nombreArchivo nombre del archivo que se va a abrir, el archivo debe
	 *                      encontrarse en el directorio definido.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Publicaciones> conv_a_objeto_dire() throws Exception {

		ArrayList<Publicaciones> publiqui = new ArrayList<Publicaciones>();

		String[] files = Archivos.getFilesDir(ARCHIVO + "Publicaciones/Nuevas");

		if (files != null) {

			for (int i = 0; i < files.length; i++) {

				Reader reader = new FileReader(files[i]);

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(reader);

				JSONObject publicacionJson = (JSONObject) obj;

				publiqui.add(convertirJson_a_objeto(publicacionJson));

				// FIXME arreglar luego. Tiene que mover el archivo a cargadas.
				String[] parts = files[i].split("-");

			}
		}
		return publiqui;

	}

	/**
	 * Tansforma un objeto de tipo json en uno de actores
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	public Publicaciones convertirJson_a_objeto(JSONObject json) throws IOException, JSONException, ParseException {

		Calendar fechaPubli = Calendar.getInstance();
		fechaPubli = Fechas.stringToCalendar(json.get("fechaPubli").toString(), "dd/MM/yyyy");

		daoActores dAct = new daoActores();
		ArrayList<Actores> actor = new ArrayList<Actores>();
		JSONArray act = (JSONArray) json.get("actores");

		int index = -1;
		for (int i = 0; i < generos.size(); i++) {
			if (generos.get(i).getDescripcion().equalsIgnoreCase(json.get("genero").toString())) {
				index = i;
			}
		}

		for (Object a : act) {
			Actores actors = dAct.convertirJson_a_objeto((JSONObject) a);

			int indice = -1;
			if (actores != null) {
				indice = actores.indexOf(actors);
			}

			if (indice != -1) {
				actor.add(actores.get(indice));
			} else {
				actores.add(actors);
				dAct.cargar_archivo(actors);

				actor.add(actores.get(actores.size() - 1));
			}
		}

		if (json.get("nroEpisodio") != null) {

			int an = Integer.parseInt(json.get("anio").toString());
			int dur = Integer.parseInt(json.get("duracion").toString());
			int cod = Integer.parseInt(json.get("codigo").toString());
			String nom = json.get("nombre").toString();
			String sin = json.get("sinopsis").toString();
			String emp = json.get("empresa").toString();

			int nr = Integer.parseInt(json.get("nroEpisodio").toString());
			String ser = json.get("serie").toString();
			int tem = Integer.parseInt(json.get("temporada").toString());

			Episodios publicacion = new Episodios(an, dur, cod, nom, generos.get(index), sin, emp, fechaPubli, nr, ser,
					tem);

			publicacion.setActores(actor);

			return publicacion;
		} else {
			int an = Integer.parseInt(json.get("anio").toString());
			int dur = Integer.parseInt(json.get("duracion").toString());
			int cod = Integer.parseInt(json.get("codigo").toString());
			String nom = json.get("nombre").toString();
			String sin = json.get("sinopsis").toString();
			String emp = json.get("empresa").toString();

			Peliculas publicacion = new Peliculas(an, dur, cod, nom, generos.get(index), sin, emp, fechaPubli);
			publicacion.setActores(actor);
//			System.out.println(publicacion);
			return publicacion;
		}

	}

	/**
	 * @return El valor de generos, es un dato de tipo ArrayList<Generos>
	 */
	public static ArrayList<Generos> getGeneros() {
		return generos;
	}

	/**
	 * @param generos Que se seteara en generos
	 */
	public static void setGeneros(ArrayList<Generos> generos) {
		daoPublicaciones.generos = generos;
	}

	public void limpiarArchivo() throws IOException {
//		BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));
//
//		bw.write("");
//
//		bw.close();
		File f = new File(FILE);

		if (f.delete()) {

			System.err.println("se limpio el archivo");
		}
		try {
			f.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		daoActores dAct = new daoActores();
		dAct.limpiarArchivo();
	}

	/**
	 * @return El valor de actores, es un dato de tipo ArrayList<Actores>
	 */
	public static ArrayList<Actores> getActores() {
		return actores;
	}

	/**
	 * @param actores Que se seteara en actores
	 */
	public static void setActores(ArrayList<Actores> actores) {
		daoPublicaciones.actores = actores;
	}

}
