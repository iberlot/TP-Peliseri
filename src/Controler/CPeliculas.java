package Controler;

import Model.Peliculas;
import Vista.VPeliculas;

public class CPeliculas extends CPublicaciones{
	
	private Peliculas modeloPeliculas;
	private VPeliculas vistaPeliculas;
	
	
	public int GetAnio() {
		return modeloPeliculas.getAnio();
	}
	
	public void mostrarAnio() {
		vistaPeliculas.mostrarAnio(modeloPeliculas.getAnio());
	}
	
	public void setAnio() {
		modeloPeliculas.setAnio(vistaPeliculas.pedirAnio());
	}
	
	public int getDuracion() {
		return modeloPeliculas.getDuracion();
	}
	
	public void mostrarId() {
		vistaPeliculas.mostrarDuracion(modeloPeliculas.getDuracion());
	}
	
	public void setId() {
		modeloPeliculas.setDuracion(vistaPeliculas.pedirDuracion());
	}
	
}
