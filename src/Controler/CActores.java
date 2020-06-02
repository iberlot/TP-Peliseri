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
	

	public String getNombre() {
		return modeloActores.getNombre();
	}
	
	public void mostrarNombre() {
		vistaActores.mostrarNombre(modeloActores.getNombre());
	}
	
	public void setNombre(String nombre) {
		modeloActores.setNombre(vistaActores.pedirNombre());
	}


}
