package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Calificaciones;
import Model.Suscriptores;
import funciones.Archivos;
import funciones.Fechas;

public class daoClasificaciones implements Idao<Calificaciones> {

	private static final String FILE = ARCHIVO+"Calificaciones.txt";
	
	/**
	 * XXX es muy sucio hacer esto???
	 * Se utiliza para buscar a los suscriptores e insertarlos en las calificaciones
	 */
	private static ArrayList<Suscriptores> suscriptores;
	
	
	@Override
	public void cargar_archivo(Calificaciones dato) throws IOException {

		File arch = new File(FILE);
		
		String[] info = new String[4];

		info[0] = dato.getFecha().get(Calendar.DATE) + "/" + (dato.getFecha().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFecha().get(Calendar.YEAR);
		info[1] = Long.toString(dato.getSuscriptor().getDocumento());
		info[2] = Integer.toString(dato.getCalificacion());
		info[3] = dato.getDescripcion();

		Archivos.escribeCampoPuntoComa(arch, info);
	}

	@Override
	public Calificaciones conv_a_objeto(String[] datos) throws Exception {
		for (Suscriptores suscriptor : suscriptores) {
			if (suscriptor.getDocumento()== Long.parseLong(datos[1])) {
				return new Calificaciones(Integer.parseInt(datos[2]), datos[3], suscriptor,Fechas.stringToCalendar(datos[0], "dd/M/yyyy"));
			}
		}
		throw new Exception("No exste el suscriptor");
	}

	@Override
	public ArrayList<Calificaciones> recuperar_datos_archivo() throws Exception {

		ArrayList<Calificaciones> calificaciones = new ArrayList<>();

		ArrayList<String[]> clasi = funciones.Archivos.traeLineasParceadas(FILE, ";");

		for (String[] datos : clasi) {

			Calificaciones clasific = conv_a_objeto(datos);

			calificaciones.add(clasific);
		}
		
		return calificaciones;
	}

}
