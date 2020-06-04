package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Peliculas extends Publicaciones {

	private int anio;

	private int duracion;

	public Peliculas() {
	}

	public Peliculas(int codigo, String nombre, Generos genero, String sinopsis, ArrayList<Actores> actores,
			String empresa, String publicacion, Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, actores, empresa, fechaPubli);
	}

	public Peliculas(int anio, int duracion, int codigo, String nombre, Generos genero, String sinopsis,
			ArrayList<Calificaciones> calificaciones, ArrayList<Actores> actores, String empresa, String publicacion,
			Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, calificaciones, actores, empresa, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	public Peliculas(int anio, int duracion, int codigo, String nombre, Generos genero, String sinopsis, String empresa,
			Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, empresa, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Publicaciones{" + "codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", sinopsis="
				+ sinopsis + ", clasificaciones=" + calificaciones + ", actores=" + actores + ", empresa=" + empresa
				+ ", fechaPubli=" + fechaPubli + '}' + "Peliculas{" + "anio=" + anio + ", duracion=" + duracion + '}';
	}

	/**
	 * @return the anio
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
