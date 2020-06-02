package Controler;
import Model.Clasificaciones;
import Vista.VClasificaciones;

public class CClasificaciones {
	
	public int calificacion;
	public String descripcion;
	public Suscriptores suscriptor;
	public Calendar fecha;
	
	//
	
	public int getCalificacion1() {
		return modeloClasificaciones.getCalificacion();
	}
	
	public void mostrarCalificacion1() {
		vistaClasificaciones.Calificacion(modeloClasificaciones.setCalificacion());
	}
	
	public void setCalificacion1() {
		modeloClasificaciones.setClasificaciones(vistaClasificaciones.pedirCalificacion());
	}
	
	//
	
	public int getCalificacion1() {
		return modeloClasificaciones.getCalificacion();
	}
	
	public void mostrarCalificacion1() {
		vistaClasificaciones.Clasificaciones(modeloClasificaciones.setCalificacion1());
	}
	
	public void setCalificacion1() {
		modeloClasificaciones.setClasificaciones(vistaClasificaciones.pedirCalificacion1());
	}
	
	//
	
	public int getCalificacion() {
		return modeloClasificaciones.isSexo();
	}
	
	public void mostrarSexo() {
		vistaClasificaciones.Clasificaciones(modeloClasificaciones.isSexo());
	}
	
	public void setSexo() {
		modeloClasificaciones.setClasificaciones(vistaClasificaciones.pedirSexo());
	}
	
	//
	
}


