package Model.DAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @file dao.java
 * @author iberlot <@> ivanberlot@gmail.com
 * @since 10 may. 2019
 * @version 0.1 - Version de inicio
 */

/*
 * Querido programador:
 *
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 *
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 *
 * totalHorasPerdidasAqui = 2
 *
 */

/**
 * @author iberlot <@> ivanberlot@gmail.com
 *
 * @param <T> Tipo de dato a utilizar en la clase
 */
public interface Idao<T> {

	/**
	 * Constante de la clase que contiene la direccion que se va a utilizar para el
	 * manejo de los archivos.
	 * 
	 * @var String
	 */
	String ARCHIVO = "Archivos/";

	/**
	 * Va a recibir un objeto convertirlo en un array de strings e insertarlo en un
	 * archivo, la forma de insercion va a depender de cada implementacion.
	 * 
	 * @param dato objeto a convertir en string e insertar en el archivo.
	 * @throws IOException
	 */
	void cargar_archivo(T dato) throws IOException;

	/**
	 * Va a recibir un array de Strings con un formato especifico de ubicacion de
	 * items y creara un objeto con estos datos, luego lo devolvera.
	 * 
	 * @param datos Array de string que contiene los posibles datos.
	 * @return Retorna un objeto del tipo especificado en la clase
	 * @throws Exception
	 */
	T conv_a_objeto(String[] datos) throws Exception;

	/**
	 * Recorre un archivo y crea una lista de objetos de los datos contenidos.
	 * 
	 * @return Lista de objetos del tipo requeridos
	 * @throws Exception
	 */
	ArrayList<T> recuperar_datos_archivo() throws Exception;
}
