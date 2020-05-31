package Model.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

// Sorry - descargue la libreria de https://mvnrepository.com/artifact/org.json/json/20190722
import org.json.JSONObject;
import org.json.JSONArray;

import org.json.simple.parser.*;

import Model.Publicaciones;

public class daoPublicaciones implements Idao<Publicaciones> {

	@Override
	public void cargar_archivo(Publicaciones dato) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Publicaciones conv_a_objeto(String[] datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Publicaciones> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void crearJSON(Publicaciones publicacion) throws IOException {
		JSONObject myObject = new JSONObject();

		// Cadenas de texto básicas
		myObject.put("ID", reserva.getIdVenta());
		myObject.put("Fecha", reserva.getFecha());

		JSONArray pas = new JSONArray();

		for (int i = 0; i < reserva.getPasajes().size(); i++) {
			JSONObject cliente = new JSONObject();

			cliente.put("Documento", reserva.getPasajes().get(i).getCliente().getNdoc());
			cliente.put("Apellido", reserva.getPasajes().get(i).getCliente().getApellido());
			cliente.put("Nombre", reserva.getPasajes().get(i).getCliente().getNombre());
			cliente.put("Sexo", reserva.getPasajes().get(i).getCliente().getSexo());

			cliente.put("MasEquipaje", reserva.getPasajes().get(i).isMasEquipaje());
			cliente.put("Preferencial", reserva.getPasajes().get(i).isPreferencial());

			pas.put(cliente);
		}

		myObject.put("Clientes", pas);

		myObject.put("NumeroVuelo", reserva.getPasajes().get(0).getVuelo().getNumero());

		File archivo = new File("Archivos/jsons/reserva" + reserva.getIdVenta());

		FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);

		fw.append(myObject + "\t");

		fw.append("\n");
		fw.close();
	}
}
