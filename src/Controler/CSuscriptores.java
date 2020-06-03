/**
 * 
 */
package Controler;

import java.util.Calendar;

import Model.Suscriptores;
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
}
