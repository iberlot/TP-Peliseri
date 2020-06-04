/**
 * 
 */
package Model.DAO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Actores;
import funciones.Archivos;

/**
 * DAO relacionado a los autores
 * 
 * @author IVANB
 *
 */
public class daoActores implements Idao<Actores> {

	/**
	 * Directorio donde se encontraran los archivos
	 */
	private final String DIR = ARCHIVO + "Autores/";

	private static final String ACTORES = ARCHIVO + "AudiovisualesActores.txt";

	private int publicacion;

	@Override
	public void cargar_archivo(Actores dato) throws IOException {

		String[] info = new String[9];

		info[0] = Integer.toString(publicacion);
		info[1] = dato.getApellido();
		info[2] = dato.getNombre();
		info[3] = Boolean.toString(dato.isSexo());

		File archivo = new File(ACTORES);
		Archivos.escribeCamposSepararPor(archivo, info, '\t');

//		JSONObject autor = new JSONObject();
//		autor = crearJSON(dato);
//		String nombreArchivo = dato.getApellido() + "_" + dato.getNombre();
//		cargarArchivoJSON(nombreArchivo, autor);
	}

	@Override
	public Actores conv_a_objeto(String[] datos) throws Exception {
		return new Actores(datos[1], datos[2], Boolean.parseBoolean(datos[3]));
	}

	@Override
	public ArrayList<Actores> recuperar_datos_archivo() throws Exception {

		ArrayList<Actores> actores = new ArrayList<>();

		ArrayList<String[]> act = funciones.Archivos.traeLineasParceadas(ACTORES, "\t");

		for (String[] datos : act) {
			if (Integer.parseInt(datos[0]) == publicacion) {
				Actores a = conv_a_objeto(datos);

				actores.add(a);
			}

		}

		return actores;
	}

	/**
	 * Recupera un listado unico de los autores
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Actores> recuperar_datos_listados() throws Exception {

		ArrayList<Actores> actores = new ArrayList<>();

		ArrayList<String[]> act = funciones.Archivos.traeLineasParceadas(ACTORES, "\t");

		for (String[] datos : act) {
			Actores a = conv_a_objeto(datos);

			if (actores.contains(a) == false) {

				actores.add(a);
			}

		}

		return actores;
	}

	/**
	 * Importante: Es para el uso exclusivo de un actor por archivo
	 * 
	 * @param nombreArchivo nombre del archivo que se va a abrir, el archivo debe
	 *                      encontrarse en el directorio definido.
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public Actores conv_a_objeto(String nombreArchivo) throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Reader reader = new FileReader(DIR + nombreArchivo);

		JSONObject autorJson = (JSONObject) parser.parse(reader);

		Actores actor = convertirJson_a_objeto(autorJson);

		return actor;

	}

	/**
	 * Tansforma un objeto de tipo json en uno de actores
	 * 
	 * @param a
	 * @return
	 */
	public Actores convertirJson_a_objeto(JSONObject a) {

		Actores actor = new Actores(a.get("nombre").toString(), a.get("apellido").toString(),
				Boolean.parseBoolean(a.get("sexo").toString()));

		return actor;

	}

	/**
	 * En base a los parametros de un actor genera un objeto de tipo JSON
	 * 
	 * @param actor
	 * @return
	 */
	public JSONObject crearJSON(Actores actor) {
		JSONObject myObject = new JSONObject();

		myObject.put("apellido", actor.getApellido());
		myObject.put("nombre", actor.getNombre());
		myObject.put("sexo", actor.isSexo());

		return myObject;
	}

	/**
	 * Agrega un json pasado a archivo
	 * 
	 * @param nombreArchivo nombre del archivo que se va a abrir, el archivo debe
	 *                      encontrarse en el directorio definido.
	 * @param autor
	 * @throws IOException
	 */
	public void cargarArchivoJSON(String nombreArchivo, JSONObject autor) throws IOException {

		File archivo = new File(DIR + nombreArchivo);

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(autor + "\t");

		fw.append("\n");
		fw.close();
	}

	/**
	 * @return El valor de publicacion, es un dato de tipo int
	 */
	public int getPublicacion() {
		return publicacion;
	}

	/**
	 * @param publicacion Que se seteara en publicacion
	 */
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

}
