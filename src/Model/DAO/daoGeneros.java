/**
 * 
 */
package Model.DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Generos;
import funciones.Archivos;

/**
 * @author IVANB
 *
 */
public class daoGeneros implements Idao<Generos> {

	private static final String FILE = ARCHIVO + "Generos.txt";

	@Override
	public void cargar_archivo(Generos dato) throws IOException {

		File arch = new File(FILE);

		String[] info = new String[2];

		info[0] = Integer.toString(dato.getId());
		info[1] = dato.getDescripcion();

		Archivos.escribeCampoPuntoComa(arch, info);
	}

	@Override
	public Generos conv_a_objeto(String[] datos) throws Exception {
		return new Generos(Integer.parseInt(datos[0]), datos[1]);
	}

	@Override
	public ArrayList<Generos> recuperar_datos_archivo() throws Exception {

		ArrayList<Generos> generos = new ArrayList<>();

		ArrayList<String[]> gene = funciones.Archivos.traeLineasParceadas(FILE, ";");

		for (String[] datos : gene) {
			Generos gen = conv_a_objeto(datos);

			generos.add(gen);
		}

		return generos;
	}

	public void limpiarArchivo() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));

		bw.write("");

		bw.close();
	}

}
