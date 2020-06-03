package Controler;

import java.util.Calendar;

import Model.Calificaciones;
import Vista.VCalificaciones;

public class CCalificaciones {

	/**
	 * Constructor de la clase
	 *
	 * @param modeloCalificaciones
	 * @param vistaCalificaciones
	 */
	public CCalificaciones(Calificaciones modeloCalificaciones, VCalificaciones vistaCalificaciones) {
		this.modeloCalificaciones = modeloCalificaciones;
		this.vistaCalificaciones = vistaCalificaciones;
	}

	private Calificaciones modeloCalificaciones;
	private VCalificaciones vistaCalificaciones;

	public int getCalificacion() {
		return modeloCalificaciones.getCalificacion();
	}

	public void mostrarCalificacion() {
		vistaCalificaciones.mostrarCalificacion(modeloCalificaciones.getCalificacion());
	}

	public void setCalificacion() {
		modeloCalificaciones.setCalificacion(vistaCalificaciones.pedirCalificacion());
	}

	public String getDescripcion() {
		return modeloCalificaciones.getDescripcion();
	}

	public void mostrarDescripcion() {
		vistaCalificaciones.mostrarDescripcion(modeloCalificaciones.getDescripcion());
	}

	public void setDescripcion() {
		modeloCalificaciones.setDescripcion(vistaCalificaciones.pedirDescripcion());
	}

	public Calendar getFecha() {
		return modeloCalificaciones.getFecha();
	}

	public void mostrarFecha() {
		vistaCalificaciones.mostrarDescripcion(modeloCalificaciones.getDescripcion());
	}

	public void setFeca() {
		modeloCalificaciones.setFecha(vistaCalificaciones.pedirFecha());
	}

	public void mostrarDatos() {
		vistaCalificaciones
				.mostrarElemento(modeloCalificaciones.getFecha(), modeloCalificaciones.getCalificacion(),
						modeloCalificaciones.getSuscriptor().getApellido() + " "
								+ modeloCalificaciones.getSuscriptor().getNombre(),
						modeloCalificaciones.getDescripcion());

	}
}
