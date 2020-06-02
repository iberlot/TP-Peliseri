/**
 * 
 */
package Controler;

import Model.Generos;
import Vista.VGeneros;

/**
 * @author IVANB
 *
 */
public class CGeneros {

	private Generos modeloGeneros;
	private VGeneros vistaGeneros;
	
	
	public String getDescripciones() {
		return modeloGeneros.getDescripcion();
	}
	
	public void mostrarDescripciones() {
		vistaGeneros.mostrarDescrip(modeloGeneros.getDescripcion());
	}
	
	public void setDescripciones() {
		modeloGeneros.setDescripcion(vistaGeneros.pedirDescrip());
	}
	
	public int getCantidadTitulos() {
		return modeloGeneros.getCantidadTitulos();
	}
	
	public void mostrarCantidadTitulos() {
		vistaGeneros.mostrarCantidad(modeloGeneros.getCantidadTitulos());
	}
	
	public void setCantidadTitulos() {
		modeloGeneros.setCantidadTitulos(vistaGeneros.pedirCantidad());
	}
	
	public int getId() {
		return modeloGeneros.getId();
	}
	
	public void mostrarId() {
		vistaGeneros.mostrarID(modeloGeneros.getId());
	}
	
	public void setId() {
		modeloGeneros.setId(vistaGeneros.pedirID());
	}
	
}
