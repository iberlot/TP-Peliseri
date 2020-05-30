package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Peliculas extends Publicaciones {

	private int anio;

	private float duracion;

	public Peliculas() {
	}

	public Peliculas(int codigo, String nombre, ArrayList<Generos> generos, String sinopsis, ArrayList<Actores> actores,
			String empresa, String publicacion, Calendar fechaPubli) {
		super(codigo, nombre, generos, sinopsis, actores, empresa, publicacion, fechaPubli);
	}

	public Peliculas(int anio, float duracion, int codigo, String nombre, ArrayList<Generos> generos, String sinopsis,
			ArrayList<Clasificaciones> clasificaciones, ArrayList<Actores> actores, String empresa, String publicacion,
			Calendar fechaPubli) {
		super(codigo, nombre, generos, sinopsis, clasificaciones, actores, empresa, publicacion, fechaPubli);
		this.anio = anio;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Peliculas{" + "anio=" + anio + ", duracion=" + duracion + '}';
	}

}
