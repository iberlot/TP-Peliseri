/**
 * 
 */
package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Episodios;
import Model.Generos;
import Model.Peliculas;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author IVANB
 *
 */
public class daoEpisodios implements Idao<Episodios> {

	private static final String FILE = ARCHIVO+"Audiovisuales.txt";

	private static final int[] ANCHO = { 4, 25, 10, 2, 25, 250, 4, 10, 1 };

	private static ArrayList<Generos> generos;
	
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
		info[7] = Float.toString(dato.getDuracion());
		info[8] = Integer.toString(0);
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
				
				return new Episodios(Integer.parseInt(datos[6]), Float.parseFloat(datos[7]), 
						Integer.parseInt(datos[0]), datos[4], genero, datos[5], datos[1], Fechas.stringToCalendar(datos[2], "dd/M/yyyy"),
						Integer.parseInt(datos[9]),datos[10],Integer.parseInt(datos[11]));	
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

}
