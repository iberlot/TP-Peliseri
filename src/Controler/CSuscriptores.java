/**
 * 
 */
package Controler;

import java.io.IOException;
import java.util.Calendar;

import Model.Suscriptores;
import Model.DAO.daoSuscriptores;
import Vista.VSuscriptores;

/**
 * @author IVANB
 *
 */
public class CSuscriptores {

	private Suscriptores modeloSuscriptores;
	private VSuscriptores vistaSuscriptores;

	/**
	 * Constructor de la clase
	 *
	 * @param modeloSuscriptores
	 * @param vistaSuscriptores
	 */
	public CSuscriptores(Suscriptores modeloSuscriptores, VSuscriptores vistaSuscriptores) {
		this.modeloSuscriptores = modeloSuscriptores;
		this.vistaSuscriptores = vistaSuscriptores;
	}

	public boolean getSexo() {
		return modeloSuscriptores.isSexo();
	}

	public void mostrarSexo() {
		vistaSuscriptores.mostrarSexo(modeloSuscriptores.isSexo());
	}

	public void setSexo() {
		modeloSuscriptores.setSexo(vistaSuscriptores.pedirSexo());
	}

	public String getApellido() {
		return modeloSuscriptores.getApellido();
	}

	public void mostrarApellido() {
		vistaSuscriptores.mostrarApellido(modeloSuscriptores.getApellido());
	}

	public void setApellido() {
		modeloSuscriptores.setApellido(vistaSuscriptores.pedirApellido());
	}

	public String getNombre() {
		return modeloSuscriptores.getNombre();
	}

	public void mostrarNombre() {
		vistaSuscriptores.mostrarNombre(modeloSuscriptores.getNombre());
	}

	public void setNombre() {
		modeloSuscriptores.setNombre(vistaSuscriptores.pedirNombre());
	}

	public Calendar getFechaNac() {
		return modeloSuscriptores.getFechaNac();
	}

	public void mostrarFechaNac() {
		vistaSuscriptores.mostrarFechaNac(modeloSuscriptores.getFechaNac());
	}

	public void setFechaNac() {
		modeloSuscriptores.setFechaNac(vistaSuscriptores.pedirFechaNac());
	}

	public Long getDocumento() {
		return modeloSuscriptores.getDocumento();
	}

	public void mostrarDocumento() {
		vistaSuscriptores.mostrarDocumento(modeloSuscriptores.getDocumento());
	}

	public void setDocumento() {
		modeloSuscriptores.setDocumento(vistaSuscriptores.pedirDocumento());
	}

	public void mostrarPersona() {
		vistaSuscriptores.mostrarElemento(modeloSuscriptores.getApellido(), modeloSuscriptores.getNombre(),
				modeloSuscriptores.isSexo(), null, 0);
	}

	public void mostrarDatos() {
		vistaSuscriptores.mostrarElemento(modeloSuscriptores.getApellido(), modeloSuscriptores.getNombre(),
				modeloSuscriptores.isSexo(), modeloSuscriptores.getFechaNac(), modeloSuscriptores.getDocumento());

	}

	public void modificar() {
		vistaSuscriptores.mostrarDocumento(modeloSuscriptores.getDocumento());
		long d = vistaSuscriptores.pedirDocumentoConf();
		if (d != -99) {
			modeloSuscriptores.setDocumento(d);
		}

		vistaSuscriptores.mostrarApellido(modeloSuscriptores.getApellido());
		String a = vistaSuscriptores.pedirApellidoConf();
		if (a != null) {
			modeloSuscriptores.setDocumento(d);
		}

		vistaSuscriptores.mostrarNombre(modeloSuscriptores.getNombre());
		String n = vistaSuscriptores.pedirNombreConf();
		if (n != null) {
			modeloSuscriptores.setNombre(n);
		}

		vistaSuscriptores.mostrarFechaNac(modeloSuscriptores.getFechaNac());
		Calendar f = vistaSuscriptores.pedirFechaNacConf();
		if (f != null) {
			modeloSuscriptores.setFechaNac(f);
		}

		vistaSuscriptores.mostrarSexo(modeloSuscriptores.isSexo());
		boolean s = vistaSuscriptores.pedirSexo();
		modeloSuscriptores.setSexo(s);
	}

	public void limpiarArchivo() throws IOException {
		daoSuscriptores dao = new daoSuscriptores();
		dao.limpiarArchivo();

	}

	public void grabar() throws IOException {

		daoSuscriptores dao = new daoSuscriptores();

		dao.cargar_archivo(modeloSuscriptores);
	}

}
