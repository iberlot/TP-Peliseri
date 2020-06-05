package Model.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.simple.JSONObject;

import Model.Actores;
import Model.Generos;
import Model.Peliculas;
import funciones.Archivos;
import funciones.Fechas;

public class daoPeliculas implements Idao<Peliculas> {

	private static final String FILE = ARCHIVO + "Audiovisuales.txt";
	private static final String DIREC = ARCHIVO + "Recomendaciones/Peliculas/";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1, 3, 25, 2 };

	private static ArrayList<Generos> generos;
	private static ArrayList<Actores> actores = new ArrayList<Actores>();

	@Override
	public void cargar_archivo(Peliculas dato) throws IOException {

		String[] info = new String[12];

		info[0] = Integer.toString(dato.getCodigo());
		info[1] = dato.getEmpresa();
		info[2] = dato.getFechaPubli().get(Calendar.DATE) + "/" + (dato.getFechaPubli().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFechaPubli().get(Calendar.YEAR);
		info[3] = Integer.toString(dato.getGenero().getId());
		info[4] = dato.getNombre();
		info[5] = dato.getSinopsis();
		info[6] = Integer.toString(dato.getAnio());
		info[7] = Integer.toString(dato.getDuracion());
		info[8] = Integer.toString(0);

		File archivo = new File(FILE);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);
	}

	@Override
	public Peliculas conv_a_objeto(String[] datos) throws Exception {
		for (Generos genero : generos) {
			if (genero.getId() == Integer.parseInt(datos[3])) {

				return new Peliculas(Integer.parseInt(datos[6]), Integer.parseInt(datos[7]), Integer.parseInt(datos[0]),
						datos[4], genero, datos[5], datos[1], Fechas.stringToCalendar(datos[2], "dd/M/yyyy"));
			}
		}
		throw new Exception("No exste el Genero");
	}

	@Override
	public ArrayList<Peliculas> recuperar_datos_archivo() throws Exception {

		ArrayList<Peliculas> peliculas = new ArrayList<>();

		ArrayList<String[]> pel = funciones.Archivos.traeLineasAnchoFijo(FILE, ANCHO);

		for (String[] datos : pel) {

			Peliculas peli = conv_a_objeto(datos);

			peliculas.add(peli);
		}

		return peliculas;
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
		daoPeliculas.generos = generos;
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
		daoPeliculas.actores = actores;
	}

	public void crearJSON(Peliculas peli, String nombreArchivo) throws IOException, ParseException {
		JSONObject myObject = new JSONObject();

		// Cadenas de texto básicas
		myObject.put("Empresa", peli.getEmpresa());
		myObject.put("Nombre", peli.getNombre());
		myObject.put("Genero", peli.getGenero().getDescripcion());

		JSONArray pas = new JSONArray();

		for (int i = 0; i < peli.getActores().size(); i++) {
			JSONObject actor = new JSONObject();

			actor.put("Apellido", peli.getActores().get(i).getApellido());
			actor.put("Nombre", peli.getActores().get(i).getNombre());
			actor.put("Sexo", peli.getActores().get(i).isSexo());

			pas.put(actor);
		}

		myObject.put("Actores", pas);

		myObject.put("Sinopsis", peli.getSinopsis());
		myObject.put("Ano", peli.getAnio());
		myObject.put("Calificacion", peli.promedioCalificacionesMes());

		File archivo = new File(DIREC + nombreArchivo);

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(myObject + "\t");

		fw.append("\n");
		fw.close();
	}

}
