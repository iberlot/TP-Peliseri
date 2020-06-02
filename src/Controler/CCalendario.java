package Controler;

import java.util.Calendar;

import Model.Calendario;
import Model.Publicaciones;
import Vista.VCalendario;

public class CCalendario {

	private Calendario modeloCalendario;
	private VCalendario vistaCalendario;
	
	//
	
	public int getCodigoID() {
		return modeloCalendario.getCodigoID();
	}
	
	public void mostrarCodigoID() {
		vistaCalendario.mostrarID(modeloCalendario.getCodigoID());
	}
	
	public void setCodigoID() {
		modeloCalendario.setCodigoID(vistaCalendario.pedirID());
	}
	
	//
	
	public float getMontoTotal() {
		return modeloCalendario.getMontoTotal();
	}
	
	public void mostrarMontoTotal() {
		vistaCalendario.mostrarMonto(modeloCalendario.mostMontoTotal());
	}
	
	public void setMontoTotal() {
		modeloCalendario.setMontoTotal(vistaCalendario.pedirMonto());
	}
	
	// 
	
	public Publicaciones getPulico() {
		return modeloCalendario.getPulic();
	}
//	
//	public void mostrarPulico() {
//		vistaCalendario.mostrarPubli(modeloCalendario.getPulic());
//	}
//	
//	public void setPulico() {
//		modeloCalendario.setPulic(vistaCalendario.pedirPubli());
//	}
	
	//
	
	public Calendar getFechaPago() {
		return modeloCalendario.getFechaPago();
	}
	
	public void mostrarFechaPago() {
		vistaCalendario.mostrarFPago(modeloCalendario.getFechaPago());
	}
	
	public void setFechaPago() {
		modeloCalendario.setFechaPago(vistaCalendario.pedirFPago());
	}
	
}
