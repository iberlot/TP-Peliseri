/**
 * 
 */
package Controler;

/**
 * @author IVANB
 *
 */
public class CGeneros {

//	private int id;
//	private String descripcion;
//	private int CantidadTitulos;
	
	//
	
	public String getDescripciones() {
		return modeloGeneros.getDescripciones();
	}
	
	public void mostrarDescripciones() {
		vistaGeneros.mostrarDescripciones(modeloGeneros.getDescripciones());
	}
	
	public void setDescripciones() {
		modeloGeneros.setDescripciones(vistaGeneros.pedirDescripciones());
	}
	
	//
	
	public int getCantidadTitulos() {
		return modeloGeneros.getCantidadTitulos();
	}
	
	public void mostrarCantidadTitulos() {
		vistaGeneros.mostrarCodigoID(modeloGeneros.mostCantidadTitulos());
	}
	
	public void setCantidadTitulos() {
		modeloGeneros.setIdD(vistaGeneros.pedirCantidadTitulos());
	}
	
	//
	
	public int getId() {
		return modeloGeneros.getId();
	}
	
	public void mostrarId() {
		vistaGeneros.mostrarCodigoID(modeloGeneros.mostId());
	}
	
	public void setId() {
		modeloGeneros.setIdD(vistaGeneros.pedirId());
	}
	
}
