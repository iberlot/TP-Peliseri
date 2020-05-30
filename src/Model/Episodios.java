package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Episodios extends Publicaciones {

	private int temporada;

	private int nroEpisodio;

	private int anio;

	private int duracion;

	private String serie;

	private static int cantEpisodios;

	private static int canTemporadas;

	public Episodios() {
	}

	public Episodios(int codigo, String nombre, ArrayList<Generos> generos, String sinopsis, ArrayList<Actores> actores,
			String empresa, String publicacion, Calendar fechaPubli) {
		super(codigo, nombre, generos, sinopsis, actores, empresa, publicacion, fechaPubli);
	}

	@Override
	public String toString() {
		return "Episodios{" + "temporada=" + temporada + ", nroEpisodio=" + nroEpisodio + ", anio=" + anio
				+ ", duracion=" + duracion + ", serie=" + serie + '}';
	}

	public float promedioCalificaciones() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * @return the temporada
	 */
	public int getTemporada() {
		return temporada;
	}

	/**
	 * @param temporada the temporada to set
	 */
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	/**
	 * @return the nroEpisodio
	 */
	public int getNroEpisodio() {
		return nroEpisodio;
	}

	/**
	 * @param nroEpisodio the nroEpisodio to set
	 */
	public void setNroEpisodio(int nroEpisodio) {
		this.nroEpisodio = nroEpisodio;
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

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the cantEpisodios
	 */
	public static int getCantEpisodios() {
		return cantEpisodios;
	}

	/**
	 * @param cantEpisodios the cantEpisodios to set
	 */
	public static void setCantEpisodios(int cantEpisodios) {
		Episodios.cantEpisodios = cantEpisodios;
	}

	/**
	 * @return the canTemporadas
	 */
	public static int getCanTemporadas() {
		return canTemporadas;
	}

	/**
	 * @param canTemporadas the canTemporadas to set
	 */
	public static void setCanTemporadas(int canTemporadas) {
		Episodios.canTemporadas = canTemporadas;
	}
	
	
}
