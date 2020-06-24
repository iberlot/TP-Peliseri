package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import funciones.Fechas;

public class Peliculas extends Publicaciones implements Comparable<Peliculas> {

	private int anio;

	private int duracion;

	public Peliculas() {
	}

	public Peliculas(int codigo, String nombre, Generos genero, String sinopsis, ArrayList<Actores> actores,
			String publicacion, Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, actores, fechaPubli);
	}

	public Peliculas(int anio, int duracion, int codigo, String nombre, Generos genero, String sinopsis,
			ArrayList<Calificaciones> calificaciones, ArrayList<Actores> actores, String publicacion,
			Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, calificaciones, actores, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	public Peliculas(int anio, int duracion, int codigo, String nombre, Generos genero, String sinopsis, String empresa,
			Calendar fechaPubli) {
		super(codigo, nombre, genero, sinopsis, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Publicaciones{" + "codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", sinopsis="
				+ sinopsis + ", clasificaciones=" + calificaciones + ", actores=" + actores + ", fechaPubli="
				+ fechaPubli + '}' + "Peliculas{" + "anio=" + anio + ", duracion=" + duracion + '}';
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

	@Override
	public int compareTo(Peliculas o) {

		return new Float(promedioCalificaciones()).compareTo(new Float(o.promedioCalificaciones()));
	}

	public float promedioCalificacionesMes() throws ParseException {
		float total = 0;
		int cantidad = 0;
		Calendar fActual = Calendar.getInstance();

		for (Iterator<Calificaciones> iterator = calificaciones.iterator(); iterator.hasNext();) {
			Calificaciones calificacion = iterator.next();
			if (Fechas.diferenciaDiasTotal(calificacion.getFecha(), fActual) < 30) {

				cantidad++;
				total += calificacion.getCalificacion();
			}

		}
		if (cantidad > 0) {
			total = total / cantidad;
		}
		return total;
	}

	@Override
	public boolean comprobarIguales(Publicaciones publicacion) {

		if (publicacion.getCodigo() != this.codigo) {
			return false;
		}

		if (!publicacion.getNombre().equalsIgnoreCase(this.nombre)) {
			return false;
		}

		if (!publicacion.getGenero().equals(this.genero)) {
			return false;
		}

		if (!publicacion.getSinopsis().equalsIgnoreCase(this.sinopsis)) {
			return false;
		}
//
//		for (Calificaciones calificacion : calificaciones) {
//
//		}
//		protected ArrayList<Calificaciones> calificaciones;
//
//		for (Actores actores2 : actores) {
//
//		}
//		protected ArrayList<Actores> actores;

		if (!publicacion.getFechaPubli().equals(this.fechaPubli)) {
			return false;
		}

		if (((Peliculas) publicacion).getAnio() != this.anio) {
			return false;

		}
		if (((Peliculas) publicacion).getDuracion() != this.duracion) {
			return false;

		}
		return true;
	}

}
