package Model;

import java.util.Calendar;

public class Clasificaciones {

	private int calificacion;

	private String descripcion;

	private Suscriptores suscriptor;

	private Calendar fecha;

	public Clasificaciones() {
	}

	public Clasificaciones(int calificacion, String descripcion, Suscriptores suscriptor, Calendar fecha) {
		this.calificacion = calificacion;
		this.descripcion = descripcion;
		this.suscriptor = suscriptor;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Clasificaciones{" + "calificacion=" + calificacion + ", descripcion=" + descripcion + ", suscriptor="
				+ suscriptor + ", fecha=" + fecha + '}';
	}

	/**
	 * @return the calificacion
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the suscriptor
	 */
	public Suscriptores getSuscriptor() {
		return suscriptor;
	}

	/**
	 * @param suscriptor the suscriptor to set
	 */
	public void setSuscriptor(Suscriptores suscriptor) {
		this.suscriptor = suscriptor;
	}

	/**
	 * @return the fecha
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

}
