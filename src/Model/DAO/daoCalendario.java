package Model.DAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import Model.Calendario;

public class daoCalendario implements Idao<Calendario> {

	private static final String FILE = ARCHIVO + "CronogramaPagos";

	private Calendar fActial = Calendar.getInstance();
	
	public void crearNuevoArchivo() throws IOException {

		File file = new File(getNombreArchivo());

		// Si el archivo no existe es creado
		if (!file.exists()) {
			file.createNewFile();
		}

	}

	@Override
	public void cargar_archivo(Calendario dato) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Calendario conv_a_objeto(String[] datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Calendario> recuperar_datos_archivo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	private String getNombreArchivo() {
		return FILE + fActial.get(Calendar.MONTH) + fActial.get(Calendar.YEAR) + ".txt";
	}
}
