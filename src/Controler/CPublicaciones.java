package Controler;

import java.io.IOException;
import java.util.Calendar;

import Model.Publicaciones;
import Model.DAO.daoPublicaciones;
import Vista.VPublicaciones;

public class CPublicaciones {

	private Publicaciones modeloPublicaciones;
	private VPublicaciones vistaPublicaciones;

	/**
	 * Constructor de la clase
	 *
	 * @param modeloPublicaciones
	 * @param vistaPublicaciones
	 */
	public CPublicaciones(Publicaciones modeloPublicaciones, VPublicaciones vistaPublicaciones) {
		this.modeloPublicaciones = modeloPublicaciones;
		this.vistaPublicaciones = vistaPublicaciones;
	}

	public int getCodigo() {
		return modeloPublicaciones.getCodigo();
	}

	public void mostrarCodigo() {
		vistaPublicaciones.mostrarCodigo(modeloPublicaciones.getCodigo());
	}

	public void setCodigo() {
		modeloPublicaciones.setCodigo(vistaPublicaciones.pedirCodigo());
	}

	public String getEmpresa() {
		return modeloPublicaciones.getEmpresa();
	}

	public void mostrarEmpresa() {
		vistaPublicaciones.mostrarEmpresa(modeloPublicaciones.getEmpresa());
	}

	public void setEmpresa() {
		modeloPublicaciones.setEmpresa(vistaPublicaciones.pedirEmpresa());
	}

	public Calendar getFechaPubli() {
		return modeloPublicaciones.getFechaPubli();
	}

	public void mostrarFechaPubli() {
		vistaPublicaciones.mostrarFechaPubli(modeloPublicaciones.getFechaPubli());
	}

	public void setFechaPubli() {
		modeloPublicaciones.setFechaPubli(vistaPublicaciones.pedirFechaPubli());
	}

	public String getNombre() {
		return modeloPublicaciones.getNombre();
	}

	public void mostrarnombre() {
		vistaPublicaciones.mostrarNombre(modeloPublicaciones.getNombre());
	}

	public void setnombre() {
		modeloPublicaciones.setNombre(vistaPublicaciones.pedirNombre());
	}

	public String getSinopsis() {
		return modeloPublicaciones.getSinopsis();
	}

	public void mostrarSinopsis() {
		vistaPublicaciones.mostrarSinopsis(modeloPublicaciones.getSinopsis());
	}

	public void setSinopsis() {
		modeloPublicaciones.setSinopsis(vistaPublicaciones.pedirSinopsis());
	}

	public void mostrarDatos() {
		vistaPublicaciones.mostrarElemento(modeloPublicaciones.getCodigo(), modeloPublicaciones.getNombre(),
				modeloPublicaciones.getEmpresa(), modeloPublicaciones.getFechaPubli(),
				modeloPublicaciones.getGenero().getDescripcion(), modeloPublicaciones.getSinopsis());
	}

	public void grabar() throws IOException {

		daoPublicaciones dao = new daoPublicaciones();

		dao.cargar_archivo(modeloPublicaciones);
	}
}
