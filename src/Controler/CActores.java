/**
 * 
 */
package Controler;

import Model.Actores;
import Vista.VActores;

/**
 * @author IVANB
 *
 */
public class CActores {

	private Actores modeloActores;
	private VActores vistaActores;
	
	public boolean getSexo() {
		return modeloActores.isSexo();
	}
	
	public void mostrarSexo() {
		vistaActores.mostrarSexo(modeloActores.isSexo());
	}
	
	public void setSexo() {
		modeloActores.setSexo(vistaActores.pedirSexo());
	}
	
	//
	
	public String getApellido() {
		return modeloActores.getApellido();
	}
	
	public void mostrarApellido () {
		vistaActores.mostrarApellido(modeloActores.getApellido());
	}
	
	public void setApellido () {
		modeloActores.setApellido(vistaActores.pedirApellido());
	}

	//
	
	public String getNombre() {
		return modeloActores.getNombre();
	}
	
	public void mostrarNombre() {
		vistaActores.mostrarNombre(modeloActores.getNombre());
	}
	
	public void setNombre() {
		modeloActores.setNombre(vistaActores.pedirNombre());
	}


}
