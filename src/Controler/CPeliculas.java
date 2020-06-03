package Controler;

import Model.Peliculas;
import Vista.VPeliculas;
import Vista.VPublicaciones;

public class CPeliculas extends CPublicaciones {

	/**
	 * Constructor de la clase
	 *
	 * @param modeloPeliculas
	 * @param vistaPeliculas
	 */
	public CPeliculas(Peliculas modeloPeliculas, VPeliculas vistaPeliculas) {
		super(modeloPeliculas, new VPublicaciones());
		this.modeloPeliculas = modeloPeliculas;
		this.vistaPeliculas = vistaPeliculas;
	}

	private Peliculas modeloPeliculas;
	private VPeliculas vistaPeliculas;

	public int GetAnio() {
		return modeloPeliculas.getAnio();
	}

	public void mostrarAnio() {
		vistaPeliculas.mostrarAnio(modeloPeliculas.getAnio());
	}

	public void setAnio() {
		modeloPeliculas.setAnio(vistaPeliculas.pedirAnio());
	}

	public int getDuracion() {
		return modeloPeliculas.getDuracion();
	}

	public void mostrarId() {
		vistaPeliculas.mostrarDuracion(modeloPeliculas.getDuracion());
	}

	public void setId() {
		modeloPeliculas.setDuracion(vistaPeliculas.pedirDuracion());
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		vistaPeliculas.mostrarElemento(modeloPeliculas.getAnio(), modeloPeliculas.getDuracion());
	}

}
