/**
 * 
 */
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
import Model.Episodios;
import Model.Generos;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author IVANB
 *
 */
public class daoEpisodios implements Idao<Episodios> {

	private static final String FILE = ARCHIVO + "Audiovisuales.txt";
	private static final String DIREC = ARCHIVO + "Recomendaciones/Series/";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1, 3, 25, 2 };

	private static ArrayList<Generos> generos;
	private static ArrayList<Actores> actores = new ArrayList<Actores>();

	@Override
	public void cargar_archivo(Episodios dato) throws IOException {

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
		info[8] = Integer.toString(1);
		info[9] = Integer.toString(dato.getNroEpisodio());
		info[10] = dato.getSerie();
		info[11] = Integer.toString(dato.getTemporada());

		File archivo = new File(FILE);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);
	}

	@Override
	public Episodios conv_a_objeto(String[] datos) throws Exception {
		for (Generos genero : generos) {
			if (genero.getId() == Integer.parseInt(datos[3])) {

				int an = Integer.parseInt(datos[6]);
				int du = Integer.parseInt(datos[7]);
				int co = Integer.parseInt(datos[0]);
				String no = datos[4];
				String si = datos[5];
				String em = datos[1];
				Calendar fe = Fechas.stringToCalendar(datos[2], "dd/M/yyyy");
				int ep = Integer.parseInt(datos[9]);
				String se = datos[10];
				int tp = Integer.parseInt(datos[11]);

				return new Episodios(an, du, co, no, genero, si, em, fe, ep, se, tp);
			}
		}
		throw new Exception("No exste el Genero");
	}

	@Override
	public ArrayList<Episodios> recuperar_datos_archivo() throws Exception {

		ArrayList<Episodios> series = new ArrayList<>();

		ArrayList<String[]> ser = funciones.Archivos.traeLineasAnchoFijo(FILE, ANCHO);

		for (String[] datos : ser) {

			Episodios seri = conv_a_objeto(datos);

			series.add(seri);
		}

		return series;
	}

	public void crearJSON(Episodios episodio, String nombreArchivo) throws IOException, ParseException {
		JSONObject myObject = new JSONObject();

		// Cadenas de texto básicas
		myObject.put("Empresa", episodio.getEmpresa());
		myObject.put("Serie", episodio.getSerie());
		myObject.put("Genero", episodio.getGenero().getDescripcion());

		JSONArray pas = new JSONArray();

		for (int i = 0; i < episodio.getActores().size(); i++) {
			JSONObject actor = new JSONObject();

			actor.put("Apellido", episodio.getActores().get(i).getApellido());
			actor.put("Nombre", episodio.getActores().get(i).getNombre());
			actor.put("Sexo", episodio.getActores().get(i).isSexo());

			pas.put(actor);
		}

		myObject.put("Actores", pas);

		myObject.put("Sinopsis", episodio.getSinopsis());
		myObject.put("Temporada", episodio.getTemporada());
		myObject.put("Episodio", episodio.getNroEpisodio());
		myObject.put("Calificacion", episodio.promedioCalificacionesMenores());

		File archivo = new File(DIREC + nombreArchivo);

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(myObject + "\t");

		fw.append("\n");
		fw.close();
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
		daoEpisodios.generos = generos;
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
		daoEpisodios.actores = actores;
	}

}
