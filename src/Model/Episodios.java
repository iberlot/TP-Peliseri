package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import funciones.Fechas;

public class Episodios extends Publicaciones implements Comparable<Episodios> {

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

	public float promedioCalificacionesMenores() throws ParseException {
		float total = 0;
		int cantidad = 0;
		Calendar fActual = Calendar.getInstance();

		for (Iterator<Calificaciones> iterator = calificaciones.iterator(); iterator.hasNext();) {
			Calificaciones calificacion = iterator.next();
			if (Fechas.diferenciaDiasTotal(calificacion.getFecha(), fActual) < 91) {

				if (calificacion.getSuscriptor().getEdad() < 35) {
					cantidad++;
					total += calificacion.getCalificacion();
				}
			}
		}
		if (cantidad > 0) {
			total = total / cantidad;
		}
		return total;
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

	@Override
	public int compareTo(Episodios o) {
		return new Integer(temporada).compareTo(new Integer(o.getTemporada()));
	}

}
