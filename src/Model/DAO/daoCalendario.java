package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Calendario;
import funciones.Archivos;

public class daoCalendario implements Idao<Calendario> {

	private static final String FILE = ARCHIVO + "CronogramaPagos";

	private Calendar fActial = Calendar.getInstance();
	
	public void crearNuevoArchivo(int cantidad, float totalPagar) throws IOException {

		File file = new File(getNombreArchivo());

		// Si el archivo no existe es creado
		if (!file.exists()) {
			file.createNewFile();
		}

		String[] info = new String[5];

		info[0] = Integer.toString(cantidad);
		info[1] = Float.toString(totalPagar);

		Archivos.escribeCamposPipe(file, info);
	}

	@Override
	public void cargar_archivo(Calendario dato) throws IOException {

		File arch = new File(getNombreArchivo());
//		fecha de pago, nombre de la publicación, fecha de la publicación, monto a abonar,
		String[] info = new String[4];

		info[0] = dato.getFechaPago().get(Calendar.DATE) + "/" + (dato.getFechaPago().get(Calendar.MONTH) + 1) + "/"
				+ dato.getFechaPago().get(Calendar.YEAR);
		info[1] = dato.getPulic().getNombre();
		info[2] = dato.getPulic().getFechaPubli().get(Calendar.DATE) + "/" + (dato.getPulic().getFechaPubli().get(Calendar.MONTH) + 1) + "/"
				+ dato.getPulic().getFechaPubli().get(Calendar.YEAR);
		info[3] = Double.toString(dato.calculaMonto());
		
		Archivos.escribeCamposPipe(arch, info);
	}

	@Override
	public Calendario conv_a_objeto(String[] datos) throws Exception {
		// TODO Auto-generated method stub
		// XXX Creo que ahora no es necesario asi que veo si me alcanza el tiempo para implementarlo mas tarde
		return null;
	}

	@Override
	public ArrayList<Calendario> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		// XXX Creo que ahora no es necesario asi que veo si me alcanza el tiempo para implementarlo mas tarde
		return null;
	}

	
	private String getNombreArchivo() {
		return FILE + fActial.get(Calendar.MONTH) + fActial.get(Calendar.YEAR) + ".txt";
	}
}
