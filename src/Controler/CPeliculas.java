package Controler;

public class CPeliculas {

//	private int anio;
//	private float duracion;
	
	//
	
	public int GetAnio() {
		return modeloCalendario.getId();
	}
	
	public void mostrarAnio() {
		vistaCalendario.mostrarAnio(modeloCalendario.mostAnio());
	}
	
	public void setAnio() {
		modeloCalendario.setAnio(vistaCalendario.pedirAnio());
	}
	
	//
	
	public int getId() {
		return modeloCalendario.getId();
	}
	
	public void mostrarId() {
		vistaCalendario.mostrarCodigoID(modeloCalendario.mostId());
	}
	
	public void setId() {
		modeloCalendario.setIdD(vistaCalendario.pedirId());
	}
	
	//
}
