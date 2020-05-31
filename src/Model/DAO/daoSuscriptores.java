/**
 * 
 */
package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Suscriptores;
import Model.DAO.Idao;
import funciones.Archivos;
import funciones.Fechas;

/**
 * @author iberlot
 *
 */
public class daoSuscriptores implements Idao<Suscriptores> {

	private static final String FILE = ARCHIVO + "Suscriptores.txt";

//	número de documento, nombre, apellido, fecha de nacimiento y sexo.
	private static final int[] ANCHO = { 10, 25, 25, 10, 5 };

	@Override
	public void cargar_archivo(Suscriptores dato) throws IOException {

		String[] info = new String[5];

		info[0] = Long.toString(dato.getDocumento());
		info[1] = dato.getApellido();
		info[2] = dato.getNombre();
		info[3] = dato.getFechaNac().get(Calendar.DATE) + "/" + (dato.getFechaNac().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFechaNac().get(Calendar.YEAR);

		info[4] = Boolean.toString(dato.isSexo());

		File archivo = new File(FILE);
		Archivos.escribeCamposAnchoFijo(archivo, info, ANCHO);
	}

	@Override
	public Suscriptores conv_a_objeto(String[] datos) throws Exception {
		return new Suscriptores(datos[2], datos[1], Long.parseLong(datos[0]), Boolean.parseBoolean(datos[4]),
				Fechas.stringToCalendar(datos[3], "dd/M/yyyy"));
	}

	@Override
	public ArrayList<Suscriptores> recuperar_datos_archivo() throws Exception {

		ArrayList<Suscriptores> suscriptoras = new ArrayList<>();


		ArrayList<String[]> suscr = funciones.Archivos.traeLineasAnchoFijo(FILE, ANCHO);

		for (String[] datos : suscr) {

			Suscriptores susc = conv_a_objeto(datos);

			suscriptoras.add(susc);
		}
		
		return suscriptoras;
	}

}
