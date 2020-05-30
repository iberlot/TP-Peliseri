package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Calendario implements iMontos {

	private int codigoID;

	private static int semPago;

	private float montoTotal;

	private Calendar fechaPago;

	private Publicaciones pulic;

	public Calendario() {
	}

	public Calendario(int codigoID, float montoTotal, Calendar fechaPago, Publicaciones pulic) {
		this.codigoID = codigoID;
		this.montoTotal = montoTotal;
		this.fechaPago = fechaPago;
		this.pulic = pulic;
	}

	@Override
	public String toString() {
		return "Calendario{" + "codigoID=" + codigoID + ", montoTotal=" + montoTotal + ", fechaPago=" + fechaPago
				+ ", pulic=" + pulic + '}';
	}

	public int codigo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int alto() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int medio() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int bajo() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public double calculaMonto() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	/**
	 * @return the codigoID
	 */
	public int getCodigoID() {
		return codigoID;
	}

	/**
	 * @param codigoID the codigoID to set
	 */
	public void setCodigoID(int codigoID) {
		this.codigoID = codigoID;
	}

	/**
	 * @return the semPago
	 */
	public static int getSemPago() {
		return semPago;
	}

	/**
	 * @param semPago the semPago to set
	 */
	public static void setSemPago(int semPago) {
		Calendario.semPago = semPago;
	}

	/**
	 * @return the montoTotal
	 */
	public float getMontoTotal() {
		return montoTotal;
	}

	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	/**
	 * @return the fechaPago
	 */
	public Calendar getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the pulic
	 */
	public Publicaciones getPulic() {
		return pulic;
	}

	/**
	 * @param pulic the pulic to set
	 */
	public void setPulic(Publicaciones pulic) {
		this.pulic = pulic;
	}

}
