package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Generos;
import Model.Peliculas;
import Model.Publicaciones;
import Model.Suscriptores;
import funciones.Archivos;
import funciones.Fechas;

public class daoPeliculas implements Idao<Peliculas> {

	private static final String FILE = ARCHIVO+"Audiovisuales.txt";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1 };

	private static ArrayList<Generos> generos;
	
	@Override
	public void cargar_archivo(Peliculas dato) throws IOException {

		String[] info = new String[9];

		info[0] = Integer.toString(dato.getCodigo());
		info[1] = dato.getEmpresa();
		info[2] = dato.getFechaPubli().get(Calendar.DATE) + "/" + (dato.getFechaPubli().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFechaPubli().get(Calendar.YEAR);
		info[3] = Integer.toString(dato.getGenero().getId());
		info[4] = dato.getNombre();
		info[5] = dato.getSinopsis();
		info[6] = Integer.toString(dato.getAnio());
		info[7] = Float.toString(dato.getDuracion());
		info[8] = Integer.toString(0);

		File archivo = new File(FILE);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);
	}

	@Override
	public Peliculas conv_a_objeto(String[] datos) throws Exception {
		for (Generos genero : generos) {
			if (genero.getId() == Integer.parseInt(datos[3])) {
				
				return new Peliculas(Integer.parseInt(datos[6]), Float.parseFloat(datos[7]), 
						Integer.parseInt(datos[0]), datos[4], genero, datos[5], datos[1], Fechas.stringToCalendar(datos[2], "dd/M/yyyy"));	
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
}
