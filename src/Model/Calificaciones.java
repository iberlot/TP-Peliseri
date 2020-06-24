package Model;

import java.util.Calendar;

public class Calificaciones {

	/**
	 * Calificacion que se le dio a la publicacion. Su valor maximo es 5
	 */
	private int calificacion;

	/**
	 * Breve comentario del motivo de la calificación propuesta.
	 */
	private String descripcion;

	/**
	 * Suscriptor que realizo la calificacion
	 */
	private Suscriptores suscriptor;

	/**
	 * Fecha que se realizo la calificacion
	 */
	private Calendar fecha;

	/**
	 * Constructor de la clase
	 *
	 */
	public Calificaciones() {
	}

	/**
	 * Constructor de la clase
	 *
	 * @param calificacion
	 * @param descripcion
	 * @param suscriptor
	 * @param fecha
	 */
	public Calificaciones(int calificacion, String descripcion, Suscriptores suscriptor, Calendar fecha) {
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
	 * @return El valor de calificacion, es un dato de tipo int
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion Que se seteara en calificacion
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return El valor de descripcion, es un dato de tipo String
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion Que se seteara en descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return El valor de suscriptor, es un dato de tipo Suscriptores
	 */
	public Suscriptores getSuscriptor() {
		return suscriptor;
	}

	/**
	 * @param suscriptor Que se seteara en suscriptor
	 */
	public void setSuscriptor(Suscriptores suscriptor) {
		this.suscriptor = suscriptor;
	}

	/**
	 * @return El valor de fecha, es un dato de tipo Calendar
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * @param fecha Que se seteara en fecha
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

}
