/**
 * 
 */
package Controler;
import Model.Episodios;
import Vista.VEpisodios;

/**
 * @author IVANB
 *
 */
public class CEpisodios extends CPublicaciones{
	
	private Episodios modeloEpisodios;
	private VEpisodios vistaEpisodios;
	
	public int getTemporada() {
		return modeloEpisodios.getTemporada();
	}
	
	public void mostrarTemporada() {
		vistaEpisodios.mostrarTemporada(modeloEpisodios.getTemporada());
	}
	
	public void setTemporada() {
		modeloEpisodios.setTemporada(vistaEpisodios.pedirTemporada());
	}
	
	
	public int getNroEpisodio() {
		return modeloEpisodios.getNroEpisodio();
	}
	
	public void mostrarNroEpisodio() {
		vistaEpisodios.mostrarNroEpisodio(modeloEpisodios.getNroEpisodio());
	}
	
	public void setNroEpisodio() {
		modeloEpisodios.setNroEpisodio(vistaEpisodios.pedirNroEpisodio());
	}
	
	//
	
	public int getAnio() {
		return modeloEpisodios.getAnio();
	}
	
	public void mostrarAnio() {
		vistaEpisodios.mostrarAnio(modeloEpisodios.getAnio());
	}
	
	public void setAnio() {
		modeloEpisodios.setAnio(vistaEpisodios.pedirAnio());
	}
	
	//
	
	public int getDuracion() {
		return modeloEpisodios.getDuracion();
	}
	
	public void mostrarDuracion() {
		vistaEpisodios.mostrarDuracion(modeloEpisodios.getDuracion());
	}
	
	public void setDuracion() {
		modeloEpisodios.setDuracion(vistaEpisodios.pedirDuracion());
	}
	
	//
	
	public String getSerie() {
		return modeloEpisodios.getSerie();
	}
	
	public void mostrarSerie() {
		vistaEpisodios.mostrarSerie(modeloEpisodios.getSerie());
	}
	
	public void setSerie() {
		modeloEpisodios.setSerie(vistaEpisodios.pedirSerie());
	}
}
