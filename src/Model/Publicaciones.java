package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public abstract class Publicaciones {

	protected int codigo;

	protected String nombre;

	protected Generos genero;

	protected String sinopsis;

	protected ArrayList<Calificaciones> calificaciones;

	protected ArrayList<Actores> actores;

	protected static final String EMPRESA = "PeliSeri";

	protected Calendar fechaPubli;

	protected Calendario fPago;

	public Publicaciones() {
	}

	public Publicaciones(int codigo, String nombre, Generos genero, String sinopsis, Calendar fechaPubli) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.fechaPubli = fechaPubli;
	}

	public Publicaciones(int codigo, String nombre, Generos genero, String sinopsis, ArrayList<Actores> actores,
			Calendar fechaPubli) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.fechaPubli = fechaPubli;
	}

	public Publicaciones(int codigo, String nombre, Generos genero, String sinopsis,
			ArrayList<Calificaciones> calificaciones, ArrayList<Actores> actores, Calendar fechaPubli) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.calificaciones = calificaciones;
		this.actores = actores;
		this.fechaPubli = fechaPubli;
	}

	@Override
	public String toString() {
		return "Publicaciones{" + "codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", sinopsis="
				+ sinopsis + ", clasificaciones=" + calificaciones + ", actores=" + actores + ", empresa=" + EMPRESA
				+ ", fechaPubli=" + fechaPubli + '}';
	}

	public float promedioCalificaciones() {
		float total = 0;
		int cantidad = 0;
		for (Iterator<Calificaciones> iterator = calificaciones.iterator(); iterator.hasNext();) {
			Calificaciones calificacion = iterator.next();
			cantidad++;
			total += calificacion.getCalificacion();

		}
		if (cantidad > 0) {
			total = total / cantidad;
		}
		return total;
	}

	public int cantidadDeActores() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return El valor de codigo, es un dato de tipo int
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo Que se seteara en codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return El valor de nombre, es un dato de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Que se seteara en nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El valor de genero, es un dato de tipo Generos
	 */
	public Generos getGenero() {
		return genero;
	}

	/**
	 * @param genero Que se seteara en genero
	 */
	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	/**
	 * @return El valor de sinopsis, es un dato de tipo String
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @param sinopsis Que se seteara en sinopsis
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * @return El valor de calificaciones, es un dato de tipo
	 *         ArrayList<Calificaciones>
	 */
	public ArrayList<Calificaciones> getCalificaciones() {
		return calificaciones;
	}

	/**
	 * @param calificaciones Que se seteara en calificaciones
	 */
	public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	/**
	 * @return El valor de actores, es un dato de tipo ArrayList<Actores>
	 */
	public ArrayList<Actores> getActores() {
		return actores;
	}

	/**
	 * @param actores Que se seteara en actores
	 */
	public void setActores(ArrayList<Actores> actores) {
		this.actores = actores;
	}

	/**
	 * @return El valor de empresa, es un dato de tipo String
	 */
	public String getEmpresa() {
		return EMPRESA;
	}

//	/**
//	 * @param empresa Que se seteara en empresa
//	 */
//	public void setEmpresa(String empresa) {
//		this.empresa = empresa;
//	}

	/**
	 * @return El valor de fechaPubli, es un dato de tipo Calendar
	 */
	public Calendar getFechaPubli() {
		return fechaPubli;
	}

	/**
	 * @param fechaPubli Que se seteara en fechaPubli
	 */
	public void setFechaPubli(Calendar fechaPubli) {
		this.fechaPubli = fechaPubli;
	}

	/**
	 * Esto seria una especie de implementacion de equals pero por parametros.
	 * comprueba que los dos objetos tengan los mismos atributos.
	 *
	 * @param publicacion
	 */
	public abstract boolean comprobarIguales(Publicaciones publicacion);

	/**
	 * @return el dato de fPago
	 */
	public Calendario getfPago() {
		return fPago;
	}

	/**
	 * @param fPago para cargar en fPago
	 */
	public void setfPago(Calendario fPago) {
		this.fPago = fPago;
	}

	public void agregarFPago(int codigoF, float monto, Calendar fechaPago) {
		this.fPago = new Calendario(codigoF, monto, fechaPago);
	}

	public Calificaciones nuevoComentario() {
		this.calificaciones.add(new Calificaciones());
		return this.calificaciones.get(calificaciones.size() - 1);
	}
}
