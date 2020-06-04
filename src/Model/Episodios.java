package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Episodios extends Publicaciones {

	private int temporada;

	private int nroEpisodio;

	private int anio;

	private int duracion;

	private String serie;

	public Episodios() {
	}

	public Episodios(int codigo, String nombre, Generos genero, String sinopsis, ArrayList<Actores> actores,
			String empresa, String publicacion, Calendar fechaPubli, int nroEpisodio, String serie, int temporada) {
		super(codigo, nombre, genero, sinopsis, actores, empresa, fechaPubli);

		this.serie = serie;
		this.nroEpisodio = nroEpisodio;
		this.temporada = temporada;
	}

	public Episodios(int anio, int duracion, int codigo, String nombre, Generos genero, String sinopsis, String empresa,
			Calendar fechaPubli, int nroEpisodio, String serie, int temporada) {

		super(codigo, nombre, genero, sinopsis, empresa, fechaPubli);

		this.serie = serie;
		this.nroEpisodio = nroEpisodio;
		this.temporada = temporada;

	}

	@Override
	public String toString() {
		return "Episodios{" + "temporada=" + temporada + ", nroEpisodio=" + nroEpisodio + ", anio=" + anio
				+ ", duracion=" + duracion + ", serie=" + serie + '}';
	}

	@Override
	public float promedioCalificaciones() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return El valor de temporada, es un dato de tipo int
	 */
	public int getTemporada() {
		return temporada;
	}

	/**
	 * @param temporada Que se seteara en temporada
	 */
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	/**
	 * @return El valor de nroEpisodio, es un dato de tipo int
	 */
	public int getNroEpisodio() {
		return nroEpisodio;
	}

	/**
	 * @param nroEpisodio Que se seteara en nroEpisodio
	 */
	public void setNroEpisodio(int nroEpisodio) {
		this.nroEpisodio = nroEpisodio;
	}

	/**
	 * @return El valor de anio, es un dato de tipo int
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * @param anio Que se seteara en anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * @return El valor de duracion, es un dato de tipo int
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion Que se seteara en duracion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return El valor de serie, es un dato de tipo String
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie Que se seteara en serie
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

}
