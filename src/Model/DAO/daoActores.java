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
import org.json.JSONObject;

import org.json.simple.parser.*;

import Model.Actores;

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

	@Override
	public void cargar_archivo(Actores dato) throws IOException {

		JSONObject autor = new JSONObject();

		autor = crearJSON(dato);

		String nombreArchivo = dato.getApellido() + "_" + dato.getNombre();

		cargarArchivoJSON(nombreArchivo, autor);
	}

	@Override
	public Actores conv_a_objeto(String[] datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Actores> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		// XXX Aca va el codigo en para armar un aray list de actores y retornarlos
		// tengo que reeleer el enunciado para ver si los actores estan en uno o en
		// varios archivos
		return null;
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
	 * @param json
	 * @return
	 */
	public Actores convertirJson_a_objeto(JSONObject json) {

		Actores actor = new Actores((String) json.get("name"), (String) json.get("apellido"),
				(boolean) json.get("sexo"));

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
}
