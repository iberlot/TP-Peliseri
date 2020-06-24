/**
 * 
 */
package Vista;

import java.io.IOException;

/**
 * interfaz de las vistas para asegurarnos que todas tengan el conjunto basico
 * de funciones.
 * 
 * @author iberlot <@>
 *
 */
public interface iVistas {

	/**
	 * Pregunta si se desea crear un nuevo objeto
	 * 
	 * @return
	 * @throws IOException
	 */
	boolean crear() throws IOException;

	/**
	 * Pregunta si se desea eliminar un objeto
	 * 
	 * @return
	 * @throws IOException
	 */
	boolean eliminar() throws IOException;

	/**
	 * Pregunta si se desea modificar un objeto
	 * 
	 * @return
	 * @throws IOException
	 */
	boolean modificar() throws IOException;

	/**
	 * Muestra por pantalla un string que contiene la informacion del objeto. Ideal
	 * para utilizar junto a la funcion toString()
	 * 
	 * @param dato
	 * @throws IOException
	 */
	void mostrarElemento(String dato) throws IOException;
}
