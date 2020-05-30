/**
 * 
 */
package Vista;

import funciones.Funciones;
import java.io.IOException;

/**
 * @author IVANB
 *
 */
public interface iVistas {

	boolean crear() throws IOException;

	boolean eliminar() throws IOException;

	boolean modificar() throws IOException;

	void mostrarElemento(String dato) throws IOException;
}
