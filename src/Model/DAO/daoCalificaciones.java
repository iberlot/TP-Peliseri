package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Calificaciones;
import Model.Suscriptores;
import funciones.Archivos;
import funciones.Fechas;

public class daoCalificaciones implements Idao<Calificaciones> {

	private static final String FILE = ARCHIVO + "Calificaciones.txt";

	/**
	 * XXX es muy sucio hacer esto??? Se utiliza para buscar a los suscriptores e
	 * insertarlos en las calificaciones
	 */
	private static ArrayList<Suscriptores> suscriptores;

	public void cargar_archivo(Calificaciones dato, int publicacion) throws IOException {

		File arch = new File(FILE);

		String[] info = new String[5];

		info[0] = dato.getFecha().get(Calendar.DATE) + "/" + (dato.getFecha().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFecha().get(Calendar.YEAR);
		info[1] = Long.toString(dato.getSuscriptor().getDocumento());
		info[2] = Integer.toString(dato.getCalificacion());
		info[3] = dato.getDescripcion();
		info[4] = Integer.toString(publicacion);

		Archivos.escribeCampoPuntoComa(arch, info);
	}

	@Override
	public Calificaciones conv_a_objeto(String[] datos) throws Exception {
		for (Suscriptores suscriptor : suscriptores) {
			if (suscriptor.getDocumento() == Long.parseLong(datos[1])) {
				return new Calificaciones(Integer.parseInt(datos[2]), datos[3], suscriptor,
						Fechas.stringToCalendar(datos[0], "dd/M/yyyy"));
			}
		}
		throw new Exception("No exste el suscriptor");
	}

	public ArrayList<Calificaciones> recuperar_datos_archivo(int publicacion) throws Exception {

		ArrayList<Calificaciones> calificaciones = new ArrayList<>();

		ArrayList<String[]> clasi = funciones.Archivos.traeLineasParceadas(FILE, ";");

		for (String[] datos : clasi) {
			if (Integer.parseInt(datos[4]) == publicacion) {
				Calificaciones clasific = conv_a_objeto(datos);

				calificaciones.add(clasific);
			}
		}

		return calificaciones;
	}

	@Override
	public void cargar_archivo(Calificaciones dato) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Calificaciones> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
