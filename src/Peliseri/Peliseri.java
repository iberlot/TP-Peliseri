/**
 * 
 */
package Peliseri;

import Controler.CPeliSeri;

/**
 * @author iberlot
 *
 */
public class Peliseri {

	/**
	 * @param args the command line arguments
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {
			CPeliSeri base = new CPeliSeri();

			base.setMontoTope(Float.parseFloat(args[0]));
			base.inicializar_archivos();

			base.pedirValores();
			base.inicio();

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}

}
