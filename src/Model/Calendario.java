package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Calendario implements iMontos {

	/**
	 * Codigo de identificacion del elemento del calendario de pagos
	 */
	private int codigoID;

	/**
	 * Proxima semana de pago disponible
	 */
	private static int semPago;

	/**
	 * Monto a pagar
	 */
	private float montoTotal;

	/**
	 * Fecha en la que se realizara el pago
	 */
	private Calendar fechaPago;

	/**
	 * Publicacion que se va a abonar
	 */
	private Publicaciones pulic;

	/**
	 * Constructor de la clase
	 */
	public Calendario() {
	}

	/**
	 * Constructor de la clase con los parametros correspondientes.
	 * 
	 * @param codigoID
	 * @param montoTotal
	 * @param fechaPago
	 * @param pulic
	 */
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

	/**
	 * @return
	 */
	public int codigo() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	// FIXME No me gusta la implementacion de esta interfaz =( la quitaria y le
	// preguntaria a angy si con las interfaz del dao y la vista alcanza
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

	public float mostMontoTotal() {
		return codigoID;
		// TODO Auto-generated method stub
	}

	public int mostCodigoID() {
		return codigoID;
		// TODO Auto-generated method stub
	}

}
