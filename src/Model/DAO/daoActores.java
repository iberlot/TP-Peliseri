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
 * @author IVANB
 *
 */
public class daoActores implements Idao<Actores> {

	private final String DIR = ARCHIVO+"Autores/";

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
		return null;
	}

	public Actores conv_a_objeto(String nombreArchivo) throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Reader reader = new FileReader(DIR+nombreArchivo);

		JSONObject autorJson = (JSONObject) parser.parse(reader);
		
		Actores actor = convertirJson_a_objeto(autorJson);
		
		return actor;
		
	}

	public Actores convertirJson_a_objeto(JSONObject json) {
		
		Actores actor = new Actores((String) json.get("name"), (String) json.get("apellido"), (boolean) json.get("sexo"));
			
		return actor;
		
	}
	
	public JSONObject crearJSON(Actores actor) {
		JSONObject myObject = new JSONObject();

		myObject.put("apellido", actor.getApellido());
		myObject.put("nombre", actor.getNombre());
		myObject.put("sexo", actor.isSexo());

		return myObject;
	}

	public void cargarArchivoJSON(String nombreArchivo, JSONObject autor) throws IOException {

		File archivo = new File(DIR + nombreArchivo);

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(autor + "\t");

		fw.append("\n");
		fw.close();
	}
}
