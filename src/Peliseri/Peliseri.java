/**
 * 
 */
package Peliseri;

import funciones.Funciones;
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
//			System.out.println("Chupala");
			CPeliSeri base = new CPeliSeri();
//
//			base.setOPERADOR(Funciones.pedirString("Ingrese el operador: "));
//
			base.inicializar_archivos();
//
//			base.inicio();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
