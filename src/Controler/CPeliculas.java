package Controler;

import java.io.IOException;
import java.text.ParseException;

import Model.Peliculas;
import Model.DAO.daoPeliculas;
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

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		vistaPeliculas.mostrarElemento(modeloPeliculas.getAnio(), modeloPeliculas.getDuracion());
	}

	public void recomendarPeliMayor(long documento) throws IOException, ParseException {
		daoPeliculas dao = new daoPeliculas();
		dao.crearJSON(modeloPeliculas, Long.toString(documento));
	}

}
