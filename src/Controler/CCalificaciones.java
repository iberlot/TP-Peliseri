package Controler;
import java.util.Calendar;

import Model.Calendario;
import Model.Calificaciones;
import Model.Suscriptores;
import Vista.VCalendario;
import Vista.VCalificaciones;

public class CCalificaciones {

	private Calificaciones modeloCalificaciones;
	private VCalificaciones vistaCalificaciones;
	
	public int getCalificacion() {
		return modeloCalificaciones.getCalificacion();
	}
	
	public void mostrarCalificacion() {
		vistaCalificaciones.mostrarCalificacion((float) modeloCalificaciones.getCalificacion());
	}
	
	public void setCalificacion() {
		modeloCalificaciones.setCalificacion(vistaCalificaciones.pedirCalificacion());
	}
	
	public String getDescripcion() {
		return modeloCalificaciones.getDescripcion();
	}
	
	public void mostrarDescripcion() {
		vistaCalificaciones.mostrarDescripcion(modeloCalificaciones.getDescripcion());
	}
	
	public void setDescripcion() {
		modeloCalificaciones.setDescripcion(vistaCalificaciones.pedirDescripcion());
	}
	

	public Calendar getFecha (){
		return modeloCalificaciones.getFecha();
	}
	
	public void mostrarFecha0() {
		vistaCalificaciones.mostrarDescripcion(modeloCalificaciones.getDescripcion());
	}
	
	public void setDescripcion() {
		modeloCalificaciones.setDescripcion(vistaCalificaciones.pedirDescripcion());
	}
	

}


