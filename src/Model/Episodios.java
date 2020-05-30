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
}
