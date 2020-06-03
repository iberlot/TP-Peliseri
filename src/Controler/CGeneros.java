/**
 * 
 */
package Controler;

import java.io.IOException;

import Model.Generos;
import Model.DAO.daoGeneros;
import Vista.VGeneros;

/**
 * @author IVANB
 *
 */
public class CGeneros {

	/**
	 * Constructor de la clase
	 *
	 * @param modeloGeneros
	 * @param vistaGeneros
	 */
	public CGeneros(Generos modeloGeneros, VGeneros vistaGeneros) {
		this.modeloGeneros = modeloGeneros;
		this.vistaGeneros = vistaGeneros;
	}

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

	public void mostrarDatos() {
		vistaGeneros.mostrarElemento(modeloGeneros.getCantidadTitulos(), modeloGeneros.getId(),
				modeloGeneros.getDescripcion());

	}

	public void modificar() throws Exception {
		vistaGeneros.mostrarID(modeloGeneros.getId());
		int n = vistaGeneros.pedirIDConf();
		if (n != -99) {
			modeloGeneros.setId(n);
		}
		vistaGeneros.mostrarDescrip(modeloGeneros.getDescripcion());
		String s = vistaGeneros.pedirDescripConf();
		if (s != null) {
			modeloGeneros.setDescripcion(s);
		}
	}

	public void grabar() throws IOException {

		daoGeneros dao = new daoGeneros();

		dao.cargar_archivo(modeloGeneros);
	}

	public void limpiarArchivo() throws IOException {
		daoGeneros dao = new daoGeneros();
		dao.limpiarArchivo();

	}

}
