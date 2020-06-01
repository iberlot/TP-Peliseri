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

import Model.Calificaciones;
import Model.Generos;
import Model.Publicaciones;
import Model.Suscriptores;
import funciones.Archivos;
import funciones.Fechas;

public class daoPublicaciones implements Idao<Publicaciones> {

	private static final String FILE = ARCHIVO+"Audiovisuales.txt";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250 };

	private static ArrayList<Generos> generos;
	
	@Override
	public void cargar_archivo(Publicaciones dato) throws IOException {

		String[] info = new String[6];

		info[0] = Integer.toString(dato.getCodigo());
		info[1] = dato.getEmpresa();
		info[2] = dato.getFechaPubli().get(Calendar.DATE) + "/" + (dato.getFechaPubli().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFechaPubli().get(Calendar.YEAR);
		info[3] = Integer.toString(dato.getGenero().getId());
		info[4] = dato.getNombre();
		info[5] = dato.getSinopsis();

		File archivo = new File(FILE);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);
	}

	@Override
	public Publicaciones conv_a_objeto(String[] datos) throws Exception {
//		for (Generos genero : generos) {
//			if (genero.getId() == Integer.parseInt(datos[3])) {
//				
//				return new Publicaciones();
////				return new Calificaciones(Integer.parseInt(datos[2]), datos[3], suscriptor,
////						Fechas.stringToCalendar(datos[0], "dd/M/yyyy"));
//			}
//		}
		throw new Exception("No exste el suscriptor");
	}

	@Override
	public ArrayList<Publicaciones> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void crearJSON(Publicaciones publicacion) throws IOException {
		JSONObject myObject = new JSONObject();
//
//		// Cadenas de texto básicas
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
}
