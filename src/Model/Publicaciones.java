package Model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Publicaciones {

	protected int codigo;

	protected String nombre;

	protected ArrayList<Generos> generos;

	protected String sinopsis;

	protected ArrayList<Clasificaciones> clasificaciones;

	protected ArrayList<Actores> actores;

	protected String empresa;

	protected String publicacion;

	protected Calendar fechaPubli;

	public Publicaciones() {
	}

	public Publicaciones(int codigo, String nombre, ArrayList<Generos> generos, String sinopsis,
			ArrayList<Actores> actores, String empresa, String publicacion, Calendar fechaPubli) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.generos = generos;
		this.sinopsis = sinopsis;
		this.actores = actores;
		this.empresa = empresa;
		this.publicacion = publicacion;
		this.fechaPubli = fechaPubli;
	}

	public Publicaciones(int codigo, String nombre, ArrayList<Generos> generos, String sinopsis,
			ArrayList<Clasificaciones> clasificaciones, ArrayList<Actores> actores, String empresa, String publicacion,
			Calendar fechaPubli) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.generos = generos;
		this.sinopsis = sinopsis;
		this.clasificaciones = clasificaciones;
		this.actores = actores;
		this.empresa = empresa;
		this.publicacion = publicacion;
		this.fechaPubli = fechaPubli;
	}

	@Override
	public String toString() {
		return "Publicaciones{" + "codigo=" + codigo + ", nombre=" + nombre + ", generos=" + generos + ", sinopsis="
				+ sinopsis + ", clasificaciones=" + clasificaciones + ", actores=" + actores + ", empresa=" + empresa
				+ ", publicacion=" + publicacion + ", fechaPubli=" + fechaPubli + '}';
	}

	public float promedioCalificaciones() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public int cantidadDeActores() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the generos
	 */
	public ArrayList<Generos> getGeneros() {
		return generos;
	}

	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(ArrayList<Generos> generos) {
		this.generos = generos;
	}

	/**
	 * @return the sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @param sinopsis the sinopsis to set
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * @return the clasificaciones
	 */
	public ArrayList<Clasificaciones> getClasificaciones() {
		return clasificaciones;
	}

	/**
	 * @param clasificaciones the clasificaciones to set
	 */
	public void setClasificaciones(ArrayList<Clasificaciones> clasificaciones) {
		this.clasificaciones = clasificaciones;
	}

	/**
	 * @return the actores
	 */
	public ArrayList<Actores> getActores() {
		return actores;
	}

	/**
	 * @param actores the actores to set
	 */
	public void setActores(ArrayList<Actores> actores) {
		this.actores = actores;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the publicacion
	 */
	public String getPublicacion() {
		return publicacion;
	}

	/**
	 * @param publicacion the publicacion to set
	 */
	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	/**
	 * @return the fechaPubli
	 */
	public Calendar getFechaPubli() {
		return fechaPubli;
	}

	/**
	 * @param fechaPubli the fechaPubli to set
	 */
	public void setFechaPubli(Calendar fechaPubli) {
		this.fechaPubli = fechaPubli;
	}

}
