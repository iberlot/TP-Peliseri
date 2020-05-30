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
}
