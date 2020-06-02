package Controler;

import java.util.Calendar;

import Model.Calendario;
import Model.Publicaciones;
import Vista.VCalendario;
import Vista.VPublicaciones;

public class CCalendario {

	private Calendario modeloCalendario;
	private VCalendario vistaCalendario;
	
	//
	
	public int getCodigoID() {
		return modeloCalendario.getCodigoID();
	}
	
	public void mostrarCodigoID() {
		vistaCalendario.mostrarCodigoID(modeloCalendario.mostCodigoID());
	}
	
	public void setCodigoID() {
		modeloCalendario.setCodigoID(vistaCalendario.pedirID());
	}
	
	//
	
	public float getMontoTotal() {
		return modeloCalendario.getMontoTotal();
	}
	
	public void mostrarMontoTotal() {
		vistaCalendario.mostrarMontoTotal(modeloCalendario.mostMontoTotal());
	}
	
	public void setMontoTotal() {
		modeloCalendario.setMontoTotal(vistaCalendario.pedirMonto());
	}
	
	//
	
	public Publicaciones getPulico() {
		return modeloCalendario.getPulic();
	}
	
	public void mostrarPulico() {
		vistaCalendario.mostrarPulico(modeloCalendario.getPulic());
	}
	
	public void setPulico() {
		modeloCalendario.setPulic(vistaCalendario.pedirPubli());
	}
	
	//
	
	public Calendar getFechaPago() {
		return modeloCalendario.getFechaPago();
	}
	
	public void mostrarFechaPago() {
		vistaCalendario.mostrarFechaPago(modeloCalendario.getFechaPago());
	}
	
	public void setFechaPago() {
		modeloCalendario.setFechaPago(vistaCalendario.pedirFPago());
	}
	
}
