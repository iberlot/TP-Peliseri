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

}
