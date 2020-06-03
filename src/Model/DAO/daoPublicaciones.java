package Model.DAO;

import java.io.IOException;
import java.util.ArrayList;

// Sorry - descargue la libreria de https://mvnrepository.com/artifact/org.json/json/20190722
import Model.Episodios;
import Model.Generos;
import Model.Peliculas;
import Model.Publicaciones;

public class daoPublicaciones implements Idao<Publicaciones> {

	private static final String FILE = ARCHIVO + "Audiovisuales.txt";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1 };

	private static ArrayList<Generos> generos;

	@Override
	public void cargar_archivo(Publicaciones dato) throws IOException {

		try {
			if (dato instanceof Episodios) {
				daoEpisodios dao = new daoEpisodios();
				daoEpisodios.setGeneros(generos);
				dao.cargar_archivo((Episodios) dato);

			} else if (dato instanceof Peliculas) {
				daoPeliculas dao = new daoPeliculas();
				daoPeliculas.setGeneros(generos);
				dao.cargar_archivo((Peliculas) dato);
			} else {
				throw new Exception("Que paso aca?");
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

			pub.setActores(act.recuperar_datos_archivo());
			pub.setCalificaciones(cali.recuperar_datos_archivo(pub.getCodigo()));

			publicaciones.add(pub);
		}

		return publicaciones;
	}

	public void crearJSON(Publicaciones publicacion) throws IOException {
//		JSONObject myObject = new JSONObject();
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
	
}
