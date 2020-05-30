package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Peliculas extends Publicaciones {

	private int anio;

	private float duracion;

	public Peliculas() {
	}

	public Peliculas(int codigo, String nombre, Generos genero, String sinopsis, ArrayList<Actores> actores,
			String empresa, String publicacion, Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, actores, empresa, publicacion, fechaPubli);
	}

	public Peliculas(int anio, float duracion, int codigo, String nombre, Generos genero, String sinopsis,
			ArrayList<Clasificaciones> clasificaciones, ArrayList<Actores> actores, String empresa, String publicacion,
			Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, clasificaciones, actores, empresa, publicacion, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Peliculas{" + "anio=" + anio + ", duracion=" + duracion + '}';
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
	public float getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

}
